package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ENTIDADES.Conta;
import EXCEPTIONS.BancoVazioException;
import UTIL.JdbcUtil;

public class ContaDAOimplemente implements ContaDAO{

	@Override
	public void inserir(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Conta> listarConta() throws BancoVazioException {
		
		List<Conta> listConta = new ArrayList<Conta>();
		Conta conta = null;
		ResultSet rs = null;
		
		Connection conexao = null;

		String sql = "SELECT * FROM conta";

		try {

			conexao = JdbcUtil.getConexao();

			PreparedStatement ps = conexao.prepareStatement(sql);

			while (rs.next()) {
				conta = new Conta();

				conta.setNumero(rs.getInt("numero"));
				conta.setSaldo(rs.getDouble("saldo"));
				conta.setLimite(rs.getDouble("limite"));


				listConta.add(conta);
			}

			ps.execute();
			ps.close();
			

			if (listConta.isEmpty()) {
				throw new BancoVazioException();
			} else {
				return listConta;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	
	}

	@Override
	public void alterar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Conta pesquisar(int numero) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
