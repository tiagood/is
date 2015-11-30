package br.unibh.pessoas;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.pessoas.entidades.PessoaFisica;
import br.unibh.pessoas.entidades.PessoaJuridica;
import br.unibh.pessoas.persistencia.PessoaFisicaDAO;
import br.unibh.pessoas.persistencia.PessoaJuridicaDAO;


public class Teste {
	
	/**********************/
	// Teste PessoaFisica /
	
    @Test
	public void testePessoaFisicaFindAll(){
    	
    	PessoaFisicaDAO dao =  new PessoaFisicaDAO();
    	List<PessoaFisica> l = dao.findAll(); 
    	Assert.assertEquals(l.size (),  100);
    
    }

    
    @Test
	public void testePessoaFisicaFind(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica pessoa = dao.find(3L);
		Assert.assertEquals(pessoa.getNome(), "Harrison R. Brooks");
	}
    
    
    @Test
	public void testePessoaFisicaInserirEExcluir(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica p = new PessoaFisica(101l, "Tiago de Oliveira", "Rua Vaduz", "3195005885", "07919262658", "tiagood85@me.com", new Date(), "M");
		dao.insert(p);
		PessoaFisica pessoa = dao.find("Tiago de Oliveira");
		Assert.assertEquals(pessoa.getNome(), "Tiago de Oliveira");
		
		dao.delete(pessoa);
		
		PessoaFisica pessoa2 = dao.find("Tiago de Oliveira");
		Assert.assertNull(pessoa2);
	}
    
    @Test
	public void testePessoaFisicaUpdateEExcluir(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica p = new PessoaFisica(101l, "Tiago de Oliveira", "Rua Vaduz", "3195005885", "07919262658", "tiagood85@me.com", new Date(), "M");
		dao.insert(p);
		PessoaFisica pessoa = dao.find("Tiago de Oliveira");
		Assert.assertEquals(pessoa.getNome(), "Tiago de Oliveira");
		
		dao.delete(pessoa);
		
		PessoaFisica pessoa2 = dao.find("Tiago de Oliveira");
		Assert.assertNull(pessoa2);
	}
    
    
    /**********************/
	// Teste PessoaJuridica /
	
    
    @Test
	public void testePessoaJuridicaFindAll(){
		
		List<PessoaJuridica> lista = new PessoaJuridicaDAO().findAll();
		Assert.assertEquals(lista.size(), 100);
		
	}
	
   
    @Test
	public void testePessoaJuridicaFind(){
		
		PessoaJuridica pessoa = new PessoaJuridicaDAO().find(1L);
		Assert.assertEquals("Daria U. Barton", pessoa.getNome());
		
	}
	
	@Test
	public void testaPessoaJuridicaInserirExcluir(){
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		PessoaJuridica pf = new PessoaJuridica(null, "Tiago SA", "Rua Vaduz", 
				"3134528726", "12345678901234", new Date(), "tiago.com");
		
		dao.insert(pf);
		
		PessoaJuridica pf2 = dao.find("Tiago SA");
		
		Assert.assertNotNull(pf2);
		
		dao.delete(pf2);
		PessoaJuridica pf3 = dao.find("Tiago SA");
		
		Assert.assertNull(pf3);
	}
	
	@Test
	public void testaPessoaJuridicaAtualizar(){
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		PessoaJuridica pf = new PessoaJuridica(null, "Tiago SA", "Rua Vaduz", 
				"3134538726", "12345678901234", new Date(), "tiago.com");
		
		dao.insert(pf);
		
		PessoaJuridica pf2 = dao.find("Tiago SA");
		pf2.setNome("Isabela SA");
		pf2.setSite("isabela.com");
		dao.update(pf2);
		
		PessoaJuridica pf3 = dao.find("Isabela SA");
		Assert.assertEquals("isabela.com", pf3.getSite());

		Assert.assertNotNull(pf2);
		dao.delete(pf3);
		
		PessoaJuridica pf4 = dao.find("Isabela SA");
		Assert.assertNull(pf4);
	}
    
   
    
    
    
    
}
