package com.clientes.service;

import com.clientes.entity.Prestamo;
import com.clientes.request.PrestamoDTO;

import java.util.List;
import java.util.Optional;

public interface PrestamoService {
    Prestamo save(PrestamoDTO prestamoDTO);
    Prestamo update(PrestamoDTO prestamoDTO);
    Prestamo findById(int id);
    String delete(int id);
    List findAll();

}
