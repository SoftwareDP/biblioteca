package co.edu.uniquindio.entidades;

import java.io.Serializable;

import javax.persistence.*;
@Entity(name="resena")
@NamedQueries({@NamedQuery(name=Resena.BUSCAR,query="select r from resena r ")})
public class Resena implements Serializable {
	
	
	public static final String BUSCAR="resena.buscar";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComentario;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="calificacion")
	private int calificacion;
	
	@ManyToOne
	@JoinColumn(name = "idLibro", nullable = false)
	private Libro libro;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;
	/**
	 * @return the idComentario
	 */
	public int getIdComentario() {
		return idComentario;
	}
	/**
	 * @param idComentario the idComentario to set
	 */
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the calificacion
	 */
	public int getCalificacion() {
		return calificacion;
	}
	/**
	 * @param calificacion the calificacion to set
	 */
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	/**
	 * @return the libro
	 */
	public Libro getLibro() {
		return libro;
	}
	/**
	 * @param libro the libro to set
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

}
