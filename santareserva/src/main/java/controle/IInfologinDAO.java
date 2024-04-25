package controle;

import java.util.ArrayList;

import modelo.Infologin;

public interface IInfologinDAO {
	
	public int InserirInfologin(Infologin end);
	
	public ArrayList<Infologin> listarInfologin();
	
	public Infologin atualizarInfologin(String email, String senha, Integer id);
	
	public Infologin removerInfologin(Integer id);
	
    public Infologin buscarInfologin(String email, String senha);

}
