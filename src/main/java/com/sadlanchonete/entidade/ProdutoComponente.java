package com.sadlanchonete.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ProdutoComponente {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_produto_componente")
	@SequenceGenerator(name="seq_produto_componente", allocationSize=25)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_produto", updatable = true, insertable = true, columnDefinition = "id_produto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "id_componente", updatable = true, insertable = true, columnDefinition = "id_componente")
	private Componente componente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Componente getComponente() {
		return componente;
	}

	public void setComponente(Componente componente) {
		this.componente = componente;
	}

}
