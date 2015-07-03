package com.sadlanchonete.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Telefone {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_telefone")
	@SequenceGenerator(name="seq_telefone", allocationSize=25)
	private int id;

	@Column(length = 20, nullable = false)
	private String telefone;

	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
