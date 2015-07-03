package com.sadlanchonete.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Componente {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_componente")
	@SequenceGenerator(name="seq_componente", allocationSize=25)
	private int id;
	
	@Column(length = 60)
	private String nomeComponente;
	
	@Column(length = 60)
	private String tipoComponente;
	
	@Column(length = 60)
	private String undMedida;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeComponente() {
		return nomeComponente;
	}

	public void setNomeComponente(String nomeComponente) {
		this.nomeComponente = nomeComponente;
	}

	public String getTipoComponente() {
		return tipoComponente;
	}

	public void setTipoComponente(String tipoComponente) {
		this.tipoComponente = tipoComponente;
	}

	public String getUndMedida() {
		return undMedida;
	}

	public void setUndMedida(String undMedida) {
		this.undMedida = undMedida;
	}

}
