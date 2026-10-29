package com.prueba1.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prueba1.Calculator;

public class Article {

   @JsonProperty("name")
   private String nombre;
   @JsonProperty("quantity")
   private int cantidad;
   @JsonProperty("unitPrice")
   private double precio;
   @JsonProperty("discount")
   private double descuento;

    public Article() {
    }
    public Article(String nombre, int cantidad, double precio, double descuento) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getDescuento() {
        return descuento;
    }
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    public double getGrossAmount(int cantidad,double precio) {
        Calculator calculator = new Calculator();
        return calculator.multiplyDouble(cantidad, precio);
    }
    public double getDiscountedAmount(double grossAmount,double descuento) {
        Calculator calculator = new Calculator();
        return calculator.discount(grossAmount, descuento);
    }
   
}
