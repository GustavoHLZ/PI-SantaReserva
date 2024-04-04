package modelo;

import java.sql.Date;

public class Espacos {
	private int idEspaco;
	private int ocupante;
	private Date checkIn;
	private Date checkOut;
	private int fkidComputador;
	private int fkidSalaReuniao;
	private int fkidQuartos;
	
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
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
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
