package br.unibh.pessoas.entidades;

import java.util.Date;

public class PessoaJuridica extends Pessoa{

	
	private String cnpj;
	private Date dataConstituicao;
	private String site;
	
	
	
	public PessoaJuridica(Long id, String nome, String endereço, String telefone, String cnpj, Date dataConstituicao,
			String site) {
		super(id, nome, endereço, telefone);
		this.cnpj = cnpj;
		this.dataConstituicao = dataConstituicao;
		this.site = site;
	}
	
	
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Date getDataConstituicao() {
		return dataConstituicao;
	}
	public void setDataConstituicao(Date dataConstituicao) {
		this.dataConstituicao = dataConstituicao;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}

	
	
	
	
	
}
