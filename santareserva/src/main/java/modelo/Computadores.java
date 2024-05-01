package modelo;

import java.time.LocalDate;

public class Computadores {

	private int idPC;
	private int num;
	private int temp;
	private float preco;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDate checkincomp) {
		this.checkIn = checkincomp;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDate checkoutcomp) {
		this.checkOut = checkoutcomp;
	}
	private Boolean disp;
	
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public Boolean getDisp() {
		return disp;
	}
	public void setDisp(Boolean disp) {
		this.disp = disp;
	}
	public int getIdPC() {
		return idPC;
	}
	public void setIdPC(int idPC) {
		this.idPC = idPC;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	
	

}
