package com.prueba1.model;
import java.util.List;
import com.prueba1.Calculator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Order {
    
    @JsonProperty("id")
    private String idPedido; 
    @JsonProperty("articles")
    private List<Article> articles;
    public Order() {
    }

    public Order(String idPedido , List<Article> articles) {
        this.idPedido = idPedido;
        this.articles = articles;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public List<Article> getArticles() {
        return articles;
    }
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }
    public void setArticles(List<Article> articles) {
        this.articles = articles;
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
