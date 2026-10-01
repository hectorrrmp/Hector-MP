package com.prueba1.model;

public class Article {
    private String idArticulo;
    private String nombre;
    private double precio;
    private int cantidad;


    public Article(String idArticulo, String nombre, double precio, int cantidad) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getGrossAmount() {
        return precio * cantidad;
    }
   
}
