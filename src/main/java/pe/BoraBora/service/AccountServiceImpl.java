package pe.BoraBora.service;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.BoraBora.entity.Account;
import pe.BoraBora.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repository;
	
	public AccountServiceImpl() {}
	
	//--CREATE ACCOUNT
	@Override @Transactional
	public void insert(Account account) {
		//Validar Contraseña
		String c = account.getContrasena();
		if (c.contains(c))
		repository.save(account);		
	}
	
	//--LOGIN
	@Override @Transactional(readOnly = true)
	public boolean iniciarSesion(String usuario, String contrasena) {
		if (repository.cuentaByUsuario(usuario, contrasena).isEmpty()) {
			return false;
		}return true;
	}

	//--RESET PASSWORD
	@Override @Transactional
	public boolean resetPass(String correo, String pass){	
		Account cuenta = repository.correoExist(correo);
		if (cuenta != null) {
			cuenta.setContrasena(pass.split(",")[0]);
			repository.save(cuenta);
			return true;
		}return false;
	}
	
	//--FIND 
	@Override @Transactional(readOnly = true)
	public Account findById(Integer ID) 
	{
		return repository.findById(ID).get();		
	}
	
	//--UPDATE
	@Override @Transactional
	public Account update(Account account) 
	{
		 return repository.save(account);
	}

	//--OBTENER ROL X USUARIO
	@Override @Transactional(readOnly = true)
    public String obtenerRolPorUsuario(String usuario) {
        return repository.obtenerRolPorUsuario(usuario);
    }

	@Override @Transactional(readOnly = true)
	public Collection<Account> findAll() {
		return repository.findAll();
	}
	
	//--OBTENER  X USUARIO
	@Override @Transactional(readOnly = true)
	public Account CuentaPorUsuario(String usuario) {
		return findAll().stream().filter(cuenta -> cuenta.getUsuario().equals(usuario)).collect(Collectors.toList()).get(0);
	}
}