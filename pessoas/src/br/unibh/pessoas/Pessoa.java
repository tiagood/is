package br.unibh.pessoas;

public class Pessoa {
	
	//variavéis de instâncias 
	private Long id;
	private String nome;
	private String endereço;
	private String telefone;

	
	

	//Construtores
	public Pessoa() { }
	
	
	public Pessoa(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Pessoa(Long id, String nome, String endereço, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereço = endereço;
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
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
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
		return "Pessoa [id=" + id + ", nome=" + nome + ", endereço=" + endereço + ", telefone=" + telefone + "]";
	}
	

}
