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

import br.unibh.servicospessoas.entidades.PessoaFisica;
import br.unibh.servicospessoas.persistencia.PessoaFisicaDAO;
// The Java class will be hosted at the URI path "/pessoafisica"
@Path("/pessoafisica")
public class ServicoPessoaFisicaRestJson {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<PessoaFisica> listar(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		return dao.findAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public PessoaFisica buscar(@PathParam("id") Long id) {
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		return dao.find(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public PessoaFisica salvar(PessoaFisica p){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		dao.insert(p);
		
		PessoaFisica busca = dao.find(p.getCpf());
		return busca;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public PessoaFisica atualizar(PessoaFisica p) {
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		dao.update(p);
		
		return dao.find(p.getId());
	}
	
	@DELETE
	@Path("/{id}")
	public void deletar(@PathParam("id") Long id) {
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		
		PessoaFisica pessoa = dao.find(id);
		
		dao.delete(pessoa);
	}
}
