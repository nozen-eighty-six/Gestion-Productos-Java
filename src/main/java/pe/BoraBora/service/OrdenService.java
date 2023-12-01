package pe.BoraBora.service;

import java.util.Collection;

import pe.BoraBora.entity.Orden;

public interface OrdenService {
	
	public abstract void insert(Orden orden);
	public abstract void update(Orden orden);
	public abstract Collection<Orden> findAll();
	public abstract void delete(Integer idCompra);
	public abstract Orden findByID(Integer idCompra);	
}
