package controle;

import java.util.ArrayList;

import modelo.Servicos;

public interface IServicosDAO {
	
public int InserirServicos(Servicos end);
	
	public ArrayList<Servicos> listarServicos();
	
	public boolean atualizarServicos(Servicos end);
	
	public boolean removerServicos(Servicos end);
	
    public Servicos buscarServicos(Servicos end);

}
