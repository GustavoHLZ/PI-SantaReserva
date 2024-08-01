package modelo;

import java.time.LocalDate;

import controle.IReserva;

public class Quartos implements IReserva{

	private int idQuarto;
	private String tipo;
	private Float preco;
	private Boolean disp;
	private int cap;
	private int temp;
	private LocalDate CheckIn;
	private LocalDate CheckOut;
	
	
	public LocalDate getCheckIn() {
		return CheckIn;
	}
	public void setCheckIn(LocalDate checkIn) {
		CheckIn = checkIn;
	}
	public LocalDate getCheckOut() {
		return CheckOut;
	}
	public void setCheckOut(LocalDate checkOut) {
		CheckOut = checkOut;
	}
	public int getIdQuarto() {
		return idQuarto;
	}
	public void setIdQuarto(int idQuarto) {
		this.idQuarto = idQuarto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	public Boolean getDisp() {
		return disp;
	}
	public void setDisp(Boolean disp) {
		this.disp = disp;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return idQuarto;
	}
	
	
	
	
	

}
