package EXCEPTIONS;

public class ElementoExisteException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/** 
	 * Construtor da classe.
	 * N�o recebe parametros.
	 * Mensagem de alerta para o usuario.
	 * Exce��o caso exista um registro ja existente n banco de dados.
	 **/
	
	public ElementoExisteException() {
		super("Registro j� Cadastrado...");
		
	}

}
