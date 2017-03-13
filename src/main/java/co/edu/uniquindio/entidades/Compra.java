package co.edu.uniquindio.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;




@Entity
@Table(name="compra")
public class Compra implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCompra")
	private int idCompra;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;
	
	/**
	 * @return the idCompra
	 */
	public int getIdCompra() {
		return idCompra;
	}

	/**
	 * @param idCompra the idCompra to set
	 */
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	
	
	
	
}
