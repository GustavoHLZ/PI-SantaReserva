package modelo;

public class Quartos {

	private int idQuarto;
	private String tipo;
	private Float preco;
	private Boolean disp;
	private int cap;
	private int temp;
	
	
	
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public int getidQuarto() {
		return idQuarto;
	}
	public void setidQuarto (int idQuarto) {
		idQuarto = idQuarto;
	}
	public String gettipo() {
		return tipo;
	}
	public void settipo(String tipo) {
		tipo = tipo;
	}
	public Float getpreco() {
		return preco;
	}
	public void setpreco(Float preco) {
		preco = preco;
	}
	public Boolean getdisp() {
		return disp;
	}
	public void setdispo(Boolean disp) {
		disp = disp;
	}
	public int getcap() {
		return cap;
	}
	public void setcap(int cap) {
		cap = cap;
	}

}
