package controle;

import java.util.ArrayList;

import modelo.Avaliacoes;

public interface IAvaliacoesDAO {
	
	public int InserirAvaliacao(Avaliacoes end);
	
	public ArrayList<Avaliacoes> listarAvaliacoes();
	
	public boolean atualizarAvaliacoes(int idAvaliacao, String nome, Float avalia, String comentario,  int idUsuario);
	
	public boolean removerAvaliacoes(int idAvaliacao);
	
	public Avaliacoes buscarAvaliacoes(Avaliacoes end);
	

}
