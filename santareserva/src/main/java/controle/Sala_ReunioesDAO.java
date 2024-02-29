package controle;

import java.util.ArrayList;

import modelo.Sala_Reunioes;

public class Sala_ReunioesDAO implements ISala_ReunioesDAO{
	
	private static Sala_ReunioesDAO instancia;
	
	private Sala_ReunioesDAO() {}
	
	public static Sala_ReunioesDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new Sala_ReunioesDAO();
		}
		return instancia;
	}

	public int InserirSala_Reunioes(Sala_Reunioes end) {
	
		return 0;
	}

	public ArrayList<Sala_Reunioes> listarSala_Reunioes() {
	
		return null;
	}
	
	public boolean atualizarSala_Reunioes(Sala_Reunioes end) {
	
		return false;
	}
	
	public boolean removerSala_Reunioes(Sala_Reunioes end) {
	
		return false;
	}
	
	public Sala_Reunioes buscarSala_Reunioes(Sala_Reunioes end) {
	
		return null;
	}

}
