package com.clientes.logic;

import com.clientes.entity.Cliente;
import com.clientes.repository.ClienteRepository;
import com.clientes.request.ClienteRequest;
import com.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

//Implementacion de la logica aqui se resuelve las operacions de negocio
//

@Service
public class ClienteLogic implements ClienteService {

    //inversion de control: las clases deciden cuando instanciar a los objetos inyectados
    //inyeccion de dependencia: el consumo y la expocicion de la funcionalidad de  desacoplados
    //ters formas
    //1:__  por atributo(@Autowired)
    //2:__ por setter(@Resource)
    //3:__ por constructor
    // cual usar ? por atributo

    @Autowired
    ClienteRepository repo;




    @Override
    public Cliente save(ClienteRequest request) {
        Cliente client = new Cliente();

        client.setNombre(request.getNombre());
        client.setDireccion(request.getDireccion());
        client.setUrp (request.getUrp());
        client.setFechaNac(request.getFechaNac());
        repo.save(client);
        return client;
    }

    @Override
    public Cliente update(ClienteRequest request) {
        Cliente client=null;

        if(repo.findById(request.getClienteId()).isPresent()){

            client = repo.findById(request.getClienteId()).get();
            client.setNombre(request.getNombre());
            client.setDireccion(request.getDireccion());
            client.setUrp (request.getUrp());
            client.setFechaNac(request.getFechaNac());

            repo.save(client);
        }else{
            //throw
            System.out.println("No existe el movimeinto");
        }

        return  client;
    }



    @Override
    public Cliente find(int id) {
        Cliente client=null;

        if(repo.findById(id).isPresent()){
            client = repo.findById(id).get();
        }else{
            //throw
            System.out.println("No existe el movimeinto");
        }

        return  client;
    }

    @Override
    public String delete(int id) {


        return  null;
    }

    @Override
    public List findAll() {
        return  repo.findAll();

    }
}
