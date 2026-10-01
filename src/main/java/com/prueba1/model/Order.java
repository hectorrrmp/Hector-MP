package com.prueba1.model;
import java.util.List;
import java.util.ArrayList;

public class Order {
    
    private String idPedido; 
    private List<String> articlulos = new ArrayList<>();
    

    public Order(String idPedido , List<String> articlulos) {
        this.idPedido = idPedido;
        this.articlulos = articlulos;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public List<String> getArticulos() {
        return articlulos;
    }
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }
    public void setArticulos(List<String> articlulos) {
        this.articlulos = articlulos;
    }
    
}
