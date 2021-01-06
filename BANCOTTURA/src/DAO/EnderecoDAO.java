package DAO;

import java.util.List;

import ENTIDADES.Endereco;

public interface EnderecoDAO {
	
//	Inserir
	public void inserir(Endereco endereco);
	
//	Listar
	public List<Endereco> listarEndereco();
	
// Alterar
	public void alterar (Endereco endereco);
	
//	Remove
	public void remover(int Id_endereco);
	
//	Search
	public Endereco pesquisar(int Id_endereco);


}
