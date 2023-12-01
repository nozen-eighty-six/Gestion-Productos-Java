package pe.BoraBora.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.BoraBora.entity.Producto;
import pe.BoraBora.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService
{
	@Autowired
	private ProductoRepository productoRepository;
	
	public ProductoServiceImpl() {		
	}
	//--LISTAR
	@Override @Transactional(readOnly=true)
	public Collection<Producto> findAll() {
		return productoRepository.findAll();
	}
	//--AGREGAR
	@Override @Transactional
	public void insert(Producto producto) {
		productoRepository.save(producto);
	}
	//--UPDATE
	@Override @Transactional
	public void update(Producto producto) {
		productoRepository.updateProduct(producto.getProductoId(),producto.getNombre(),producto.getDescripcion(),producto.getMarca(),
				                 producto.getPrecio(),producto.getStock(),producto.getFvencimiento(),producto.getCategoria().getCategoriaId());
	}
	//--PRODUCTO by IDCategoria
	@Override @Transactional(readOnly=true)
	public Collection<Producto> getProductosPorCategoria(Integer categoriaId) {
		return productoRepository.findAll().stream()
	            .filter(producto -> producto.getCategoria().getCategoriaId().equals(categoriaId))
	            .collect(Collectors.toList());
	   }
	//--FIND
	@Override @Transactional(readOnly=true)
	public Producto findByID(Integer id) {
		return productoRepository.findById(id).orElse(null);
	}
	
	//--DELETE
	@Override @Transactional
	public void delete(Integer id) {
		productoRepository.deleteById(id);
	}
}
