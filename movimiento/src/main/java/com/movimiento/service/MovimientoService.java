package com.movimiento.service;


import com.movimiento.entity.Movimiento;
import com.movimiento.request.MovimientoRequest;

import java.util.List;


//interface de negocio
//Se enlistan las operaciones de las cuales este microservicio se hara cargo
//

public interface MovimientoService {

    Movimiento save(MovimientoRequest request);
    Movimiento update(MovimientoRequest request);
    Movimiento find(int id);
    String delete(int id);
    List findAll();

}
