package co.edu.uniquindio.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import co.edu.uniquindio.entidades.Usuario;

@ManagedBean(name="platillaController")
@ViewScoped
public class PlantillaController {

	
	public void verificarSesion(){
		try {
			Usuario us =(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
	
			if (us==null){
			FacesContext.getCurrentInstance().getExternalContext().redirect("./../permisos.xhtml");
			}
		} catch (Exception e) {
			//log
		}
	}
}
