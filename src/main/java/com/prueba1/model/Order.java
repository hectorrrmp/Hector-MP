package com.prueba1.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Order {
    
    @JsonProperty("id")
    private String idPedido; 
    @JsonProperty("articles")
    private List<Article> articlulos;
     
    public Order() {
    }

    public Order(String idPedido , List<Article> articlulos) {
        this.idPedido = idPedido;
        this.articlulos = articlulos;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public List<Article> getArticulos() {
        return articlulos;
    }
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }
    public void setArticulos(List<Article> articlulos) {
        this.articlulos = articlulos;
    }
    public double getGrossTotal(List<Double> amounts) {
        double total = 0;
        for (double amount : amounts) {
            total += amount;
        }
        return total;
    }
    public double getDiscountedTotal(double grossTotal, double discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("El descuento tiene que ser del 0 al 100%");
        }
        return grossTotal - (grossTotal * discount / 100.0);
    }
    
}
