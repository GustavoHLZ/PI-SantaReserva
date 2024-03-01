package controle;

import java.util.ArrayList;

import modelo.Computadores;

public class ComputadoresDAO implements IComputadoresDAO {
	
private static ComputadoresDAO instancia;
	
	private ComputadoresDAO() {}
	
	public static ComputadoresDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new ComputadoresDAO();
		}
		return instancia;
	}

	public int inserirComputadores(Computadores end) {

		return 0;
	}

	public ArrayList<Computadores> listarComputadores() {

		return null;
	}


	public boolean atualizarComputadores(Computadores end) {
		
		return false;
	}


	public boolean removerComputadores(Computadores end) {

		return false;
	}


	public Computadores buscarComputadores(Computadores end) {

		return null;
	}

}
