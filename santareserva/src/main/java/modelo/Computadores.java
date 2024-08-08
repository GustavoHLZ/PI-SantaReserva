package modelo;

import java.time.LocalDate;

import controle.IReserva;

public class Computadores implements IReserva{

	private int idPC;
	private int num;
	private int temp;
	private Float preco;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Boolean Status;
	public Computadores() {
		Status=false;
	}
	
	public Boolean getStatus() {
		return Status;
	}


	public void setStatus(Boolean status) {
		Status = status;
	}
	
	public void efetuarPagamento() {
		setStatus(true);
	}

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
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return idPC
				;
	}
	
	

}
