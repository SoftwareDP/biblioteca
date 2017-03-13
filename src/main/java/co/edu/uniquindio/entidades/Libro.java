package co.edu.uniquindio.entidades;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name="libro")
@NamedQueries({@NamedQuery(name="hola",query="select l from libro l")})
public class Libro implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLibro;
	@Column(name="nombre")
	private String nombre;
	@Column(name="autor")
	private String autor;
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="isbn")
	private String isbn;
	/**
	 * @return the idLibro
	 */
	public int getIdLibro() {
		return idLibro;
	}
	/**
	 * @param idLibro the idLibro to set
	 */
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
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
	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}
	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
