package controle;

import java.util.ArrayList;

import modelo.Espacos;

public interface IEspacosDAO {

	public int InserirEspacos(Espacos end);
	
	public ArrayList<Espacos> listarEspacos();
	
	public boolean atualizarEspacos(Espacos end);
	
	public boolean removerEspacos(Espacos end);
	
    public Espacos buscarEspacos(Espacos end);
	
}
