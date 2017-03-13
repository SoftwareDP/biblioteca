package co.edu.uniquindio.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import co.edu.uniquindio.entidades.Libro;
import co.edu.uniquindio.entidades.Resena;
import co.edu.uniquindio.entidades.Usuario;
import co.edu.uniquindio.negocio.NegocioEJB;

@ManagedBean(name = "operacionBean")
@ViewScoped
public class OperacionBean {

	private String[] selectedConsoles;

	private List<Libro> libros;

	private String cadenaBusqueda;
	
	private String isbn;

	@Inject
	private NegocioEJB negocioEJB;
	Usuario usuario = new Usuario();
	Resena rese=new Resena();

	@PostConstruct
	public void init() {
		cadenaBusqueda = "";
	
		libros = new ArrayList<>();
	}

	public void agregarUsuario() {
		negocioEJB.crearUsuario(usuario);
		usuario = new Usuario();
	}

	public void consultar(){
		libros=new ArrayList<>();
		System.out.println(cadenaBusqueda);
		libros=negocioEJB.realizarPara(cadenaBusqueda, selectedConsoles);
	}
	

	
	/**
	 * @return the libros
	 */
	public List<Libro> getLibros() {
		return libros;
	}

	/**
	 * @param libros the libros to set
	 */
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String[] getSelectedConsoles() {
		return selectedConsoles;
	}

	public void setSelectedConsoles(String[] selectedConsoles) {
		this.selectedConsoles = selectedConsoles;
	}

	/**
	 * @return the cadenaBusqueda
	 */
	public String getCadenaBusqueda() {
		return cadenaBusqueda;
	}

	/**
	 * @param cadenaBusqueda
	 *            the cadenaBusqueda to set
	 */
	public void setCadenaBusqueda(String cadenaBusqueda) {
		this.cadenaBusqueda = cadenaBusqueda;
	}

	/**
	 * @return the rese
	 */
	public Resena getRese() {
		return rese;
	}

	/**
	 * @param rese the rese to set
	 */
	public void setRese(Resena rese) {
		this.rese = rese;
	}

	public void guardar(){
		Libro l=new Libro();
		l.setIdLibro(1);
		l.setIsbn(isbn);
		Usuario us =(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		rese.setLibro(l);
		rese.setUsuario(us);
		negocioEJB.registrarComentario(rese);
		
		
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
