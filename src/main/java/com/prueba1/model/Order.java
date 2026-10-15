package com.prueba1.model;
import java.util.List;
import com.prueba1.Calculator;
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
        Calculator calculator = new Calculator();
        return calculator.calculateTotal(amounts);
    }
   
    public double getDiscountedTotal(double grossTotal, double discount) {
        Calculator calculator = new Calculator();
        return calculator.discount(grossTotal, discount);
    }
    
}
