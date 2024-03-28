package controle;

import java.util.ArrayList;

import modelo.InfoLogin;

public interface IInfo_LoginDAO {
	
public int inserir(InfoLogin end);
	
	public ArrayList<InfoLogin> listarInfo_Login();
	
	public boolean atualizarInfo_Login(InfoLogin end);
	
	public boolean removerInfo_Login(InfoLogin end);
	
    public InfoLogin buscarInfo_Login(InfoLogin end);

}
