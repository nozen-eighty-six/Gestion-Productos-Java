package pe.BoraBora.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name = "productos_carritos")
public class ProductoCarrito implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public ProductoCarrito() {}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prodscarritosId;

    @ManyToOne @JoinColumn(name = "carrito_id", nullable = false)
    private Carrito carrito;

    @ManyToOne @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column
    private int cantidad;

	public ProductoCarrito(Integer prodscarritosId, int cantidad) {
		super();
		this.prodscarritosId = prodscarritosId;
		this.cantidad = cantidad;
	}
	public Integer getProdscarritosId() {
		return prodscarritosId;
	}
	public void setProdscarritosId(Integer prodscarritosId) {
		this.prodscarritosId = prodscarritosId;
	}
	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}    
}