package br.unibh.pessoas;

public class Pessoa {
	
	//variav�is de inst�ncias 
	private Long id;
	private String nome;
	private String endere�o;
	private String telefone;

	
	

	//Construtores
	public Pessoa() { }
	
	
	public Pessoa(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Pessoa(Long id, String nome, String endere�o, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.endere�o = endere�o;
		this.telefone = telefone;
	}
	
	
	//Get e Set
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
	public String getEndere�o() {
		return endere�o;
	}
	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	//Metodo toString
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", endere�o=" + endere�o + ", telefone=" + telefone + "]";
	}
	

}
