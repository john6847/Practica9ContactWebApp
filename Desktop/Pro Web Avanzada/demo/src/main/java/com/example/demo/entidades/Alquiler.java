package com.example.demo.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Alquiler implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Equipo equipo;
    private String nombre;
    private Boolean devuelto;
    private int cantidadDiasAlquilado;

    @ManyToOne
    private Factura factura;



    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }

    public int getCantidadDiasAlquilado() {
        return cantidadDiasAlquilado;
    }

    public void setCantidadDiasAlquilado(int cantidadDiasAlquilado) {
        this.cantidadDiasAlquilado = cantidadDiasAlquilado;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }


    public Alquiler(Equipo equipo, String nombre, Boolean devuelto, int cantidadDiasAlquilado, Factura factura) {
        this.equipo = equipo;
        this.nombre = nombre;
        this.devuelto = devuelto;
        this.cantidadDiasAlquilado = cantidadDiasAlquilado;
        this.factura = factura;
    }

    public Alquiler() {
    }
}
