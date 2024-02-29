package modelo;

public class Espacos_Reservados {
	private int ID_Espacos_Reservados;
	private int FK_ID_Hospede;
	private int FK_ID_Espaco;
	public int getFK_ID_Hospede() {
		return FK_ID_Hospede;
	}
	public void setFK_ID_Hospede(int fK_ID_Hospede) {
		FK_ID_Hospede = fK_ID_Hospede;
	}
	public int getFK_ID_Espaco() {
		return FK_ID_Espaco;
	}
	public void setFK_ID_Espaco(int fK_ID_Espaco) {
		FK_ID_Espaco = fK_ID_Espaco;
	}
	public int getID_Espacos_Reservados() {
		return ID_Espacos_Reservados;
	}
	public void setID_Espacos_Reservados(int iD_Espacos_Reservados) {
		ID_Espacos_Reservados = iD_Espacos_Reservados;
	}
}
