package controle;

import java.util.ArrayList;

import modelo.Quartos;

public interface IQuartosDAO {
	
public int InserirQuartos(Quartos end);
	
	public ArrayList<Quartos> listarQuartos();
	
	public boolean atualizarQuartos(Quartos end);
	
	public boolean removerQuartos(Quartos end);
	
    public Quartos buscarQuartos(Quartos end);

}
