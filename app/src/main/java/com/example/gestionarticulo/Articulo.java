package com.example.gestionarticulo;

public class Articulo {
    private String codigo;
    private String descripcion;
    private String precio;

    public Articulo(String codigo, String descripcion, String precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecio() {
        return precio;
    }
}
