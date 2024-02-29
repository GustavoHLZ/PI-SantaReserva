package controle;

import java.util.ArrayList;

import modelo.Avaliacoes;

public class AvaliacoesDAO implements IAvaliacoesDAO{

	
	private static AvaliacoesDAO instancia;
	
	private AvaliacoesDAO() {}
	
	public static AvaliacoesDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new AvaliacoesDAO();
		}
		return instancia;
	}
	
	public int InserirAvaliacao(Avaliacoes end) {
		
		return 0;
	}

	public ArrayList<Avaliacoes> listarAvaliacoes() {
		
		return null;
	}

	public boolean atualizarAvaliacoes(Avaliacoes end) {
		
		return false;
	}

	public boolean removerAvaliacoes(Avaliacoes end) {
		
		return false;
	}

	public Avaliacoes buscarAvaliacoes(Avaliacoes end) {
		
		return null;
		
	}

}
