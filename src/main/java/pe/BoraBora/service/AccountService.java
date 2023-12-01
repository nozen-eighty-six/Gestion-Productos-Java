package pe.BoraBora.service;

import java.util.Collection;

import pe.BoraBora.entity.Account;

public interface AccountService {

	public abstract void insert(Account account);
	public boolean iniciarSesion(String usuario, String contrasena);	
	public boolean resetPass(String usuario, String correo);
	public Account update(Account account);
	public abstract Account findById(Integer ID);
	public abstract Account CuentaPorUsuario(String usuario);
	String obtenerRolPorUsuario(String usuario);

	
	public abstract Collection<Account> findAll();	
}
