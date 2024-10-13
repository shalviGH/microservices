package com.movimiento.records;


//para contruir una cuenta y guardar los valores
public record Cuenta(
        int cuentaId,
        int clienteId,
        int tipoCuentaId,
        String numCuenta,
        double saldo) { }
