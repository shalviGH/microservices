package com.clientes.service;

import com.clientes.entity.Cliente;
import com.clientes.request.ClienteRequest;

import java.util.List;

//interface de negocio
//Se enlistan las operaciones de las cuales este microservicio se hara cargo
//

public interface ClienteService {

    Cliente save(ClienteRequest request);
    Cliente update(ClienteRequest request);
    Cliente find(int id);
    String delete(int id);
    List findAll();

}
