package br.digitalRepublic.Exception;

public class MensagemErro {
	
private final int codigo;
private final String mensagem;

	public MensagemErro(int codigo, String mensagem) {
		this.codigo=codigo;
		this.mensagem=mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	public int getCodigo() {
		return codigo;
	
	}	

}
