package DAO;

import java.util.List;

import ENTIDADES.Conta;
import EXCEPTIONS.BancoVazioException;
import EXCEPTIONS.ElementoNaoEncontradoException;
import EXCEPTIONS.RegistroAlteradoException;
import EXCEPTIONS.RegistroCadastradoComSucessoException;
import EXCEPTIONS.RegistroExcluidoException;

public interface ContaDAO {
	
//	Inserir
	public void inserir(Conta conta) throws RegistroCadastradoComSucessoException;
	
//	Listar
	public List<Conta> listarConta() throws BancoVazioException;
	
// Alterar
	public void alterar (Conta conta) throws RegistroAlteradoException;
	
//	Remove
	public void remover(int numero) throws RegistroExcluidoException;
	
//	Search
	public Conta pesquisar(int numero) throws ElementoNaoEncontradoException;



	

}
