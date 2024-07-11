package controle;

import java.util.ArrayList;

import modelo.Avaliacoes;
import modelo.Hospedes;

public interface IAvaliacoesDAO {
	
	public int InserirAvaliacao(Avaliacoes end);
	
	public ArrayList<Avaliacoes> listarAvaliacoes();
	
	public boolean atualizarAvaliacoes(int idAvaliacao, String nome, Float avalia, String comentario,  int idUsuario);
	
	public boolean removerAvaliacoes(int idAvaliacao, int idHospede);
	
	public Avaliacoes buscarAvaliacoes(Avaliacoes end);
	

}
