package com.ms_movimientos.logic;

import com.ms_movimientos.entity.Movimiento;
import com.ms_movimientos.exception.BussinesException;
import com.ms_movimientos.records.Cuenta;
import com.ms_movimientos.repository.MovimientoRepository;
import com.ms_movimientos.request.MovimientoRequest;
import com.ms_movimientos.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

//Implementacion de la logica aqui se resuelve las operacions de negocio
//

@Service
public class MovimientoLogic  implements MovimientoService {

    //inversion de control: las clases deciden cuando instanciar a los objetos inyectados
    //inyeccion de dependencia: el consumo y la expocicion de la funcionalidad de  desacoplados
    //ters formas
    //1:__  por atributo(@Autowired)
    //2:__ por setter(@Resource)
    //3:__ por constructor
    // cual usar ? por atributo

    @Autowired
    MovimientoRepository repo;

    RestTemplate http = new RestTemplate();

    @Override
    public Movimiento save(MovimientoRequest request) {
        Movimiento movimiento = new Movimiento();

        String tipoOpe = request.getTipoOperacion();
        int cuentaId = 0;
        Cuenta cRecord = null;
        //se invoca el servicio de cuenta para obtener el id de cuenta
        cRecord = http.getForObject("http://localhost:8096/api/cuentas/cuentaByNumCuenta/"+request.getNumCuenta(), Cuenta.class);

        //si la cuneta existe se guarda
        if (cRecord==null){
          System.out.println("No se encoontro el numero de cuentyes");

          throw new BussinesException("La cuenta no existe");

        }else if( !(tipoOpe.equals("RETIRO") || tipoOpe.equals("TRANSFERENCIA") || tipoOpe.equals("DEPOSITO")) ){
            System.out.println("El tipo de operacion es invalido");
            throw new BussinesException("El tipo de operacion no es invalido");

        }else{
            movimiento = new Movimiento();

            movimiento.setCuentaId(cRecord.cuentaId());
            movimiento.setFecha(LocalDate.now());
            movimiento.setMonto(request.getMonto());
            movimiento.setTipoOperacion(request.getTipoOperacion());

            repo.save(movimiento);


        }

        return  movimiento;
    }

    @Override
    public Movimiento update(MovimientoRequest request) {
        Movimiento movimiento=null;

        if(repo.findActiveById(request.getMovId()).isPresent()){
            movimiento = repo.findActiveById(request.getMovId()).get();

            //movimiento.setCuentaId(request.getCuentaId());
            movimiento.setFecha(LocalDate.now());
            movimiento.setMonto(request.getMonto());
            movimiento.setTipoOperacion(request.getTipoOperacion());

            movimiento.setStatus("1");
            repo.save(movimiento);
        }else{
            //throw
            System.out.println("No existe el movimeinto");
        }

        return  movimiento;
    }

    @Override
    public Movimiento find(int id) {
        Movimiento movimiento=null;

        if(repo.findActiveById(id).isPresent()){
            movimiento = repo.findActiveById(id).get();
        }else{
            //throw
            System.out.println("No existe el movimeinto");
        }

        return  movimiento;
    }

    @Override
    public String delete(int id) {
        Movimiento movimiento=null;

        String response = "";

        if(repo.findActiveById(id).isPresent()){
            movimiento = repo.findActiveById(id).get();
            movimiento.setStatus("0");
            repo.save(movimiento);

            response ="Movimiento eliminado";
        }else{
            //throw
            response ="NO s eencontro el movimiento";
            System.out.println("No existe el movimeinto");
        }

        return  response;
    }

    @Override
    public List findAll() {
        //return  repo.findAll();
        return repo.getAllActive();
    }
}
