package modelo;

public class Servicos {
	private int idservico;
	private String nomeServico;
	private float precoServico;
	private Boolean pagEfetuado;
	
	public int getidServico() {
		return idservico;
	}
	public void setidServico(int idServico) {
		idservico = idServico;
	}
	public String getnomeServico() {
		return nomeServico;
	}
	public void setnomeServico(String nomeServico) {
		nomeServico = nomeServico;
	}
	public float getprecoServico() {
		return precoServico;
	}
	public void setPreco_servico(float precoServico) {
		precoServico = precoServico;
	}
	public Boolean getpagEfetuado() {
		return pagEfetuado;
	}
	public void setpagEfetuado(Boolean pagEfetuado) {
		pagEfetuado = pagEfetuado;
	}

}
