package pe.BoraBora.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.BoraBora.entity.Carrito;
import pe.BoraBora.entity.ProductoCarrito;
import pe.BoraBora.repository.AccountRepository;
import pe.BoraBora.repository.CarritoRepository;

@Service
public class CarritoServiceIMPL implements CarritoService{
	@Autowired
	private CarritoRepository repository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private ProductoCarritoService productoCarritoRepository;

	// OBTENER cantidad de productos
	@Override @Transactional(readOnly = true)
	public Integer numeroProductos(Integer carritoId) {
		return productoCarritoRepository.findPCByCarrito(carritoId)
				.stream().filter(prodc -> prodc.getCarrito().getCarritoId().equals(carritoId)).mapToInt(ProductoCarrito::getCantidad).sum();
	}
	// CARRITO by accountId
	@Override @Transactional
	public Carrito findByAccountId(Integer accountId) {
		List<Carrito> carritos = repository.findAll().stream().filter(carrito -> carrito.getAccount().getID() == accountId).collect(Collectors.toList());
		if(carritos.size() == 0) {
			Carrito nc = new Carrito();
			nc.setAccount(accountRepository.findById(accountId).orElse(null));
			insert(nc);
			return nc;
		}
		return carritos.get(0);
	}
	// VALIDAR stock de Productos
	@Override @Transactional(readOnly = true)
	public Collection<ProductoCarrito> validarProductos(Integer carritoId) {
		Carrito carrito = repository.findById(carritoId).orElse(null);
		return carrito.getCarritoProductos().stream().filter(prodscarr -> prodscarr.getProducto().getStock() < prodscarr.getCantidad()).collect(Collectors.toList());
	}
	// AGREGAR carrito
	@Override @Transactional
	public void insert(Carrito carrito) {
		repository.save(carrito);
	}
	// ACTUALIZAR carrito
	@Override @Transactional
	public void update(Carrito carrito) {
		repository.save(carrito);		
	}
	// CALCULAR Precio Final
	@Override
	public Double pagoFinal(Integer carritoId) {
		return productoCarritoRepository.findPCByCarrito(carritoId).stream().mapToDouble(p -> p.getProducto().getPrecio() * p.getCantidad()).sum();		
	}
}