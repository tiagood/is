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
		 
		
		List<PessoaFisica> listaPesoaFisica = new ArrayList<PessoaFisica>();
		try {
			
			String sql = "select * from pessoa_fisica";
			ResultSet res = JDBCUtil.getConnection().
					prepareStatement(sql).executeQuery();
			
			while (res.next()) {
				listaPesoaFisica.add(new PessoaFisica(
						res.getLong("id"),
						res.getString("nome"), 
						res.getString("endereco"), 
						res.getString("telefone"), 
						res.getString("cpf"), 
						res.getString("email"), 
						res.getDate("data_nascimento"), 
						res.getString("sexo")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return listaPesoaFisica;
	}

}
