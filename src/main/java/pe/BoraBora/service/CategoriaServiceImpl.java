package pe.BoraBora.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.BoraBora.entity.Categoria;
import pe.BoraBora.repository.CategoriaRepository;


@Service
public class CategoriaServiceImpl implements CategoriaService
{
	@Autowired
	private CategoriaRepository repository;
	
	public CategoriaServiceImpl() {		
	}

	//--LISTAR
	@Override @Transactional(readOnly=true)
	public Collection<Categoria> findAll() {
		return repository.findAll();
	}
}
