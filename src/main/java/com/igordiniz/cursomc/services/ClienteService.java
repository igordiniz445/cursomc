package com.igordiniz.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igordiniz.cursomc.domain.Cliente;
import com.igordiniz.cursomc.repository.ClienteDao;
import com.igordiniz.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteDao clientedao;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> cliente = clientedao.findById(id);
		return cliente.orElseThrow(()-> new ObjectNotFoundException("Não foi possível encontrar cliente com id: "+id));
	}
}
