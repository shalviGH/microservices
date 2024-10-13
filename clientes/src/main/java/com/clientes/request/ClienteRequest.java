package com.clientes.request;

import java.time.LocalDate;
//capa 3
//DTO
public class ClienteRequest {

    private int clienteId;

    private String nombre;

    private String direccion;

    private String urp;

    private LocalDate fechaNac;

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrp() {
        return urp;
    }

    public void setUrp(String urp) {
        this.urp = urp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }
}
