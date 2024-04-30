package controle;

import java.util.ArrayList;

import modelo.Avaliacoes;

public interface IAvaliacoesDAO {
	
	public int InserirAvaliacao(Avaliacoes end);
	
	public ArrayList<Avaliacoes> listarAvaliacoes();
	
	public boolean atualizarAvaliacoes(String nome, Float avalia);
	
	public boolean removerAvaliacoes(int id);
	
	public Avaliacoes buscarAvaliacoes(Avaliacoes end);
	

}
