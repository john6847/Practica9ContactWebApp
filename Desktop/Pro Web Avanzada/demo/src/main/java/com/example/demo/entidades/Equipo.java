package com.example.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Equipo implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String nombre;
    private String path_image;
    private long costoDia;
    private long cantidad;


    public Equipo() {
    }

    public Equipo(String nombre, String path_image, long costoDia, long cantidad) {
        this.nombre = nombre;
        this.path_image = path_image;
        this.costoDia = costoDia;
        this.cantidad = cantidad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPath_image() {
        return path_image;
    }

    public void setPath_image(String path_image) {
        this.path_image = path_image;
    }

    public long getCostoDia() {
        return costoDia;
    }

    public void setCostoDia(long costoDia) {
        this.costoDia = costoDia;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }
}
