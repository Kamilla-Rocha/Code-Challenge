package br.digitalRepublic.Exception;

public class SaldoInsuficienteException extends DefaultException {
	

	private int codigo;
	private String mensagem;

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

	public SaldoInsuficienteException(int codigo, String mensagem) {
		super(codigo, mensagem);
		this.codigo = codigo;
		this.mensagem = mensagem;

	}

}
