package com.clientes.request;

import jakarta.persistence.Column;
import lombok.*;

import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PrestamoDTO {
    private int prestamoId;
    private int clienteId;
    private double monto;
    private Date fecha;
    private Date fechaLim;
    private int interes;

}
