package controle;

import java.util.ArrayList;

import modelo.SalaReunioes;

public interface ISalaReunioesDAO {
	
public int InserirSalaReunioes(SalaReunioes end);
	
	public ArrayList<SalaReunioes> listarSalaReunioes();
	
	public boolean atualizarSalaReunioes(SalaReunioes end);
	
	public boolean removerSalaReunioes(SalaReunioes end);
	
    public SalaReunioes buscarSalaReunioes(SalaReunioes end);

}
