package controle;

import java.util.ArrayList;

import modelo.Quartos;

public class QuartosDAO implements IQuartosDAO {
	
	private static QuartosDAO instancia;
	
	private QuartosDAO() {}
	
	public static QuartosDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new QuartosDAO();
		}
		return instancia;
	}

	public int InserirQuartos(Quartos end) {
	
		return 0;
	}
	
	public ArrayList<Quartos> listarQuartos() {
	
		return null;
	}
	
	public boolean atualizarQuartos(Quartos end) {
	
		return false;
	}
	
	public boolean removerQuartos(Quartos end) {
	
		return false;
	}
	
	public Quartos buscarQuartos(Quartos end) {
	
		return null;
	}

}
