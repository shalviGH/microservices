package com.clientes.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AbonoDTO {
    private int abonoId;
    private int prestamoId;
    private Date fecha;
    private double monto;
    private double restante;
}
