package com.cuentas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name="CUENTAS")
public class Cuenta implements Serializable {
    //Serializacion: Desintegracion en bytes del estado del objeto (para trasnmitir los datos en el backeed)
   //Deserializacion: reconstruccion del estado del objeto a partir de los bytes
    @Id
    @Column(name = "CUENTA_ID", columnDefinition="NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cuentaId;

    @Column(name = "CLIENTE_ID", columnDefinition="NUMBER")
    private int clienteId;

    @Column(name = "TIPO_CUENTA_ID", columnDefinition="NUMBER")
    private int tipoCuentaId;

    @Column(name = "NUM_CUENTA", columnDefinition="NUMBER")
    private int numCuenta;

    @Column(name = "SALDO", columnDefinition="DOUBLE")
    private double saldo;

}
