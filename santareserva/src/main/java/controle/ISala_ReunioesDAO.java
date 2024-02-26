package controle;

import java.util.ArrayList;

import modelo.Sala_Reunioes;

public interface ISala_ReunioesDAO {
	
public int InserirSala_Reunioes(Sala_Reunioes end);
	
	public ArrayList<Sala_Reunioes> listarSala_Reunioes();
	
	public boolean atualizarSala_Reunioes(Sala_Reunioes end);
	
	public boolean removerSala_Reunioes(Sala_Reunioes end);
	
    public Sala_Reunioes buscarSala_Reunioes(Sala_Reunioes end);

}
