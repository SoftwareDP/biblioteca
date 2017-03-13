package co.edu.uniquindio.entidades;

import java.io.Serializable;

import javax.persistence.*;
;

@Entity
@Table(name="compraxlibro")
public class Compra_x_Libro implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idCompraLibro;
	
	@ManyToOne
	@JoinColumn(name="idLibro")
	private Libro libro;
	
	@ManyToOne
	@JoinColumn(name="idCompra")
	private Compra compra;
	
	
	
	
}
