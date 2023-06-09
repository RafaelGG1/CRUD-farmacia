package com.generation.farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do atributo categoria é obrigatório!")
	@Size(min = 5, max = 80, message = "A categoria deve conter no mínimo 05 e no máximo 100 caracteres")
	private String categoria;
	
	@NotBlank(message = "O atributo descrição é obrigatório!")
	@Size(min = 10, max = 255, message = "A descrição deve conter no mínimo 10 e no máximo 200 caracteres")
	private String descricao;
	
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<Produto> getProduto() {
		return produto;
	}


	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
}