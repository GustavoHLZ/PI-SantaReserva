package modelo;

import java.time.LocalDate;

import controle.IReserva;

public class SalaReunioes implements IReserva{

	private int idSala;
	private Boolean disp;
	private int temp;
	private int cap;
	private Float preco;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Boolean Status;
	
	public SalaReunioes() {
		Status= false;
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
	public void setCheckIn(LocalDate checkinsala) {
		this.checkIn = checkinsala;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDate checkoutsala) {
		this.checkOut = checkoutsala;
	}
	public int getIdSala() {
		return idSala;
	}
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	public Boolean getDisp() {
		return disp;
	}
	public void setDisp(Boolean disp) {
		this.disp = disp;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return idSala;
	}
	


}
