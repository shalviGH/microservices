package com.cuentas.logic;

import com.cuentas.entity.Cuenta;
import com.cuentas.repository.CuentaRepository;
import com.cuentas.request.CuentaRequest;
import com.cuentas.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Implementacion de la logica aqui se resuelve las operacions de negocio
//

@Service
public class CuentaLogic implements CuentaService {

    //inversion de control: las clases deciden cuando instanciar a los objetos inyectados
    //inyeccion de dependencia: el consumo y la expocicion de la funcionalidad de  desacoplados
    //ters formas
    //1:__  por atributo(@Autowired)
    //2:__ por setter(@Resource)
    //3:__ por constructor
    // cual usar ? por atributo

    @Autowired
    CuentaRepository repo;


    @Override
    public Cuenta save(CuentaRequest request) {
        Cuenta cuenta = new Cuenta();

        cuenta.setClienteId(request.getClienteId());
        //cuenta.setNumCuenta (request.getNumCuenta());
        cuenta.setSaldo(request.getSaldo());
        cuenta.setTipoCuentaId(request.getTipoCuentaId());
        repo.save(cuenta);

        return cuenta;
    }

    @Override
    public Cuenta update(CuentaRequest request) {
        Cuenta cuenta=null;

        if(repo.findById(request.getCuentaId()).isPresent()){
            cuenta = repo.findById(request.getClienteId()).get();

            cuenta.setClienteId(request.getClienteId());
            //cuenta.setNumCuenta (request.getNumCuenta());
            cuenta.setSaldo(request.getSaldo());
            cuenta.setTipoCuentaId(request.getTipoCuentaId());
            repo.save(cuenta);
        }else{
            //throw
            System.out.println("No existe el movimeinto");
        }

        return  cuenta;
    }



    @Override
    public Cuenta find(int id) {
        Cuenta client=null;

        if(repo.findById(id).isPresent()){
            client = repo.findById(id).get();
        }else{
            //throw
            System.out.println("No existe el movimeinto");
        }

        return  client;
    }

    @Override
    public String delete(int id) {


        return  null;
    }

    @Override
    public List findAll() {
        return  repo.findAll();

    }

    public Cuenta getCuentaByNumCuenta(String numCuenta){
        Cuenta cuenta = null;

        if(repo.getCuentaNumCuenta(numCuenta).isPresent()){
            cuenta = repo.getCuentaNumCuenta(numCuenta).get();
        }else{
            System.out.println("La cuenta no existe ");
        }

        return cuenta;
    }
}
