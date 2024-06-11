package rayon.inombrable.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="usuarios")
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long UserId;
	
	@Column(name= "Nombre", nullable = false)
	private String nombre;
	
	@Column(name= "Apellido", nullable = false)
	private String apellido;
	
	@Column(name= "Usuario", nullable = false)
	private String usuario;
	
	@Column(name= "Contrasena", nullable = false)
	private String contrasena;
	
	@Column(name= "Email", nullable = false)
	private String email;

	
}
