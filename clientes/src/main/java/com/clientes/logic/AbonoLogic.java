package com.clientes.logic;

import com.clientes.entity.Abono;
import com.clientes.repository.AbonoRepository;
import com.clientes.request.AbonoDTO;
import com.clientes.service.AbonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonoLogic implements AbonoService {

    @Autowired
    AbonoRepository repository;


    @Override
    public Abono save(AbonoDTO abonoDTO) {
        Abono abono = new Abono();

        abono.setPrestamoId(abonoDTO.getPrestamoId());
        abono.setFecha(abonoDTO.getFecha());
        abono.setMonto(abonoDTO.getMonto());
        abono.setRestante(abonoDTO.getRestante());
        repository.save(abono);

        return abono;
    }

    @Override
    public Abono update(AbonoDTO abonoDTO) {

        Abono abono = null;

        if(repository.findById(abonoDTO.getAbonoId()).isPresent()){
            abono = repository.findById(abonoDTO.getAbonoId()).get();
            abono.setPrestamoId(abonoDTO.getPrestamoId());
            abono.setRestante(abonoDTO.getRestante());
            abono.setMonto(abonoDTO.getMonto());
            abono.setFecha(abonoDTO.getFecha());

            repository.save(abono);

        }else{
            System.out.println("NO se encontro el producto eliminar -");
        }

        return abono;
    }

    @Override
    public Abono findById(int id) {

        Abono abono =  null;

        if(repository.findById(id).isPresent()){
            abono = repository.findById(id).get();
        }else{
            System.out.println("NO se encontro el abono con el id correspopndiente");
        }

        return abono;
    }

    @Override
    public String delete(int id) {
        Abono abono = null;

        if(repository.findById(id).isPresent()){
            abono = repository.findById(id).get();
            repository.delete(abono);
        }else{
            System.out.println("Recurso a eliminar no encontrado");
        }

        return "Informacion eliminado con exito";
    }

    @Override
    public List findAll() {

        List list = repository.findAll();

        return list;
    }
}
