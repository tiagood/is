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

import br.unibh.servicospessoas.entidades.CEP;
import br.unibh.servicospessoas.persistencia.CEPDAO;

@Path("/cep")
public class ServicoCEPRestJson {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<CEP> listar(){
		CEPDAO dao = new CEPDAO();
		return dao.findAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public CEP buscar(@PathParam("id") Long id) {
		CEPDAO dao = new CEPDAO();
		return dao.find(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar/{endereco}")
	public List<CEP> listar(@PathParam("endereco") String endereco) {
		CEPDAO dao = new CEPDAO();
		return dao.findCep(endereco);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/salvar")
	public CEP salvar(CEP c){
		CEPDAO dao = new CEPDAO();
		dao.insert(c);
		
		CEP busca = dao.find(c.getCep());
		return busca;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{cep}")
	public CEP atualizar(@PathParam("cep") Long cep, CEP c) {
		CEPDAO dao = new CEPDAO();
		c.setCep(cep);
		dao.update(c);
		
		return dao.find(c.getCep());
	}
	
	@DELETE
	@Path("/{cep}")
	public String deletar(@PathParam("cep") Long cep) {
		CEPDAO dao = new CEPDAO();
		
		CEP busca = dao.find(cep);
		
		dao.delete(busca);
		
		return "CEP Excluido";
	}
}
