package controle;

import java.util.ArrayList;

import modelo.Espacos_Reservados;

public interface IEspacos_ReservadosDAO {

	public int inserirEspacos_Reservados(Espacos_Reservados end);
	
	public ArrayList<Espacos_Reservados> listarEspacos_Reservados();
	
	public boolean atualizarEspacos_Reservados(Espacos_Reservados end);
	
	public boolean removerEspacos_Reservados(Espacos_Reservados end);
	
	public Espacos_Reservados buscarEspacos_Reservados(Espacos_Reservados end);

}
