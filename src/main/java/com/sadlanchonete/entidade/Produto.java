package com.sadlanchonete.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_produto")
	@SequenceGenerator(name="seq_produto", allocationSize=25)
	private int id;
	
	@Column(length = 24)
	private String nomeProduto;
	
	@Column()
	private float preco;
	
	@OneToMany(mappedBy = "produto", targetEntity = ProdutoComponente.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ProdutoComponente> produtoComponentes;

	@Transient
	private List<Componente> componentes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public List<ProdutoComponente> getProdutoComponentes() {
		return produtoComponentes;
	}

	public void setProdutoComponentes(List<ProdutoComponente> produtoComponentes) {
		this.produtoComponentes = produtoComponentes;
	}

	public List<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

}
