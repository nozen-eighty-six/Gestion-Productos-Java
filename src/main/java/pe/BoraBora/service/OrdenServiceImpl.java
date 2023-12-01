package pe.BoraBora.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.BoraBora.entity.Orden;
import pe.BoraBora.entity.Producto;
import pe.BoraBora.repository.OrdenRepository;

@Service
public class OrdenServiceImpl implements OrdenService{
	
	@Autowired
	private OrdenRepository ordenRepository;
	
	public OrdenServiceImpl() {
	}
	
	@Override 
	@Transactional(readOnly=true)
	public Collection<Orden> findAll() {
		return ordenRepository.findAll();
	}
	
	@Override
	@Transactional
	public void delete(Integer idCompra) {
		ordenRepository.deleteById(idCompra);
	}
	
	@Override 
	@Transactional(readOnly=true)
	public Orden findByID(Integer idCompra) {
		return ordenRepository.findById(idCompra).orElse(null);
	}
	
	@Override 
	@Transactional
	public void insert(Orden orden) {
		ordenRepository.save(orden);
	}
	
	@Override 
	@Transactional
	public void update(Orden orden) {
		ordenRepository.save(orden);
	}
}
