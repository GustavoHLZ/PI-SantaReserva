package modelo;

import java.util.ArrayList;

import controle.IReserva;

public class Reserva {
	
	ArrayList <IReserva> lista = new ArrayList<IReserva>();
	

	public ArrayList<IReserva> getLista() {
		return lista;
	}

	
	
	public void adicionarReserva(IReserva sala) {
		this.lista.add(sala);
		
	}
	
	
	public void removerReserva(int posicao) {
		this.lista.remove(posicao);
		
	}



}
