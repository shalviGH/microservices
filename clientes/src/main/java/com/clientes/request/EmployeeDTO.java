package com.clientes.request;

import jakarta.persistence.Column;
import jakarta.persistence.NamedEntityGraph;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDTO {
    private int employeeId;
    private int rolId;
    private String name;
    private String lastName;
    private Date dateNac;
}
