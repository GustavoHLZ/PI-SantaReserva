package controle;

import java.util.ArrayList;

import modelo.Servicos;

public class ServicosDAO implements IServicosDAO {
	
	private static ServicosDAO instancia;
	
	private ServicosDAO() {}
	
	public static ServicosDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new ServicosDAO();
		}
		return instancia;
	}
	
	public int InserirServicos(Servicos end) {
			
		return 0;
	}
		
	public ArrayList<Servicos> listarServicos() {
			
		return null;
	}
		
	public boolean atualizarServicos(Servicos end) {
			
		return false;
	}
		
	public boolean removerServicos(Servicos end) {
			
		return false;
	}
	
	public Servicos buscarServicos(Servicos end) {
			
		return null;
	}

}