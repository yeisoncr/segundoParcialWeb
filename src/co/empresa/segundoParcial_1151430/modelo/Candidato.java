package co.empresa.segundoParcial_1151430.modelo;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor


public class Candidato implements Serializable {
	private Integer id;
	private String nombre;
	private String apellido;
	private String documento;
	private Integer numero;
	
	public Candidato(String documento,String nombre,String apellido,Integer numero) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.numero= numero;
	}
	

}
