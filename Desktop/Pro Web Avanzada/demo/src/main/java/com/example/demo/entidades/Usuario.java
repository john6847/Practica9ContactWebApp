package com.example.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;


@Entity
public class Usuario implements Serializable {

    @Id
    private String username;

    private String nombre;
    private String apellido;
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Rol> roles;
    private int enabled=1;

    public Usuario() {
    }

    public Usuario(String username, String nombre, String apellido, String password, List<Rol> roles, int enabled) {
        this.username = username;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.roles = roles;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
