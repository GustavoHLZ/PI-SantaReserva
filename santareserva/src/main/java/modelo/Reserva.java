package modelo;

import java.util.ArrayList;

import controle.IReserva;

public class Reserva {
	
	ArrayList <IReserva> lista = new ArrayList<IReserva>();
	Float precoQuartos;
	Float precoSalas;
	Float precoComputadores;
	Float total = 0.0f;
	private Float totalComputadores=0f;
	private Float totalQuartos=0f;
	private Float totalSalas=0f;
	

	public Float getTotal() {
		return total;
	}



	public void setTotal(Float total) {
		this.total = total;
	}



	public Float getPrecoQuartos() {
		return precoQuartos;
	}



	public void setPrecoQuartos(Float precoQuartos) {
		this.precoQuartos = precoQuartos;
	}



	public Float getPrecoSalas() {
		return precoSalas;
	}



	public void setPrecoSalas(Float precoSalas) {
		this.precoSalas = precoSalas;
	}



	public Float getPrecoComputadores() {
		return precoComputadores;
	}



	public void setPrecoComputadores(Float precoComputadores) {
		this.precoComputadores = precoComputadores;
	}
	



	public ArrayList<IReserva> getLista() {
		return lista;
	}

	
	
	public void adicionarReserva(IReserva sala) {
		this.lista.add(sala);
		total += sala.getPreco();
		
		if (sala instanceof Computadores) {
			totalComputadores +=sala.getPreco();;
		}
		else if(sala instanceof Quartos) {
			totalQuartos +=sala.getPreco();
		}
		else if(sala instanceof SalaReunioes) {
			totalSalas +=sala.getPreco();
		}
	}
	
	
	public Float getTotalComputadores() {
		return totalComputadores;
	}



	public void setTotalComputadores(Float totalComputadores) {
		this.totalComputadores = totalComputadores;
	}



	public Float getTotalQuartos() {
		return totalQuartos;
	}



	public void setTotalQuartos(Float totalQuartos) {
		this.totalQuartos = totalQuartos;
	}



	public Float getTotalSalas() {
		return totalSalas;
	}



	public void setTotalSalas(Float totalSalas) {
		this.totalSalas = totalSalas;
	}



	public void removerReserva(int posicao) {
		this.lista.remove(posicao);
		
	}



}
