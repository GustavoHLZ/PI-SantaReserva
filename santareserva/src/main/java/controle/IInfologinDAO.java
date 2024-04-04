package controle;

import java.util.ArrayList;

import modelo.Infologin;

public interface IInfologinDAO {
	
public int InserirInfologin(Infologin end);
	
	public ArrayList<Infologin> listarInfologin();
	
	public boolean atualizarInfologin(Infologin end);
	
	public boolean removerInfologin(Infologin end);
	
    public Infologin buscarInfologin(Infologin end);

}
