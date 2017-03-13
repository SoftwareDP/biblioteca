package co.edu.uniquindio.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RateEvent;

import co.edu.uniquindio.entidades.Usuario;
import co.edu.uniquindio.negocio.NegocioEJB;


@ManagedBean
@ViewScoped
public class LoginBean {

	@Inject
	private NegocioEJB negocioEJB;
	private String usuario;
	private String password;
	
	
	
	@PostConstruct
	private void init(){
		
	}
	
	public String login(){
		String redireccion=null;
		RequestContext context=RequestContext.getCurrentInstance();
		Usuario u=negocioEJB.validarLogin(usuario, password);
		
		if(u!=null){
		  context.execute("swal('Ingreso','Gracias por iniciar','success')");
		  redireccion="Home";
		  FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",u);
		}else{
		   context.execute("swal(' Error Ingreso','Vuelva a iniciar','error')");
		}
		usuario=password="";
		
		return redireccion;
	}
	
	
	
	

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}	
	
}
