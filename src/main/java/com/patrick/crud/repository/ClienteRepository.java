package com.patrick.crud.repository;

import com.patrick.crud.domain.Cidade;
import com.patrick.crud.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByCidade(Cidade cidade);
}
