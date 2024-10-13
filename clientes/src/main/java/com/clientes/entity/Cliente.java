package com.clientes.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="CLIENTES")
public class Cliente implements Serializable {
    //Serializacion: Desintegracion en bytes del estado del objeto (para trasnmitir los datos en el backeed)
   //Deserializacion: reconstruccion del estado del objeto a partir de los bytes
    @Id
    @Column(name = "CLIENTE_ID", columnDefinition="NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clienteId;

    @Column(name = "NOMBRE", columnDefinition="NVARCHAR2(50)")
    private String nombre;

    @Column(name = "DIRECCION", columnDefinition="NVARCHAR2(100)")
    private String direccion;

    @Column(name = "CURP", columnDefinition="NVARCHAR2(30)")
    private String urp;

    @Column(name = "FECHA_NAC", columnDefinition="DATE")
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUrp() {
        return urp;
    }

    public void setUrp(String urp) {
        this.urp = urp;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }
}
