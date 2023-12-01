package pe.BoraBora.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="detalles")
public class Orden implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	public Orden() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCompra;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column
	private String correo;
	
	@Column
	private Integer telefono;
	
	@Column
	private String condominio;
	
	@Column
	private Integer bloque; 
	
	@Column
	private Integer departamento; 
	
	@Column
	private Double total;	
	
	public Orden(Integer idCompra, String nombre, String apellido, String correo, Integer telefono, String condominio,
			Integer bloque, Integer departamento, Double total) {
		this.idCompra = idCompra;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
		this.condominio = condominio;
		this.bloque = bloque;
		this.departamento = departamento;
		this.total = total;
	}

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getCondominio() {
		return condominio;
	}

	public void setCondominio(String condominio) {
		this.condominio = condominio;
	}

	public Integer getBloque() {
		return bloque;
	}

	public void setBloque(Integer bloque) {
		this.bloque = bloque;
	}

	public Integer getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Integer departamento) {
		this.departamento = departamento;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
}
