package br.digitalRepublic.model;

import java.util.Arrays;

public enum TipoDeTransacao {
	
	TRANSFERENCIA(1), DEPOSITO(2);
	
	private int code;

	private TipoDeTransacao(int code) {
		this.code=code;

	
	}

	public int getCode() {
		return code;
	}

	
	public static  TipoDeTransacao valueOf(int code) {
		return Arrays.stream(TipoDeTransacao.values()).filter(tipo -> tipo.getCode()==code).findFirst().orElseThrow(
				() -> new IllegalArgumentException("Código de transação inválido"));
				
	}
	
	
	
	

}
