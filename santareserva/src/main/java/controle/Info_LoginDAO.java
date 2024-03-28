package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.PreparedStatementWrapper;

import modelo.InfoLogin;

public class Info_LoginDAO implements IInfo_LoginDAO{
	
private static Info_LoginDAO instancia;
	
	private Info_LoginDAO() {}
	
	public static Info_LoginDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new Info_LoginDAO();
		}
		return instancia;
	}

	public int inserir(InfoLogin info) {
		
		String SQL = "INSERT INTO Info_Login (Login, Senha) VALUES (?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int chavePrimariaGerada = Integer.MIN_VALUE;
				
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, info.getLogin());
			ps.setString(2, info.getSenha());
			
			int result = ps.executeUpdate();
			if(result == 0) {
				throw new SQLException("Não foi possível executar o INSERT");
			} else {
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					chavePrimariaGerada = rs.getInt(1);
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return chavePrimariaGerada;
	}
	
	public ArrayList<InfoLogin> listarInfo_Login() {
		
		ArrayList<InfoLogin> info_login = new ArrayList<InfoLogin>();
		
		String SQL = "SELECT * FROM Info_Login";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);	
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				InfoLogin info = new InfoLogin();
				
				Integer ID_usuario = rs.getInt("ID_usuario");
				String login = rs.getString("Login");
				String senha = rs.getString("Senha");
				
				info.setID_usuario(ID_usuario);
				info.setLogin(login);
				info.setSenha(senha);
				
				info_login.add(info);
				
			}
				
			} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return info_login;
	}
	
	
	public boolean atualizarInfo_Login(InfoLogin info) {
		String SQL = "UPDATE Info_Login SET Login = ?, Senha = ?, WHERE ID_usuario = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setString(1, info.getLogin());
			ps.setString(2, info.getSenha());
			
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		
		return (retorno == 0 ? false : true);
	}
	
	public boolean removerInfo_Login(InfoLogin info) {
		
		return false;
	}
	
	public InfoLogin buscarInfo_Login(InfoLogin info) {
		return info;
	
		
	
	}

}
