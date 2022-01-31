package br.proj.rd;

public class User {

	private String nome;
	private String email;
	private String pais;
	int id;
	
	public User() {
		
	}
	
	public User(String nome, String email, String pais, int id) {
		this.nome = nome;
		this.email = email;
		this.pais = pais;
		this.id = id;
	}
	
	public User(String nome, String email, String pais) {
		this.nome = nome;
		this.email = email;
		this.pais = pais;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
	
}
