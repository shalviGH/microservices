package com.cuentas.controller;

import com.cuentas.entity.Cuenta;
import com.cuentas.logic.CuentaLogic;
import com.cuentas.request.CuentaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//REST:estillo arquitectonico , protocolo para el diseño, desarrollo e implementacon
// de servidores web , oreintados a recursos. que hacen uso de los verbos y codigo de estatus del
//estandar http, que consumen y responden informacion con formato json
@RestController  //establece un controlador bajo los estandar del principio rest
@RequestMapping("api/cuentas")
public class CuentaController {
    @Autowired
    CuentaLogic service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Cuenta>> findAll(){
        List<Cuenta> list = service.findAll();

        return new ResponseEntity<List<Cuenta>>(list, HttpStatusCode.valueOf(200));
    }

    @RequestMapping("/save")
    public ResponseEntity<Cuenta> save(@RequestBody CuentaRequest request){
        Cuenta cuenta = service.save(request);

        return new ResponseEntity<Cuenta>(cuenta,HttpStatusCode.valueOf(200));

    }

    @PutMapping("/update")
    public ResponseEntity<Cuenta> update(@RequestBody CuentaRequest request){
        Cuenta cuenta = service.update(request);

        return new ResponseEntity<Cuenta>(cuenta,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Cuenta> find(@PathVariable int id){
        Cuenta cuenta = service.find(id);

        return new ResponseEntity<Cuenta>(cuenta,HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        String message = service.delete(id);

        return new ResponseEntity<String>(message, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/cuentaByNumCuenta/{numCuenta}")
    public ResponseEntity<Cuenta> getCuentaNumCuenta(@PathVariable String numCuenta){
        Cuenta c = service.getCuentaByNumCuenta(numCuenta) ;

        return new ResponseEntity<Cuenta>(c, HttpStatusCode.valueOf(200));
    }
}
