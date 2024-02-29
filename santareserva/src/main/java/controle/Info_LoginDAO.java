package controle;

import java.util.ArrayList;

import modelo.Info_Login;

public class Info_LoginDAO implements IInfo_LoginDAO{
	
	private static Info_LoginDAO instancia;
	
	private Info_LoginDAO() {}
	
	public static Info_LoginDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new Info_LoginDAO();
		}
		return instancia;
	}

	public int InserirInfo_Login(Info_Login end) {
		
		return 0;
	}
	
	public ArrayList<Info_Login> listarInfo_Login() {
		
		return null;
	}
	
	public boolean atualizarInfo_Login(Info_Login end) {
		
		return false;
	}
	
	public boolean removerInfo_Login(Info_Login end) {
		
		return false;
	}
	
	public Info_Login buscarInfo_Login(Info_Login end) {
		
		return null;
	}

}
