package controle;

import java.util.ArrayList;

import modelo.Avaliacoes;

public interface IAvaliacoesDAO {
	
	public int InserirAvaliacao(Avaliacoes end);
	
	public ArrayList<Avaliacoes> listarAvaliacoes();
	
	public boolean atualizarAvaliacoes(Avaliacoes end);
	
	public boolean removerAvaliacoes(Avaliacoes end);
	
	public Avaliacoes buscarAvaliacoes(Avaliacoes end);
	

}
