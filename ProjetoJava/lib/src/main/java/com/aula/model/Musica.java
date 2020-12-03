package com.aula.model;

public class Musica {
	private int id;
	private String nome;
	private String artista;
	private String gravadora;
	private String estilo;
	
	public Musica() {
		
	}
	
	public Musica(int id, String nome, String artista, String gravadora, String estilo) {
		this.id = id;
		this.nome = nome;
		this.artista = artista;
		this.gravadora = gravadora;
		this.estilo = estilo;
	}
	
	public Musica(String nome, String artista, String gravadora, String estilo) {
		this.nome = nome;
		this.artista = artista;
		this.gravadora = gravadora;
		this.estilo = estilo;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getArtista() {
		return artista;
	}
	
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	public String getGravadora() {
		return gravadora;
	}
	
	public void setGravadora(String gravadora) {
		this.gravadora = gravadora;
	}
	
	public String getEstilo() {
		return estilo;
	}
	
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

}
