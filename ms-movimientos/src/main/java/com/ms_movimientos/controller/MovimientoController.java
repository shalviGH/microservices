package com.ms_movimientos.controller;

import com.ms_movimientos.entity.Movimiento;
import com.ms_movimientos.logic.MovimientoLogic;
import com.ms_movimientos.request.MovimientoRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//REST:estillo arquitectonico , protocolo para el diseño, desarrollo e implementacon
// de servidores web , oreintados a recursos. que hacen uso de los verbos y codigo de estatus del
//estandar http, que consumen y responden informacion con formato json
@RestController  //establece un controlador bajo los estandar del principio rest
@RequestMapping("api/movimientos")
public class MovimientoController {
    @Autowired
    MovimientoLogic service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Movimiento>> findAll(){
        List<Movimiento> list = service.findAll();

        return new ResponseEntity<List<Movimiento>>(list, HttpStatusCode.valueOf(200));
    }

    @PostMapping("/save")
    public ResponseEntity<Movimiento> save(@Valid @RequestBody MovimientoRequest request){
        Movimiento movimiento = service.save(request);

        return new ResponseEntity<Movimiento>(movimiento,HttpStatusCode.valueOf(200));

    }

    @PutMapping("/update")
    public ResponseEntity<Movimiento> update(@Valid @RequestBody MovimientoRequest request){
        Movimiento movimiento = service.update(request);

        return new ResponseEntity<Movimiento>(movimiento,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Movimiento> find(@PathVariable int id){
        Movimiento movimiento = service.find(id);

        return new ResponseEntity<Movimiento>(movimiento,HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        String message = service.delete(id);

        return new ResponseEntity<String>(message, HttpStatusCode.valueOf(200));
    }
}
