package modelo;

public class Avaliacoes {
	private int ID_avaliacao;
	public int getFK_ID_Hospede() {
		return FK_ID_Hospede;
	}
	public void setFK_ID_Hospede(int fK_ID_Hospede) {
		FK_ID_Hospede = fK_ID_Hospede;
	}
	private float Avaliacao;
	private int FK_ID_Hospede;
	public int getID_avaliacao() {
		return ID_avaliacao;
	}
	public void setID_avaliacao(int iD_avaliacao) {
		ID_avaliacao = iD_avaliacao;
	}
	public float getAvaliacao() {
		return Avaliacao;
	}
	public void setAvaliacao(float avaliacao) {
		Avaliacao = avaliacao;
	}
	public String getAvaliador() {
		return Avaliador;
	}
	public void setAvaliador(String avaliador) {
		Avaliador = avaliador;
	}
	private String Avaliador;
	

}
