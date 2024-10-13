package com.ms_movimientos.repository;

import com.ms_movimientos.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository  //Designa quien se encarga de a logica de accesso a datos (dao)
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

    //CONSULTA PERSONALIZADA CON
    @Query("SELECT m FROM Movimiento m WHERE m.status = '1' ")
    List<Movimiento> getAllActive();

    @Query("SELECT M FROM Movimiento M WHERE M.status = '1' AND M.movId =:id")
    Optional<Movimiento> findActiveById(@Param("id") int id);
}
