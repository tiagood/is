package br.unibh.pessoas.persistencia;

import java.util.List;

import br.unibh.pessoas.entidades.PessoaFisica;

public class PessoaFisicaDAO implements DAO<PessoaFisica, Long> {

	@Override
	public PessoaFisica find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(PessoaFisica t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PessoaFisica t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PessoaFisica t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PessoaFisica> findAll() {
		// TODO Auto-generated method stub
		 
		
		List <Pessoa>
		
		try {
			RessultSet res = JDBCUtil.getConnection() .prepareStatement {
				
			"select *from tb_pessoa_fsica") .executeQuery();
			
		while (res.next()) }
			
			system.out
				
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			
			
		}
		
		
		
		return null;
	}

}
