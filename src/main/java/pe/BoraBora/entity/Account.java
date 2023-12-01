package pe.BoraBora.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "usuarios") 
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;

	@Column()
	private String nombre;
	@Column()
	private String correo;
	@Column()
	private String telefono;
	@Column() 
	private String usuario;
	@Column()
	private String contrasena;
	@Column()
	private String rol;
	
	@Transient
    private String confirmarContrasena;
	
	@OneToOne(mappedBy = "account")
	private Carrito carrito;
	
	public Account() { }
	
	public Account(String usuario, String contrasena) {
		this.usuario = usuario;
		this.contrasena = contrasena;
	}	

	public Account(Integer iD, String nombre, String correo, String telefono, String usuario, String contrasena,
			String rol, String confirmarContrasena) {
		ID = iD;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.rol = rol;
		this.confirmarContrasena = confirmarContrasena;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getConfirmarContrasena() {
		return confirmarContrasena;
	}

	public void setConfirmarContrasena(String confirmarContrasena) {
		this.confirmarContrasena = confirmarContrasena;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}