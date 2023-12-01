package pe.BoraBora.service;

import java.util.Collection;
import pe.BoraBora.entity.Carrito;
import pe.BoraBora.entity.ProductoCarrito;

public interface CarritoService {
	public abstract Integer numeroProductos(Integer carritoId);
	
	public abstract void insert(Carrito carrito);
	public abstract void update(Carrito carrito );
	public abstract Carrito findByAccountId(Integer accountId);
	
	public abstract Collection<ProductoCarrito> validarProductos(Integer carritoId);
	public abstract Double pagoFinal(Integer carritoId);
}