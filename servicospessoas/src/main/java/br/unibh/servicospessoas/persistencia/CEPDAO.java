package br.unibh.servicospessoas.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.unibh.servicospessoas.entidades.CEP;

public class CEPDAO implements DAO<CEP, Long> {

	@Override
	public CEP find(Long id) {
		try {

			String sql = "select * from tb_cep WHERE cep = ?";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setLong(1, id);

			ResultSet res = qb.executeQuery();
			
			if (res.next()) {
				return new CEP(
						res.getLong("cep"),
						res.getString("endereco"), 
						res.getString("cidade")); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return null;
	}

	@Override
	public void insert(CEP t) {
		try {

			String sql = "INSERT INTO tb_cep"
					 	+"(cep, endereco, cidade)"
					 	+"VALUES(?, ?, ?)";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setLong(1, t.getCep());
			qb.setString(2, t.getEndereco());
			qb.setString(3, t.getCidade());
			
			qb.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
	}

	@Override
	public void update(CEP t) {
		try {

			String sql = "UPDATE tb_cep SET"
					 	+" cep = ?, endereco = ?, cidade = ? WHERE cep = ?";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			
			qb.setLong(1, t.getCep());
			qb.setString(2, t.getEndereco());
			qb.setString(3, t.getCidade());
			qb.setLong(4, t.getCep());
			
			qb.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
	}

	@Override
	public void delete(CEP t) {
		try {

			String sql = "DELETE FROM tb_cep WHERE cep = ?";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setLong(1, t.getCep());
			
			qb.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
	}

	@Override
	public List<CEP> findAll() {
		List<CEP> listaCep = new ArrayList<CEP>();
		try {
			
			String sql = "select * from tb_cep";
			ResultSet res = JDBCUtil.getConnection().
					prepareStatement(sql).executeQuery();
			
			while (res.next()) {
				listaCep.add(new CEP(
						res.getLong("cep"),
						res.getString("endereco"), 
						res.getString("cidade")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return listaCep;
	}

	public List<CEP> findCep(String endereco) {
		List<CEP> listaCep = new ArrayList<CEP>();
		try {
			
			String sql = "select * from tb_cep WHERE endereco LIKE ?";
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
					
			qb.setString(1, "%"+endereco+"%");
			
			ResultSet res = qb.executeQuery();
			
			while (res.next()) {
				listaCep.add(new CEP(
						res.getLong("cep"),
						res.getString("endereco"), 
						res.getString("cidade")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return listaCep;
	}
}
