package pe.BoraBora.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name = "carrito")
public class Carrito implements Serializable{
	private static final long serialVersionUID = 1L;

	public Carrito() {}
		
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer carritoId;

	@OneToOne @JoinColumn(name = "id", unique = true, nullable = false)	
	private Account account;

	@OneToMany(mappedBy = "carrito")
	private Collection<ProductoCarrito> carritoProductos = new ArrayList<>();

	public Carrito(Integer carritoId) {
		super();
		this.carritoId = carritoId;
	}

	public Integer getCarritoId() {
		return carritoId;
	}

	public void setCarritoId(Integer carritoId) {
		this.carritoId = carritoId;
	}
	public Collection<ProductoCarrito> getCarritoProductos() {
		return carritoProductos;
	}

	public void setCarritoProductos(Collection<ProductoCarrito> carritoProductos) {
		this.carritoProductos = carritoProductos;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
