package br.com.capgov.roupas.bean;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBRoupasBean")
@ViewScoped

public class RoupasBean {
	
	private String cpf;
	private String nome;
	private String descricao;
	private String tamanho;
	private int quantidade;
	private String valor;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public void registrar() throws Exception{
		try{
			System.out.println("Entrou");
			br.com.capgov.roupas.Dao.ConsultaRoupasDAO dao = new br.com.capgov.roupas.Dao.ConsultaRoupasDAO();
			dao.InsereRoupa();
			System.out.println("Saiu");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
}
