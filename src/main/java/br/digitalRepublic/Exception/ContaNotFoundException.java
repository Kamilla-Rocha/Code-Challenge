package br.digitalRepublic.Exception;


public class ContaNotFoundException extends DefaultException{
	
	
	private int codigo;
	private String mensagem;
	
	
	public ContaNotFoundException(int codigo,String mensagem) {
		super(codigo,mensagem);
		this.codigo=codigo;
		this.mensagem=mensagem;	
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
	
	
	
	
	
	
	
	


