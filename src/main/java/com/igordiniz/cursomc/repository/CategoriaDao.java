package com.igordiniz.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igordiniz.cursomc.domain.Categoria;

@Repository
public interface CategoriaDao extends JpaRepository<Categoria, Integer>{
	

}
