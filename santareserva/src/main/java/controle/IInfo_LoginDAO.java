package controle;

import java.util.ArrayList;

import modelo.Info_Login;

public interface IInfo_LoginDAO {
	
public int InserirInfo_Login(Info_Login end);
	
	public ArrayList<Info_Login> listarInfo_Login();
	
	public boolean atualizarInfo_Login(Info_Login end);
	
	public boolean removerInfo_Login(Info_Login end);
	
    public Info_Login buscarInfo_Login(Info_Login end);

}
