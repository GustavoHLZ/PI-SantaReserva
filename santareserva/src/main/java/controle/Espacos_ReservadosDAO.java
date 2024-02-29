package controle;

import java.util.ArrayList;

import modelo.Espacos_Reservados;

public class Espacos_ReservadosDAO implements IEspacos_ReservadosDAO {
	
private static Espacos_ReservadosDAO instancia;
	
	private Espacos_ReservadosDAO() {}
	
	public static Espacos_ReservadosDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new Espacos_ReservadosDAO();
		}
		return instancia;
	}

	public int inserirEspacos_Reservados(Espacos_Reservados end) {
		
		return 0;
	}

	
	public ArrayList<Espacos_Reservados> listarEspacos_Reservados() {
		
		return null;
	}

	public boolean atualizarEspacos_Reservados(Espacos_Reservados end) {
		
		return false;
	}

	public boolean removerEspacos_Reservados(Espacos_Reservados end) {
		
		return false;
	}

	public Espacos_Reservados buscarEspacos_Reservados(Espacos_Reservados end) {
		
		return null;
	}

}
