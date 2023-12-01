package pe.BoraBora.service;

import java.util.Collection;

import pe.BoraBora.entity.ProductoCarrito;

public interface ProductoCarritoService {
	public abstract Integer insert(ProductoCarrito productoCarrito);
	public abstract void delete(Integer productoCarritoId);
	public abstract Collection<ProductoCarrito> findPCByCarrito(Integer carritoId);
	
	public abstract void eliminarProdsCero();
}
