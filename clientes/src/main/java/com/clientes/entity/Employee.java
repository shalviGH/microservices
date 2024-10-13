package com.clientes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="EMPLEADOS")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EMPLEADO_ID", columnDefinition = "NUMBER")
    private int employeeId;

    @Column(name="ROL_ID", columnDefinition = "NUMBER")
    private int rolId;

    @Column(name="NOMBRE", columnDefinition = "NVARCHAR2(100)")
    private String name;

    @Column(name="APELLIDOS", columnDefinition = "NVARCHAR2(150)")
    private String lastName;

    @Column(name="FECHA_NAC", columnDefinition = "DATE")
    private Date dateNac;
}
