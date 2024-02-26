package controle;

import java.util.ArrayList;

import modelo.Servicos_Consumidos;

public interface IServicos_ConsumidosDAO {
	
public int InserirServicos_Consumidos(Servicos_Consumidos end);
	
	public ArrayList<Servicos_Consumidos> listarServicos_Consumidos();
	
	public boolean atualizarServicos_Consumidos(Servicos_Consumidos end);
	
	public boolean removerServicos_Consumidos(Servicos_Consumidos end);
	
    public Servicos_Consumidos buscarServicos_Consumidos(Servicos_Consumidos end);

}
