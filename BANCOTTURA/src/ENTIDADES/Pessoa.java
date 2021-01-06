package ENTIDADES;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA")
public class Pessoa {
	
	@Id
	@Column(name = "CPF", nullable = false)
	private String cpf;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "IDADE", nullable = false)
	private int idade;
	
	@Column(name = "GENERO", nullable = false)
	private String genero;
	
	@OneToMany
	@JoinColumn(name = "ID_ENDERECO", referencedColumnName =  "ID_ENDERECO", nullable = false)
	private int id_endereco;
	
	@OneToMany
	@JoinColumn(name = "NUMERO_CONTA", referencedColumnName = "NUMERO", nullable = false)
	private int numero_conta;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}


	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public int getNumero_conta() {
		return numero_conta;
	}

	public void setNumero_conta(int numero_conta) {
		this.numero_conta = numero_conta;
	}
	
	

}
