package com.clientes.controller;

import com.clientes.entity.Abono;
import com.clientes.logic.AbonoLogic;
import com.clientes.request.AbonoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abonos")
public class AbonoController {

    @Autowired
    AbonoLogic service;

    //@CrossOrigin(origins = "http://localhost:")
    @GetMapping("/findAll")
    ResponseEntity<List<Abono>> findAll(){
        List list = service.findAll();

        return new ResponseEntity<List<Abono>>(list, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Abono> find(@PathVariable int id){
        Abono abono = service.findById(id);

        return new ResponseEntity<Abono>(abono, HttpStatusCode.valueOf(200));
    }

    @PostMapping("/save")
    public ResponseEntity<Abono> save(@RequestBody AbonoDTO abonoDTO){
        Abono abono = service.save(abonoDTO);

        return new ResponseEntity<Abono>(abono, HttpStatusCode.valueOf(200));

    }

    @PutMapping("/update")
    public ResponseEntity<Abono> update(@RequestBody AbonoDTO abonoDTO){

        Abono abono = service.update(abonoDTO);


        return new ResponseEntity<Abono>(abono, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int  id){
        String message = service.delete(id);

        return new ResponseEntity<String>(message, HttpStatusCode.valueOf(200));
    }



}
