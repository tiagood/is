package br.unibh.servicospessoas.servicos;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unibh.servicospessoas.entidades.PessoaJuridica;
import br.unibh.servicospessoas.persistencia.PessoaJuridicaDAO;

@Path("/pessoajuridica")
public class ServicoPessoaJuridicaRestJson {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<PessoaJuridica> listar(){
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		return dao.findAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public PessoaJuridica buscar(@PathParam("id") Long id) {
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		return dao.find(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public PessoaJuridica salvar(PessoaJuridica p){
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		dao.insert(p);
		
		PessoaJuridica busca = dao.find(p.getCnpj());
		return busca;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public PessoaJuridica atualizar(@PathParam("id") Long id, PessoaJuridica p) {
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		p.setId(id);
		dao.update(p);
		
		return dao.find(p.getId());
	}
	
	@DELETE
	@Path("/{id}")
	public void deletar(@PathParam("id") Long id) {
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		
		PessoaJuridica pessoa = dao.find(id);
		
		dao.delete(pessoa);
	}
}
