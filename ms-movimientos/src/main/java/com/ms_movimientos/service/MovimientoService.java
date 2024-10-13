package com.ms_movimientos.service;

import com.ms_movimientos.entity.Movimiento;
import com.ms_movimientos.request.MovimientoRequest;
import org.springframework.stereotype.Service;

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
