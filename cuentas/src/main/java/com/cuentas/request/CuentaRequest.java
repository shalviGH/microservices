package com.cuentas.request;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
//DTO
public class CuentaRequest {

    private int cuentaId;

    private int clienteId;

    private int tipoCuentaId;

    private String numCuenta;

    private double saldo;
}
