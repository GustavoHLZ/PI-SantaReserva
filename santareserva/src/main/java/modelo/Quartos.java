package modelo;

public class Quartos {

	private int ID_Quarto;
	private String Tipo_Quarto;
	private Float Preco_Diaria;
	private Boolean Dispo_Quarto;
	private int Cap_max;
	public int getID_Quarto() {
		return ID_Quarto;
	}
	public void setID_Quarto(int iD_Quarto) {
		ID_Quarto = iD_Quarto;
	}
	public String getTipo_Quarto() {
		return Tipo_Quarto;
	}
	public void setTipo_Quarto(String tipo_Quarto) {
		Tipo_Quarto = tipo_Quarto;
	}
	public Float getPreco_Diaria() {
		return Preco_Diaria;
	}
	public void setPreco_Diaria(Float preco_Diaria) {
		Preco_Diaria = preco_Diaria;
	}
	public Boolean getDispo_Quarto() {
		return Dispo_Quarto;
	}
	public void setDispo_Quarto(Boolean dispo_Quarto) {
		Dispo_Quarto = dispo_Quarto;
	}
	public int getCap_max() {
		return Cap_max;
	}
	public void setCap_max(int cap_max) {
		Cap_max = cap_max;
	}

}
