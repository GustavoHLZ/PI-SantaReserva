package modelo;

public class Servicos_Consumidos {
	private int ID_Servico_Consumido;
	private int FK_ID_Hospede;
	private int FK_Servico;
	
	public int getFK_ID_Hospede() {
		return FK_ID_Hospede;
	}
	public void setFK_ID_Hospede(int fK_ID_Hospede) {
		FK_ID_Hospede = fK_ID_Hospede;
	}
	public int getFK_Servico() {
		return FK_Servico;
	}
	public void setFK_Servico(int fK_Servico) {
		FK_Servico = fK_Servico;
	}
	public int getID_Servico_Consumido() {
		return ID_Servico_Consumido;
	}
	public void setID_Servico_Consumido(int iD_Servico_Consumido) {
		ID_Servico_Consumido = iD_Servico_Consumido;
	}

}
