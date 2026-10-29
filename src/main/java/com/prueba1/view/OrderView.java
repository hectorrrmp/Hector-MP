package com.prueba1.view;

import javax.swing.*;

import com.prueba1.model.Article;
import com.prueba1.model.Order;
import java.awt.*;

public class OrderView extends JFrame {
    private JTextField searchField = new JTextField(10);
    private JButton searchButton = new JButton("Search");
    private JTextArea resultArea = new JTextArea(10, 40);

    public OrderView() {
        setTitle("Order Management");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        //add new JLabel("Order ID:");
        //add to view the search field
        // add to view the search button
        // add to view the result area inside a JScrollPane
        add(new JLabel("Order ID:"));
        add(searchField);
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

    public void displayOrder(Order order, double rate) {
        //Display order details in resultArea
         String texto = "Order " + order.getIdPedido() + ":\n\n";

    double totalBruto = 0;
    double totalDescuento = 0;

    for (Article articulo : order.getArticulos()) {

        double bruto = articulo.getGrossAmount(articulo.getCantidad(),articulo.getPrecio());
        double descuento = articulo.getDiscountedAmount(bruto,articulo.getDescuento());

        totalBruto += bruto;
        totalDescuento += descuento;

        texto += articulo.getNombre()
                + " x" + articulo.getCantidad()
                + " @ " + articulo.getPrecio() + "$"
                + " (discount " + articulo.getDescuento() + "%)"
                + " = " + descuento + "$\n";
    }

    texto += "\nGross total: " + totalBruto + "$";
    texto += "\nDiscounted total: " + totalDescuento + "$";

    resultArea.setText(texto);
  }
}
