package com.prueba1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prueba1.Main;
import com.prueba1.model.Order;
import com.prueba1.Searcher;
import com.prueba1.view.OrderView;

import java.util.concurrent.ExecutionException;     //permite manejar excepciones que pueden ocurrir durante la ejecución de un hilo en segundo plano
import javax.swing.SwingWorker;   //lo uso para consultar la API de Frankfurter en un hilo separado y no bloquear la interfaz de usuario

import com.prueba1.service.ExchangeRateService;   //esta es la clase que se encarga del cambio de la moneda
import com.prueba1.service.ExchangeRateService.ExchangeRate;     //se usa para obtener el tipo de cambio actual entre EUR y USD

public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    //Atributo de clase OrderView
    private OrderView view;
    //Lista de orders
    private List<Order> orders;
    //Atributo de clase Searcher
    private Searcher searcher;

    private ExchangeRateService exchangeRateService;   //lo pongo para que el controlador tenga acceso al servicio que consulta el cambio de la moneda

    public OrderController(OrderView view, List<Order> orders) {
        //Initialize attributes
        this.view = view;
        this.orders = orders;
        this.searcher = new Searcher();
        this.exchangeRateService = new ExchangeRateService();  //para que se inicie 
        //Adding action listener to the search button, call searchOrder on click
        //...
        view.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchOrder();
            }
        });
    }

    private void searchOrder() {
        String id = view.getSearchId();
        

        for (Order order : orders) {

            if (order.getIdPedido().equals(id)) {
 
                Order orderToDisplay = order;     // Guardo el pedido encontrado en una variable que utilizaremos después para mostrarlo cuando termine la consulta a Frankfurter.
                
                view.getSearchButton().setEnabled(false);   //deshabilito el botón de búsqueda mientras se realiza la consulta a Frankfurter para evitar que el usuario haga clic varias veces y se generen múltiples consultas simultáneas.
                
                         SwingWorker<ExchangeRate, Void> worker =  new SwingWorker<ExchangeRate, Void>() {  //esto crea un hilo(tarea) que se ejecuta en segundo plano
                    @Override
                    protected ExchangeRate doInBackground() throws Exception {          //llama al servicio ExchangeRateService y obtiene el tipo de cambio.
                        return exchangeRateService.getExchangeRate();
                    }
                    @Override
                    protected void done() {   //se ejecutará cuando termine la consulta
                         try {
                            ExchangeRate exchangeRate = get();        //recoge el resultado que ha devuelto Frankfurter
                            view.displayOrder(
                                    orderToDisplay,
                                    exchangeRate.rate(),
                                    exchangeRate.date().toString()
                            );

                        } catch (InterruptedException e) {             //controla si se interrumpe la consulta. si ocurre salta el log del tipo error
                            Thread.currentThread().interrupt();
                            log.error("Exchange rate request interrupted", e);

                        } catch (ExecutionException e) {                    //controla si se produce un error al consultar la API.
                            log.error("Error obtaining exchange rate", e);

                        } finally {              //vuelve a activar el botón de búsqueda, tanto si todo funciona como si ocurre un error. para poder volver a intentar la búsqueda.
                            view.getSearchButton().setEnabled(true);
                        }
                    }
                };
                worker.execute();
                return;
            }
        }

        JOptionPane.showMessageDialog(view, "Order not found.");
    }
        //... display order if found, else display "Order not found."
    
}
