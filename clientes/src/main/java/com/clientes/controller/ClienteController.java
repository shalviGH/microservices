package com.clientes.controller;

import com.clientes.entity.Cliente;
import com.clientes.logic.ClienteLogic;
import com.clientes.request.ClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//REST:estillo arquitectonico , protocolo para el diseño, desarrollo e implementacon
// de servidores web , oreintados a recursos. que hacen uso de los verbos y codigo de estatus del
//estandar http, que consumen y responden informacion con formato json
@RestController
@CrossOrigin(origins = "http://localhost:8095")  // Permitir solicitudes desde el frontend//establece un controlador bajo los estandar del principio rest
@RequestMapping("api/clientes")
public class ClienteController {
    @Autowired
    ClienteLogic service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = service.findAll();

        return new ResponseEntity<List<Cliente>>(list, HttpStatusCode.valueOf(200));
    }

    @RequestMapping("/save")
    public ResponseEntity<Cliente> save(@RequestBody ClienteRequest request){
        Cliente client = service.save(request);

        return new ResponseEntity<Cliente>(client,HttpStatusCode.valueOf(200));

    }

    @PutMapping("/update")
    public ResponseEntity<Cliente> update(@RequestBody ClienteRequest request){
        Cliente client = service.update(request);

        return new ResponseEntity<Cliente>(client,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Cliente> find(@PathVariable int id){
        Cliente client = service.find(id);

        return new ResponseEntity<Cliente>(client,HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        String message = service.delete(id);

        return new ResponseEntity<String>(message, HttpStatusCode.valueOf(200));
    }
}
