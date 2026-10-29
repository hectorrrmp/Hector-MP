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

public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    //Atributo de clase OrderView
    private OrderView view;
    //Lista de orders
    private List<Order> orders;
    //Atributo de clase Searcher
    private Searcher searcher;

    public OrderController(OrderView view, List<Order> orders) {
        //Initialize attributes
        this.view = view;
        this.orders = orders;
        this.searcher = new Searcher();
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
        ;

        for (Order order : orders) {

            if (order.getIdPedido().equals(id)) {
                JOptionPane.showMessageDialog(view, "Pedido encontrado");
                view.displayOrder(order, 0);
                return;
            }
        }

        JOptionPane.showMessageDialog(view, "Order not found.");
    }
        //... display order if found, else display "Order not found."
    
}
