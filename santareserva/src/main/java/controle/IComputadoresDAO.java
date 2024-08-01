package controle; 
 
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Computadores;

public interface IComputadoresDAO {

	public int inserirComputadores(Computadores end);
	
	public ArrayList<Computadores> listarComputadores();
	
	public Computadores atualizarComputadores(LocalDate checkin, LocalDate checkout, Integer id);
	
	public Computadores removerComputadores(Computadores end);
	
	public Computadores buscarComputadores(Computadores end);

}
