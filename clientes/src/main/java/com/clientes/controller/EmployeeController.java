package com.clientes.controller;

import com.clientes.entity.Employee;
import com.clientes.logic.EmployeeLOgic;
import com.clientes.request.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/empleados")
public class EmployeeController {
    @Autowired
    EmployeeLOgic service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> list = service.findAll();

        return new ResponseEntity<List<Employee>>(list, HttpStatusCode.valueOf(200));

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> find(@PathVariable int id){
        Employee employee = service.find(id);

        return new ResponseEntity<Employee>(employee, HttpStatusCode.valueOf(200));

    }

    @PostMapping("/save")
    public ResponseEntity<Employee> save(@RequestBody EmployeeDTO employeeDTO){
        Employee  employee = service.save(employeeDTO);

        return new ResponseEntity<Employee>(employee, HttpStatusCode.valueOf(200));
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody EmployeeDTO employeeDTO){
        Employee  employee = service.update(employeeDTO);

        return new ResponseEntity<Employee>(employee, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@PathVariable int id){
        String message =  service.delete(id);

        return new ResponseEntity<String>(message, HttpStatusCode.valueOf(200));

    }

}
