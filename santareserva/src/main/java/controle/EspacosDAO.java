package controle;

import java.util.ArrayList;

import modelo.Espacos;

public class EspacosDAO implements IEspacosDAO {
	
private static EspacosDAO instancia;
	
	private EspacosDAO() {}
	
	public static EspacosDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new EspacosDAO();
		}
		return instancia;
	}

	public int InserirEspacos(Espacos end) {
		
		return 0;
	}

	public ArrayList<Espacos> listarEspacos() {
		
		return null;
	}

	public boolean atualizarEspacos(Espacos end) {

		return false;
	}

	public boolean removerEspacos(Espacos end) {

		return false;
	}

	public Espacos buscarEspacos(Espacos end) {

		return null;
	}

}
