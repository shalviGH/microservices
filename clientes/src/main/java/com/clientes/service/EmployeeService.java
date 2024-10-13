package com.clientes.service;

import com.clientes.entity.Employee;
import com.clientes.request.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    Employee save(EmployeeDTO employeeDTO);
    Employee update(EmployeeDTO employeeDTO);
    Employee find(int id);
    String delete(int id);
    List<Employee> findAll();
}
