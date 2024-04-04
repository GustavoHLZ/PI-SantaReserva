package modelo;

public class Espacos_Reservados {
	private int idEspacosReservados;
	private int fkIDHospede;
	private int fkidEspaco;
	
	public int getIdEspacosReservados() {
		return idEspacosReservados;
	}
	public void setIdEspacosReservados(int idEspacosReservados) {
		this.idEspacosReservados = idEspacosReservados;
	}
	public int getFkIDHospede() {
		return fkIDHospede;
	}
	public void setFkIDHospede(int fkIDHospede) {
		this.fkIDHospede = fkIDHospede;
	}
	public int getFkidEspaco() {
		return fkidEspaco;
	}
	public void setFkidEspaco(int fkidEspaco) {
		this.fkidEspaco = fkidEspaco;
	}
	
}
