package com.igordiniz.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igordiniz.cursomc.domain.Cidade;

public interface CidadeDao extends JpaRepository<Cidade, Integer> {

}
