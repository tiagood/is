package br.unibh.pessoas.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.unibh.pessoas.entidades.PessoaFisica;

public class PessoaFisicaDAO implements DAO<PessoaFisica, Long> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public PessoaFisica find(Long id) {
		try {

			String sql = "select * from tb_pessoa_fisica WHERE id = ?";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setLong(1, id);

			ResultSet res = qb.executeQuery();
			
			if (res.next()) {
				return new PessoaFisica(
						res.getLong("id"),
						res.getString("nome"), 
						res.getString("endereco"), 
						res.getString("telefone"), 
						res.getString("cpf"), 
						res.getString("email"), 
						res.getDate("data_nascimento"), 
						res.getString("sexo")); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return null;
	}

	public PessoaFisica find(String nome) {
		try {

			String sql = "select * from tb_pessoa_fisica WHERE nome = ?";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setString(1, nome);

			ResultSet res = qb.executeQuery();
			
			if (res.next()) {
				return new PessoaFisica(
						res.getLong("id"),
						res.getString("nome"), 
						res.getString("endereco"), 
						res.getString("telefone"), 
						res.getString("cpf"), 
						res.getString("email"), 
						res.getDate("data_nascimento"), 
						res.getString("sexo")); 
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return null;
	}
	
	@Override
	public void insert(PessoaFisica t) {
		try {

			String sql = "INSERT INTO tb_pessoa_fisica"
					 	+"(nome, endereco, telefone, cpf, email, data_nascimento, sexo)"
					 	+"VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setString(1, t.getNome());
			qb.setString(2, t.getEndereco());
			qb.setString(3, t.getTelefone());
			qb.setString(4, t.getCpf());
			qb.setString(5, t.getEmail());
			qb.setString(6, dateFormat.format(t.getDataNascimento()));
			qb.setString(7, t.getSexo());
			
			qb.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
	}

	@Override
	public void update(PessoaFisica t) {
		try {

			String sql = "UPDATE tb_pessoa_fisica SET"
					 	+"nome = ?, endereco = ?, telefone = ?, cpf =?, email = ?, data_nascimento = ?, sexo = ?";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setString(1, t.getNome());
			qb.setString(2, t.getEndereco());
			qb.setString(3, t.getTelefone());
			qb.setString(4, t.getCpf());
			qb.setString(5, t.getEmail());
			qb.setString(6, dateFormat.format(t.getDataNascimento()));
			qb.setString(7, t.getSexo());
			
			qb.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
	}

	@Override
	public void delete(PessoaFisica t) {
		try {

			String sql = "DELETE FROM tb_pessoa_fisica WHERE id = ?";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setLong(1, t.getId());
			
			qb.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
	}

	@Override
	public List<PessoaFisica> findAll() {
		List<PessoaFisica> listaPesoaFisica = new ArrayList<PessoaFisica>();
		try {
			
			String sql = "select * from tb_pessoa_fisica";
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
			JDBCUtil.closeConnection();
		}
		return listaPesoaFisica;
	}

}