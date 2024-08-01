package controle;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Quartos;

public interface IQuartosDAO {
	
	public int InserirQuartos(Quartos end);
	
	public ArrayList<Quartos> listarQuartos();
	
	public Quartos atualizarQuartos(LocalDate checkin, LocalDate checkout, boolean disp, Integer idquarto);
	
	public boolean removerQuartos(Quartos end);
	
    public Quartos buscarQuartos(Quartos end);

}
