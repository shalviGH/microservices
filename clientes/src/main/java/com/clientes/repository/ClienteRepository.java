package com.clientes.repository;

import com.clientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  //Designa quien se encarga de a logica de accesso a datos (dao)
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    //CONSULTA PERSONALIZADA CON
    //@Query("SELECT m FROM Movimiento m WHERE m.status = '1' ")
    //List<Movimiento> getAllActive();

    //@Query("SELECT M FROM Movimiento M WHERE M.status = '1' AND M.movId =:id")
    //Optional<Movimiento> findActiveById(@Param("id") int id);
}
