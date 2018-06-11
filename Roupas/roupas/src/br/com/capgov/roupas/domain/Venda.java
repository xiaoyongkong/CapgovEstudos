package br.com.capgov.roupas.domain;

import java.math.BigDecimal;
import java.sql.Date;

public class Venda {
	
	private Date horario;
	private BigDecimal valor;
	private Vendendor vendedor;
	private Roupa roupa;
	
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Vendendor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendendor vendedor) {
		this.vendedor = vendedor;
	}
	public Roupa getRoupa() {
		return roupa;
	}
	public void setRoupa(Roupa roupa) {
		this.roupa = roupa;
	}

}
