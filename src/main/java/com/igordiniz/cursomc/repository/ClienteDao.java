package com.igordiniz.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igordiniz.cursomc.domain.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Integer>{

}
