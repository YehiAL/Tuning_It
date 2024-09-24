package com.example.tuningit;

public class modeloProductos {
    //creacion de una clase para poder ingresar datos de productos
    String nombreProducto;
    String descripcionProducto;
    int imagen;


    public modeloProductos(String nombreProducto, String descripcionProducto, int imagen) {
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.imagen = imagen;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public int getImagen() {
        return imagen;
    }
}
