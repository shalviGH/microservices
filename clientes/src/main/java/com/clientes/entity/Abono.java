package com.clientes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "ABONOS")
public class Abono implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ABONO_ID", columnDefinition = "NUMBER")
    private int abonoId;

    @Column(name="PRESTAMO_ID", columnDefinition = "NUMBER")
    private int prestamoId;

    @Column(name="FECHA", columnDefinition = "DATE")
    private Date fecha;

    @Column(name="MONTO", columnDefinition = "NUMBER(9,2)")
    private double monto;

    @Column(name="RESTANTE", columnDefinition = "NUMBER(9,2)")
    private double restante;


}
