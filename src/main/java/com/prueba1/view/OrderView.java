package com.prueba1.view;

import javax.swing.*;

import com.prueba1.model.Article;
import com.prueba1.model.Order;
import java.awt.*;
import java.util.List; 
import java.text.NumberFormat;   //permite mostrar cantidades como importes monetarios.
import java.util.Locale;          //permite indicar el formato de cada moneda. Utilizaremos formato estadounidense para dólares y alemán para euros.

public class OrderView extends JFrame {
    private JTextField searchField = new JTextField(10);
    private JButton searchButton = new JButton("Search");
    private JButton createButton = new JButton("Create Order"); //Boton para crear pedido

    private JTextArea resultArea = new JTextArea(10, 40);
    private JTextArea ordersArea = new JTextArea(8, 15); //es para tener una lista de los pedidos


    public OrderView() {
        setTitle("Order Management");

                java.net.URL iconURL = getClass().getResource("/app.png");  //con estas 4 lineas consigo añadir como imagen de la aplicación el icono que se encuentra en la carpeta resources

        if (iconURL != null) {
            ImageIcon icon = new ImageIcon(iconURL);
            setIconImage(icon.getImage());
    }
     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        //add new JLabel("Order ID:"); 
        //add to view the search field
        // add to view the search button
        // add to view the result area inside a JScrollPane
        add(new JLabel("Available Orders:"));
        ordersArea.setEditable(false);
        add(new JScrollPane(ordersArea));

        add(new JLabel("Order ID:"));
        add(searchField);
        add(createButton);
        add(searchButton);
        add(new JScrollPane(resultArea));
       
        pack();

        setVisible(true);
    }

    public String getSearchId() {
        //...
        return searchField.getText();
    }

    public JButton getSearchButton() {
        //...
        return searchButton;
        
    }
    public JButton getCreateButton() {
    return createButton;
    }  

    public void displayOrder(Order order, double rate, String rateDate) {      //añado otro argumento al metodo displayOrder para que reciba el tipo de cambio y la fecha del tipo de cambio
        //Display order details in resultArea
         String texto = "Order " + order.getIdPedido() + ":\n\n";

    double totalBruto = 0;
    double totalDescuento = 0;

    NumberFormat usdFormat = NumberFormat.getCurrencyInstance(Locale.US);   //mostrará cantidades como $100.00
    NumberFormat eurFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);   //mostrará cantidades como 100,00 €.

    for (Article articulo : order.getArticles()) {

        double bruto = articulo.getGrossAmount(articulo.getCantidad(),articulo.getPrecio());
        double descuento = articulo.getDiscountedAmount(bruto,articulo.getDescuento());

        totalBruto += bruto;
        totalDescuento += descuento;

        texto += articulo.getNombre()
        + " x" + articulo.getCantidad()
        + " @ " + usdFormat.format(articulo.getPrecio())
        + " (discount " + articulo.getDescuento() + "%)"
        + " = " + usdFormat.format(descuento) + "\n";
    }
    if (rate <= 0) {
    throw new IllegalArgumentException("Invalid exchange rate");
    }
    double totalEuros = totalDescuento / rate;   //convierto el total en dólares a euros dividiendo entre el tipo de cambio.

    texto += "\nGross total: " + usdFormat.format(totalBruto);
    texto += "\nDiscounted total (USD): " + usdFormat.format(totalDescuento);
    texto += "\nDiscounted total (EUR): " + eurFormat.format(totalEuros);

    texto += "\n\nExchange rate: 1 EUR = "
        + String.format(Locale.US, "%.4f", rate) + " USD";

    texto += "\nRate date: " + rateDate;

    resultArea.setText(texto);
  }
  public void loadOrders(List<Order> orders) {

    StringBuilder text = new StringBuilder();

    for (Order order : orders) {
        text.append(order.getIdPedido())
            .append("\n");
    }

    ordersArea.setText(text.toString());
}
}

