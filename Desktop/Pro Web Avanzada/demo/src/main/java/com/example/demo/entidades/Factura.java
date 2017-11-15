package com.example.demo.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Factura implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private Date fecha;
    private float total;
    private boolean activa;

    @OneToOne
    private Cliente cliente;

    @OneToMany
    private List<Alquiler> alquilerList;

    public Factura(Date fecha, float total, boolean activa, Cliente cliente, List<Alquiler> alquilerList) {
        this.fecha = fecha;
        this.total = total;
        this.activa = activa;
        this.cliente = cliente;
        this.alquilerList = alquilerList;
    }

    public Factura() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Alquiler> getAlquilerList() {
        return alquilerList;
    }

    public void setAlquilerList(List<Alquiler> alquilerList) {
        this.alquilerList = alquilerList;
    }
}
