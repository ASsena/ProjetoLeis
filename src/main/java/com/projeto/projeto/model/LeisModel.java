package com.projeto.projeto.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "leis")
public class LeisModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	String nome;
	String numero;
	String descricao;
	LocalDate date;
	
	public LeisModel(Long id, String nome, String numero, String descricao, LocalDate date) {
		this.id = id;
		this.nome = nome;
		this.numero = numero;
		this.descricao = descricao;
		this.date = date;
	}
	
	public LeisModel() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}




}
