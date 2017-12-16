package com.itla.mudat.Entity;

import java.io.Serializable;

/**
 * Created by Usuario on 11/18/2017.
 */

public class Usuario implements Serializable {

    private int id;
    private String nombre;
    private TipoDeUsuario tipoUsuario;
    private String identificacion;
    private String telefono;
    private String email;
    private String clave;
    private Boolean estatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDeUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoDeUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", identificacion='" + identificacion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", clave='" + clave + '\'' +
                ", estatus=" + estatus +
                '}';
    }
}
