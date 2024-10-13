package com.clientes.logic;

import com.clientes.entity.Prestamo;
import com.clientes.exception.BussinesException;
import com.clientes.repository.PrestamoRepository;
import com.clientes.request.PrestamoDTO;
import com.clientes.service.PrestamoService;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoLogic implements PrestamoService {

    @Autowired
    PrestamoRepository repo;

    @Override
    public Prestamo save(PrestamoDTO prestamoDTO) {
         Prestamo prestamo = new Prestamo();

         prestamo.setClienteId(prestamoDTO.getClienteId());
         prestamo.setMonto(prestamoDTO.getMonto());
         prestamo.setFecha(prestamoDTO.getFecha());
         prestamo.setFechaLim(prestamoDTO.getFechaLim());
         prestamo.setInteres(prestamoDTO.getInteres());

         repo.save(prestamo);

        return prestamo;
    }

    @Override
    public Prestamo update(PrestamoDTO prestamoDTO) {

        Prestamo prestamo = null;

        if(repo.findById(prestamoDTO.getPrestamoId()).isPresent()){
            prestamo = repo.findById(prestamoDTO.getPrestamoId()).get();
            prestamo.setClienteId(prestamoDTO.getClienteId());
            prestamo.setFecha(prestamoDTO.getFecha());
            prestamo.setFechaLim(prestamoDTO.getFechaLim());
            prestamo.setInteres(prestamoDTO.getInteres());

            repo.save(prestamo);

        }else {
            System.out.println("No se encontro el id del prestamo correspondiente");
            throw new BussinesException("El prestamo a editar no existe");
        }

        return  prestamo;
    }

    @Override
    public Prestamo findById(int id) {
        Prestamo prestamo = null;

        if(repo.findById(id).isPresent()){
            prestamo = repo.findById(id).get();
        }else {

            System.out.println("No existe el prestamo con el ide solicitado");

            throw new BussinesException("El prestamo no existe");

        }

        return prestamo;

    }


    @Override
    public String delete(int id) {
        Prestamo prestamo;

        if(repo.findById(id).isPresent()){
            prestamo = repo.findById(id).get();
            repo.delete(prestamo);
        }else {

            System.out.print("No se encontro el registro a eliminar");
            throw  new BussinesException("No se encontro el registro a eliminar");
        }


        return "Prestamo eliminado con exito";
    }

    @Override
    public List findAll() {
        return repo.findAll();
    }
}
