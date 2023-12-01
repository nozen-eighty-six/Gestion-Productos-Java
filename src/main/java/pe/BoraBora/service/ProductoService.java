package pe.BoraBora.service;

import java.util.Collection;

import pe.BoraBora.entity.Producto;

public interface ProductoService {
	
	public abstract void insert(Producto producto);
	public abstract void update(Producto producto);
	public abstract Collection<Producto> findAll();	
	public abstract Collection<Producto> getProductosPorCategoria(Integer categoriaId);	
	public abstract Producto findByID(Integer id);	
	public abstract void delete(Integer id);
	
}
