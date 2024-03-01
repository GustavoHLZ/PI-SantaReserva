package modelo;

public class Servicos {
	private int ID_servico;
	private String Nome_servico;
	private float Preco_servico;
	private Boolean Pag_Efetuado;
	
	public int getID_servico() {
		return ID_servico;
	}
	public void setID_servico(int iD_servico) {
		ID_servico = iD_servico;
	}
	public String getNome_servico() {
		return Nome_servico;
	}
	public void setNome_servico(String nome_servico) {
		Nome_servico = nome_servico;
	}
	public float getPreco_servico() {
		return Preco_servico;
	}
	public void setPreco_servico(float preco_servico) {
		Preco_servico = preco_servico;
	}
	public Boolean getPag_Efetuado() {
		return Pag_Efetuado;
	}
	public void setPag_Efetuado(Boolean pag_Efetuado) {
		Pag_Efetuado = pag_Efetuado;
	}

}
