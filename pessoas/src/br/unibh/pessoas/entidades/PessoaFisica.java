package br.unibh.pessoas.entidades;

import java.util.Date;

public class PessoaFisica extends Pessoa{

	private String cpf;
	private String email;
	private Date dataNascimento;
	private String sexo;
	
		
	public PessoaFisica(Long id, String nome, String endere�o, String telefone, String cpf, String email,
			Date dataNascimento, String sexo) {
		super(id, nome, endere�o, telefone);
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}
	public PessoaFisica(String cpf, String email, Date dataNascimento, String sexo) {
		super();
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "PessoaFisica [cpf=" + cpf + ", email=" + email + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo
				+ ", getId()=" + getId() + ", getNome()=" + getNome() + ", getEndere�o()=" + getEndereco()
				+ ", getTelefone()=" + getTelefone() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	
}
