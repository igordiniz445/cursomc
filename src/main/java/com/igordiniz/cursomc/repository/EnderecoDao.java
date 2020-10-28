package com.igordiniz.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igordiniz.cursomc.domain.Endereco;

public interface EnderecoDao extends JpaRepository<Endereco, Integer> {

}
