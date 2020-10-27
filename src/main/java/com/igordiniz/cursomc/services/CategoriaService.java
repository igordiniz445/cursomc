package com.igordiniz.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igordiniz.cursomc.domain.Categoria;
import com.igordiniz.cursomc.repository.CategoriaDao;
import com.igordiniz.cursomc.services.exception.ObjectNotFoundException;


@Service
public class CategoriaService {
	
	
	@Autowired
	private CategoriaDao repo;
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! ID:"+id+", Tipo: "+Categoria.class.getName()));
	}
}
