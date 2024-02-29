package controle;

import java.util.ArrayList;

import modelo.Servicos_Consumidos;

public class Servicos_ConsumidosDAO implements IServicos_ConsumidosDAO {
	
	private static Servicos_ConsumidosDAO instancia;
	
	private Servicos_ConsumidosDAO() {}
	
	public static Servicos_ConsumidosDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new Servicos_ConsumidosDAO();
		}
		return instancia;
	}

	public int InserirServicos_Consumidos(Servicos_Consumidos end) {
	
		return 0;
	}
	
	public ArrayList<Servicos_Consumidos> listarServicos_Consumidos() {
	
		return null;
	}
	
	public boolean atualizarServicos_Consumidos(Servicos_Consumidos end) {
	
		return false;
	}
	
	public boolean removerServicos_Consumidos(Servicos_Consumidos end) {
	
		return false;
	}

	public Servicos_Consumidos buscarServicos_Consumidos(Servicos_Consumidos end) {
	
		return null;
	}

}
