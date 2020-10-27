package com.igordiniz.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igordiniz.cursomc.domain.Produto;

public interface ProdutoDao extends JpaRepository<Produto, Integer>{}
