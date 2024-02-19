package modelo;

public class Avaliacoes {
	private int ID_avaliacao;
	private float Avaliacao;
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
