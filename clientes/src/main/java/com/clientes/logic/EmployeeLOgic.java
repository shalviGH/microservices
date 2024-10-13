package com.clientes.logic;

import com.clientes.entity.Employee;
import com.clientes.repository.EmployeeRepository;
import com.clientes.request.EmployeeDTO;
import com.clientes.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeLOgic implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Override
    public Employee save(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        employee.setRolId(employeeDTO.getRolId());
        employee.setName(employeeDTO.getName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setDateNac(employeeDTO.getDateNac());

         repository.save(employee);

        return employee;
    }

    @Override
    public Employee update(EmployeeDTO employeeDTO) {

        Employee employee =  null;

        if(repository.findById(employeeDTO.getEmployeeId()).isPresent()){
            employee = repository.findById (employeeDTO.getEmployeeId()).get();

            employee.setLastName(employeeDTO.getLastName());
            employee.setName(employeeDTO.getName());
            employee.setDateNac(employeeDTO.getDateNac());
            employee.setRolId(employeeDTO.getRolId());

            repository.save(employee);
        }else{
            System.out.println("NO se encontro el elemento a editar");
        }


        return employee;
    }

    @Override
    public Employee find(int id) {
        Employee employee= null;

        if(repository.findById(id).isPresent()){
            employee = repository.findById(id).get();
        }else{
            System.out.println("Empleado no encontrado");
        }

        return  employee;
    }

    @Override
    public String delete(int id) {
        Employee employee = null;

        if(repository.findById(id).isPresent()){
            employee = repository.findById(id).get();

            repository.delete(employee);
        }else{
            System.out.println("Empleado no encontrado");
        }

        return "Empleado eliminado";

    }

    @Override
    public List<Employee> findAll() {

        List list = repository.findAll();


        return list;
    }
}
