package com.itla.mudat.Entity;

import java.util.Date;

/**
 * Created by Usuario on 11/18/2017.
 */

public class Anuncio {

    private int id;
    private Categoria categoria;
    private Usuario usuario;
    private Date fecha;
    private String condicion;
    private Double precio;
    private String titulo;
    private String ubicacion;
    private String detalle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

   /* public void setFecha(String fecha) {
        this.fecha = fecha;
    }*/

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Double getPrecio() {
        return precio;
    }

   /* public void setPrecio(String precio) {
        this.precio = precio;
    }*/

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
