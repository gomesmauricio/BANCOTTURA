package EXCEPTIONS;

public class BancoVazioException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/** 
	 * Construtor da classe.
	 * N�o recebe parametros.
	 * Mensagem de alerta para o usuario.
	 * Exce��o caso n�o exista o registro procurado no banco de dados.
	 **/
	
	public BancoVazioException() {
		
		super("Nem um registro cadastrado na base de dados");
		
	}
	
}
