package controle; 
 
import java.util.ArrayList;

import modelo.Computadores;

public interface IComputadoresDAO {

	public int inserirComputadores(Computadores end);
	
	public ArrayList<Computadores> listarComputadores();
	
	public boolean atualizarComputadores(Computadores end);
	
	public Computadores removerComputadores(Computadores end);
	
	public Computadores buscarComputadores(Computadores end);

}
