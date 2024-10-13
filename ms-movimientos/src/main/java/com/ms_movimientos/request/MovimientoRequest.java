package com.ms_movimientos.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

//import jakarta.validation.constraints.
//DTO
public class MovimientoRequest {
    private int movId;

    //private int cuentaId;//vailidar si exixte la cuenta
    private String numCuenta;//vailidar si exixte la cuenta

    private LocalDate fecha; //tomarla de sistema que no este vacia o nulla
    @NotBlank(message = "El tipo de operacion no se puede guardar vacio")
    private String tipoOperacion;  //validar que sea algunas de las siguiente (RETIRO, DEPOSITO, TRANSFERENCIA)

    @Min(value=50, message = "El monto minimo por movimiento es de 50 pesoss")
    private double monto; //MONTO MINIMO 50

    public int getMovId() {
        return movId;
    }

    public void setMovId(int movId) {
        this.movId = movId;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
