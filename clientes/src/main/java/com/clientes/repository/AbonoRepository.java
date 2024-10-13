package com.clientes.repository;

import com.clientes.entity.Abono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonoRepository extends JpaRepository<Abono, Integer> {

}
