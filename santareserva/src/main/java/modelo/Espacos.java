package modelo;

import java.sql.Date;

public class Espacos {
	private int idEspaco;
	private int ocupante;
	private int fkidComputador;
	private int fkidSalaReuniao;
	private int fkidQuartos;
	private int fkidHospede;
	private int fkidPagamento;
	
	public int getFkidHospede() {
		return fkidHospede;
	}
	public void setFkidHospede(int fkidHospede) {
		this.fkidHospede = fkidHospede;
	}
	public int getFkidPagamento() {
		return fkidPagamento;
	}
	public void setFkidPagamento(int fkidPagamento) {
		this.fkidPagamento = fkidPagamento;
	}
	public int getIdEspaco() {
		return idEspaco;
	}
	public void setIdEspaco(int idEspaco) {
		this.idEspaco = idEspaco;
	}
	public int getOcupante() {
		return ocupante;
	}
	public void setOcupante(int ocupante) {
		this.ocupante = ocupante;
	}

	public int getFkidComputador() {
		return fkidComputador;
	}
	public void setFkidComputador(int fkidComputador) {
		this.fkidComputador = fkidComputador;
	}
	public int getFkidSalaReuniao() {
		return fkidSalaReuniao;
	}
	public void setFkidSalaReuniao(int fkidSalaReuniao) {
		this.fkidSalaReuniao = fkidSalaReuniao;
	}
	public int getFkidQuartos() {
		return fkidQuartos;
	}
	public void setFkidQuartos(int fkidQuartos) {
		this.fkidQuartos = fkidQuartos;
	}
	
	
	
	
}
