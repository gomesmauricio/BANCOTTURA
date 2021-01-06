package DAO;

import java.util.List;

import ENTIDADES.Pessoa;
import EXCEPTIONS.BancoVazioException;
import EXCEPTIONS.ElementoNaoEncontradoException;
import EXCEPTIONS.RegistroAlteradoException;
import EXCEPTIONS.RegistroCadastradoComSucessoException;
import EXCEPTIONS.RegistroExcluidoException;

public interface PessoaDAO {
	
//	Inserir
	public void inserir(Pessoa pessoa) throws RegistroCadastradoComSucessoException;
	
//	Listar
	public List<Pessoa> listarPessoa()throws BancoVazioException;
	
// Alterar
	public void alterar (Pessoa pessoa) ;
	
//	Remove
	public void remover(String CPF) throws RegistroExcluidoException;
	
//	Search
	public Pessoa pesquisar(String cpf) throws ElementoNaoEncontradoException;

	

}
