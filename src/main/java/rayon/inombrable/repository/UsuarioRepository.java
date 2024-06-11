package rayon.inombrable.repository;

import java.util.List;

import rayon.inombrable.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
	List<Usuarios> findAll();

}
