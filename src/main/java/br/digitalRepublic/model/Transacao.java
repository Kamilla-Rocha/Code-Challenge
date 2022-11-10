package br.digitalRepublic.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tb_transacao")
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.ORDINAL)
	private TipoDeTransacao tipo;

	private BigDecimal valor;

	@Column(name = "destinatario_id")
	@JsonProperty("destinatario_id")
	private Integer destinatarioId;

	@Column(name = "remetente_id")
	@JsonProperty("remetente_id")
	private Integer remetenteId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoDeTransacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeTransacao tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getDestinatarioId() {
		return destinatarioId;
	}

	public void setDestinatarioId(Integer destinatarioId) {
		this.destinatarioId = destinatarioId;
	}


	public Integer getRemetenteId() {
		return remetenteId;
	}


	public void setRemetenteId(Integer remetenteId) {
		this.remetenteId = remetenteId;
	}

	
	
}
