package pe.BoraBora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.BoraBora.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	//--LOGIN
	@Query(value="SELECT * FROM usuarios WHERE usuario=:userBD AND contrasena=:contra",nativeQuery = true)
	List<Account> cuentaByUsuario(@Param("userBD")String userBD, @Param("contra")String contra);
		
	//--RESET PASSWORD
	@Query(value="SELECT * FROM usuarios WHERE correo=:email", nativeQuery = true)
	Account correoExist(@Param("email")String email);
	
	//--FIND ACCOUNT
	@Query(value="SELECT * FROM usuarios WHERE usuario=:userBD AND correo=:email", nativeQuery = true)
	List<Account> cuentaByUsuarioAndEmail(@Param("userBD") String userBD, @Param("email") String email);
	
	//--OBTENER ROL DE USUARIO
	@Query(value = "SELECT rol FROM usuarios WHERE usuario = :userBD", nativeQuery = true)
    String obtenerRolPorUsuario(@Param("userBD") String userBD);
	
	
}