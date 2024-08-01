package controle;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.SalaReunioes;

public interface ISalaReunioesDAO {
	
public int InserirSalaReunioes(SalaReunioes end);
	
	public ArrayList<SalaReunioes> listarSalaReunioes();
	
	public SalaReunioes atualizarSalaReunioes(LocalDate checkin, LocalDate checkout, Integer id);
	
	public boolean removerSalaReunioes(SalaReunioes end);
	
    public SalaReunioes buscarSalaReunioes(SalaReunioes end);

}
