package com.clientes.controller;

import com.clientes.entity.Prestamo;
import com.clientes.logic.PrestamoLogic;
import com.clientes.request.PrestamoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {
    @Autowired
    PrestamoLogic service;

    @PostMapping("/save")
    public ResponseEntity<Prestamo> save(@RequestBody PrestamoDTO prestamoDTO){
        Prestamo prestamo = service.save(prestamoDTO);

        return new ResponseEntity<Prestamo>(prestamo, HttpStatusCode.valueOf(200));

    }

    @PutMapping("/update")
    public ResponseEntity<Prestamo> update(@RequestBody PrestamoDTO prestamoDTO){
        Prestamo prestamo = service.update(prestamoDTO);

        return new ResponseEntity<Prestamo>(prestamo, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@PathVariable int id){
       String message =  service.delete(id);

        return new ResponseEntity<String>( message , HttpStatusCode.valueOf(200));
    }


    @GetMapping("/findAll")
    public ResponseEntity<List<Prestamo>> findAll(){
        List<Prestamo> list = service.findAll();

        return  new  ResponseEntity<List<Prestamo>>(list, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find/{id}")
    public  ResponseEntity<Prestamo> find(@PathVariable int id){
        Prestamo prestamo = service.findById(id);

        return new ResponseEntity<Prestamo>(prestamo, HttpStatusCode.valueOf(200));
    }


}
