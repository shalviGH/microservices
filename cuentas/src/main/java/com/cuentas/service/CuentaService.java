package com.cuentas.service;

import com.cuentas.entity.Cuenta;
import com.cuentas.request.CuentaRequest;

import java.util.List;


//interface de negocio
//Se enlistan las operaciones de las cuales este microservicio se hara cargo
//

public interface CuentaService {

    Cuenta save(CuentaRequest request);
    Cuenta update(CuentaRequest request);
    Cuenta find(int id);
    String delete(int id);
    List findAll();

}
