package com.clientes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PRESTAMOS")
public class Prestamo {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="PRESTAMO_ID" , columnDefinition = "NUMBER")
    private int prestamoId;

    @Column(name="CLIENTE_ID",columnDefinition = "NUMBER")
    private int clienteId;

    @Column(name="MONTO" , columnDefinition = "NUMBER(9,2)" )
    private double monto;

    @Column(name="FECHA" , columnDefinition = "DATE")
    private Date fecha;

    @Column(name="FECHA_LIM" , columnDefinition = "DATE")
    private Date fechaLim;

    @Column(name="INTERES", columnDefinition = "number")
    private int interes;
}
