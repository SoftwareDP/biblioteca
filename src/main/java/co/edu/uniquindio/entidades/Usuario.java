package co.edu.uniquindio.entidades;

import java.io.Serializable;

import javax.persistence.*;
@Entity(name="usuario")
@NamedQueries({@NamedQuery(name=Usuario.USUARIOLOGIN,query="select u from usuario u where u.nombreUsuario=?1 and u.password=?2")})
public class Usuario implements Serializable{
	
	/**
	 * atributos estaticos para nombres de las consultas
	 */
	
	public static final String USUARIOLOGIN="usuario.login";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;
	@Column(name="nombre")
	private String nombre;
	@Column(name="nombreUsuario")
	private String nombreUsuario;
	@Column(name="password")
	private String password;
	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
