package com.example.demo.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class SubFamilia implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Familia familia;

    private String nombre;

    @OneToMany
    private List<Equipo> equipoList;


    public SubFamilia() {
    }

    public SubFamilia(Familia familia, String nombre, List<Equipo> equipoList) {
        this.familia = familia;
        this.nombre = nombre;
        this.equipoList = equipoList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Equipo> getEquipoList() {
        return equipoList;
    }

    public void setEquipoList(List<Equipo> equipoList) {
        this.equipoList = equipoList;
    }
}
