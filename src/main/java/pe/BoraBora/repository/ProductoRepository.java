package pe.BoraBora.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.BoraBora.entity.Producto;



public interface ProductoRepository extends JpaRepository<Producto,Integer> {
	//--UPDATE
	@Modifying @Query(value = "UPDATE Productos SET nombre=:nombreP, descripcion=:descripcionP, marca=:marcaP, precio=:precioP, stock=:stockP, fvencimiento=:fvencimientoP, categoria_id=:categoria_idP WHERE producto_id=:idP", nativeQuery = true)
	void updateProduct(@Param("idP")Integer id, @Param("nombreP")String nombre, @Param("descripcionP")String descripcion,
					   @Param("marcaP")String marca, @Param("precioP") Double precio, @Param("stockP") Integer stock,
					   @Param("fvencimientoP") LocalDate fvencimiento, @Param("categoria_idP") Integer categoria_id);
	
}

