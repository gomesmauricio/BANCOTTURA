package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ENTIDADES.Pessoa;
import EXCEPTIONS.RegistroCadastradoComSucessoException;
import EXCEPTIONS.RegistroExcluidoException;
import EXCEPTIONS.RegistroAlteradoException;
import EXCEPTIONS.ElementoNaoEncontradoException;
import UTIL.JdbcUtil;

public class PessoaDAOimplement implements PessoaDAO {



	private Connection conexao = null;

	@Override
	public void inserir(Pessoa pessoa) throws RegistroCadastradoComSucessoException {
		String sql = "INSERT INTO PESSOA (CPF, NOME, IDADE, GENERO, ID_ENDERECO, NUMERO_CONTA)"
				+ "VALUES (?,?,?,?,?,?)";

		Connection conexao = null;

		try {
//			Criada a abertura de conexao
			conexao = JdbcUtil.getConexao();
//			Conversão do string sql em quary sql
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setNString(1, pessoa.getCpf());
			ps.setNString(2, pessoa.getNome());
			ps.setInt(3, pessoa.getIdade());
			ps.setString(4, pessoa.getGenero());
			ps.setInt(5, pessoa.getId_endereco());
			ps.setInt(6, pessoa.getNumero_conta());

			ps.execute();
			ps.close();
//			conexao.close();

			throw new RegistroCadastradoComSucessoException();

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
	public List<Pessoa> listarPessoa() {
		String sql = "SELECT * FROM PESSOA";
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		Connection conexao;

		try {

			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setCpf(res.getString("CPF"));
				pessoa.setNome(res.getString("NOME"));
				pessoa.setIdade(res.getInt("IDADE"));
				pessoa.setGenero(res.getString("GENERO"));
				pessoa.setId_endereco(res.getInt("ENDERECO"));
				pessoa.setNumero_conta(res.getInt("NUMERO_CONTA"));

				listaPessoas.add(pessoa);
			}

			ps.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaPessoas;
	}

	@Override
	public void alterar(Pessoa pessoa) {
		
		String sql = "UPDATE PESSOA SET NOME = ?, IDADE = ?, GENERO =?, ID_ENDERECO = ?, NUMERO_CONTA = ? WHERE CPF = ?";
		
		try {
			Connection conexao ;
			conexao = JdbcUtil.getConexao();		
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString (1, pessoa.getNome()         );
			ps.setInt    (2, pessoa.getIdade()        );
			ps.setString (3, pessoa.getGenero()       );
			ps.setInt    (4, pessoa.getId_endereco()  );
			ps.setInt    (5, pessoa.getNumero_conta() );
			ps.setString (6, pessoa.getCpf()		  );
			ps.execute();
			ps.close();
//			conexao.close();
			
//			throw new RegistroAlteradoException();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

	@Override
	public void remover(String CPF) throws RegistroExcluidoException {
		String sql = "DELETE FROM PESSOA WHERE CPF = ?";
		Connection conexao = null;

		try {

			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, CPF);
			ps.execute();
			ps.close();

			throw new RegistroExcluidoException();

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
	public Pessoa pesquisar(String cpf) throws ElementoNaoEncontradoException {

		String sql = "SELECT * FROM PESSOA WHERE CPF=?";
		Connection conexao = null;
		Pessoa pessoa = new Pessoa();

		try {
			conexao = JdbcUtil.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, cpf);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				pessoa.setCpf(res.getString("CPF"));
				pessoa.setNome(res.getNString("NOME"));
				pessoa.setIdade(res.getInt("IDADE"));
				pessoa.setGenero(res.getString("GENERO"));
				pessoa.setId_endereco(res.getInt("ID_ENDERECO"));
				pessoa.setNumero_conta(res.getInt("NUMERO_CONTA"));
			}

			ps.close();
//			conexao.close();

			if (pessoa.getId_endereco() == 0) {
				throw new ElementoNaoEncontradoException();
			}else {
				return pessoa;
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
}
