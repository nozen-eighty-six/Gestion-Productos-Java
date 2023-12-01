package pe.BoraBora.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="productos")
public class Producto implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productoId; 
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column
	private String marca;
	
	@Column
	private Double precio;
	
	@Column
	private Integer stock;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fvencimiento;
	
	@Column
	private String imagen;
	
	@ManyToOne @JoinColumn(name="categoria_id",nullable=false)
	private Categoria categoria;	

	@OneToMany(mappedBy = "producto")
	private Collection<ProductoCarrito> carritoProductos = new ArrayList<>();
	
//	@ManyToMany(fetch = FetchType.EAGER) @JoinTable(name = "productos_carritos", joinColumns = @JoinColumn(name="producto_id"), inverseJoinColumns = @JoinColumn(name="carrito_id"))
//	private Set<Carrito> itemsCarrito = new HashSet<>();
	
	public Producto() { }	

	public Producto(Integer productoId, String nombre, String descripcion, String marca, Double precio, Integer stock,
			LocalDate fvencimiento, String imagen, Categoria categoria) {
		this.productoId = productoId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.precio = precio;
		this.stock = stock;
		this.fvencimiento = fvencimiento;
		this.imagen = imagen;
		this.categoria = categoria;
	}

	public Integer getProductoId() {
		return productoId;
	}

	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public LocalDate getFvencimiento() {
		return fvencimiento;
	}

	public void setFvencimiento(LocalDate fvencimiento) {
		this.fvencimiento = fvencimiento;
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Collection<ProductoCarrito> getCarritoProductos() {
		return carritoProductos;
	}

	public void setCarritoProductos(Collection<ProductoCarrito> carritoProductos) {
		this.carritoProductos = carritoProductos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}		
}