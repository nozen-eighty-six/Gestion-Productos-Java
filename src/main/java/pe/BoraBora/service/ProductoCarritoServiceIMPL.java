package pe.BoraBora.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.BoraBora.entity.Carrito;
import pe.BoraBora.entity.Producto;
import pe.BoraBora.entity.ProductoCarrito;
import pe.BoraBora.repository.ProductoCarritoRepository;

@Service
public class ProductoCarritoServiceIMPL implements ProductoCarritoService{
	@Autowired
	private ProductoCarritoRepository repository;

	public ProductoCarritoServiceIMPL() {}

	// AGREGAR PRODUCTO AL CARRITO
	@Override @Transactional
	public Integer insert(ProductoCarrito productoCarrito) {
		Producto pr = productoCarrito.getProducto();
		Carrito carr = productoCarrito.getCarrito();
		Integer cant = productoCarrito.getCantidad();
		
		List<ProductoCarrito> carritosPro = findPCByCarrito(carr.getCarritoId()).stream().filter(prodcarr -> prodcarr.getProducto().equals(pr)).collect(Collectors.toList());
		if (pr.getStock() < cant) {
			return 0;
		}
		if(carritosPro.size() != 0) {
			productoCarrito = carritosPro.get(0);
			cant += productoCarrito.getCantidad();
			productoCarrito.setCantidad(cant);
		}
		repository.save(productoCarrito);
		return cant;		
	}
	// OBTENER PRODUCTOS DEL CARRITO
	@Override @Transactional(readOnly = true)
	public Collection<ProductoCarrito> findPCByCarrito(Integer carritoId) {
		return repository.findAll().stream().filter(prodcarr -> prodcarr.getCarrito().getCarritoId().equals(carritoId)).collect(Collectors.toList());
	}	
	// ELIMINAR PRODUCTO DEL CARRITO con CANTIDAD 0
	@Override @Transactional
	public void eliminarProdsCero() {
		List<Integer> idsCero = repository.findAll().stream().filter(prod -> prod.getCantidad() == 0).collect(Collectors.toList())
						    .stream().map(ProductoCarrito::getProdscarritosId).collect(Collectors.toList());
		repository.deleteAllById(idsCero);
	}
	
	// ELIMINAR UN PRODUCTO DEL CARRITO POR ID
	@Override
    @Transactional
    public void delete(Integer productoCarritoId) {
        repository.deleteById(productoCarritoId);
    }
}
