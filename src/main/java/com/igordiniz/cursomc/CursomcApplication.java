package com.igordiniz.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.igordiniz.cursomc.domain.Categoria;
import com.igordiniz.cursomc.domain.Cidade;
import com.igordiniz.cursomc.domain.Cliente;
import com.igordiniz.cursomc.domain.Endereco;
import com.igordiniz.cursomc.domain.Estado;
import com.igordiniz.cursomc.domain.Produto;
import com.igordiniz.cursomc.domain.enums.TipoCliente;
import com.igordiniz.cursomc.repository.CategoriaDao;
import com.igordiniz.cursomc.repository.CidadeDao;
import com.igordiniz.cursomc.repository.ClienteDao;
import com.igordiniz.cursomc.repository.EnderecoDao;
import com.igordiniz.cursomc.repository.EstadoDao;
import com.igordiniz.cursomc.repository.ProdutoDao;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaDao categoriaDao;
	@Autowired
	private ProdutoDao produtoDao;
	@Autowired
	private EstadoDao estadoDao;
	@Autowired
	private CidadeDao cidadeDao;
	@Autowired
	private EnderecoDao enderecoDao;
	@Autowired
	private ClienteDao clienteDao;
	

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		/*Mapeando os produtos as suas devidas categorias*/
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		/*Mapeando as categorias de cada produto*/
		
		categoriaDao.saveAll(Arrays.asList(cat1, cat2));
		produtoDao.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlândia", est1); 
		Cidade c2 = new Cidade(null,"São Paulo", est2); 
		Cidade c3 = new Cidade(null,"Campinas", est2); 
		
		est1.getCidade().addAll(Arrays.asList(c1));
		est1.getCidade().addAll(Arrays.asList(c2,c3));
		
		estadoDao.saveAll(Arrays.asList(est1, est2));
		cidadeDao.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com","36378912377",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("321465214","36521478"));

		Endereco e1 = new Endereco(null,"Rua FLores",300,"apto 301","Jardim","35501089", cli1, c1);
		Endereco e2 = new Endereco(null,"Avenida Matos",105,"sala 105","Centro","38771012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteDao.save(cli1);
		enderecoDao.saveAll(Arrays.asList(e1,e2));
		
	}

}
