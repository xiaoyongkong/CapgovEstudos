package br.com.capgov.roupas.bean;

import br.com.capgov.roupas.Dao.ConsultaRoupasDAO;
import br.com.capgov.roupas.domain.*;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "MBRoupasBean")
@ViewScoped

public class RoupasBean {
	
	private Roupa roupaRegistro = new Roupa();
	private ListDataModel<Roupa> roupaConsulta;
	
	public Roupa getRoupaRegistro() {
		return roupaRegistro;
	}

	public void setRoupaRegistro(Roupa roupaRegistro) {
		this.roupaRegistro = roupaRegistro;
	}

	public ListDataModel<Roupa> getRoupaConsulta() {
		return roupaConsulta;
	}

	public void setRoupaConsulta(ListDataModel<Roupa> roupaConsulta) {
		this.roupaConsulta = roupaConsulta;
	}

	@PostConstruct
	public void consultar(){
		try {
			ConsultaRoupasDAO dao = new ConsultaRoupasDAO();
			ArrayList<Roupa> lista = dao.ConsultaRoupa();
			roupaConsulta = new ListDataModel<Roupa>(lista);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void registrar(){
		try{
			ConsultaRoupasDAO dao = new ConsultaRoupasDAO();
			dao.InsereRoupa(roupaRegistro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
