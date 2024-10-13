package com.clientes.service;

import com.clientes.entity.Abono;
import com.clientes.request.AbonoDTO;

import java.util.List;

public interface AbonoService {
    Abono save(AbonoDTO abonoDTO);
    Abono update(AbonoDTO abonoDTO);
    Abono findById(int id);
    String delete(int id);
    List findAll();
}
