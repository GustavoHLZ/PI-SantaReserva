package modelo;

public class Avaliacoes {
	private int idAvaliacao;
	private float avaliacao;
	private String avaliador;
	private Hospedes fkIDHospede;
	
	public int getIdAvaliacao() {
		return idAvaliacao;
	}
	public void setIdAvaliacao(int idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}
	public float getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(float avaliacao) {
		this.avaliacao = avaliacao;
	}
	public String getAvaliador() {
		return avaliador;
	}
	public void setAvaliador(String avaliador) {
		this.avaliador = avaliador;
	}
	public Hospedes getFkIDHospede() {
		return fkIDHospede;
	}
	public void setFkIDHospede(Hospedes usuariologado) {
		this.fkIDHospede = usuariologado;
	}
	
	
	
	
		
}
