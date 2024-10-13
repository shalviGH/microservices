package com.movimiento.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="MOVIMIENTOS")
public class Movimiento implements Serializable {
    //Serializacion: Desintegracion en bytes del estado del objeto (para trasnmitir los datos en el backeed)
   //Deserializacion: reconstruccion del estado del objeto a partir de los bytes
    @Id
    @Column(name = "MOV_ID", columnDefinition="NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movId;
    @Column(name = "CUENTA_ID", columnDefinition="NUMBER")
    private int cuentaId;

    @Column(name = "FECHA", columnDefinition="DATE")
    private LocalDate fecha;

    @Column(name = "TIPO_OPERACION", columnDefinition="NVARCHAR2(20)")
    private String tipoOperacion;

    @Column(name = "MONTO", columnDefinition="NUMBER(9,2)")
    private double monto;

    @Column(name = "STATUS", columnDefinition="CHAR(1)")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMovId() {
        return movId;
    }

    public void setMovId(int movId) {
        this.movId = movId;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
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
