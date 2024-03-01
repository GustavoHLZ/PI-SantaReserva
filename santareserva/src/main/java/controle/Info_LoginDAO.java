package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Info_Login;

public class Info_LoginDAO implements IInfo_LoginDAO{
	
<<<<<<< HEAD
private static Info_LoginDAO instancia;
=======
	private static Info_LoginDAO instancia;
>>>>>>> ConexaoBDD2
	
	private Info_LoginDAO() {}
	
	public static Info_LoginDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new Info_LoginDAO();
		}
		return instancia;
	}

	public int InserirInfo_Login(Info_Login end) {
		
		String SQL = "INSERT INTO Info_Login (ID_usuario, Login, Senha) VALUES (?, ?, ?)";
		
		return 0;
	}
	
	public ArrayList<Info_Login> listarInfo_Login() {
		
		ArrayList<Info_Login> info_login = new ArrayList<Info_Login>();
		
		String SQL = "SELECT * FROM Info_Login";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Info_Login info = new Info_Login();
				
				Integer ID_usuario = rs.getInt("ID_usuario");
				String login = rs.getString("Login");
				String senha = rs.getString("Senha");
				
				info.setID_usuario(ID_usuario);
				info.setLogin(login);
				info.setSenha(senha);
				
				info_login.add(info);
				
			}
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return info_login;
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
