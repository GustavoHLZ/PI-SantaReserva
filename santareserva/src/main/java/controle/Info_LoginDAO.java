package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.PreparedStatementWrapper;

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

	public int InserirInfo_Login(Info_Login info) {
		
		String SQL = "INSERT INTO Infologin (login, senha) VALUES (?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int ChavePrimariaGerada = Integer.MIN_VALUE;
				
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, info.getLogin());
			ps.setString(2, info.getSenha());
			
			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				ChavePrimariaGerada = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return ChavePrimariaGerada;
	}
	
	public ArrayList<Info_Login> listarInfo_Login() {
		
		ArrayList<Info_Login> info_login = new ArrayList<Info_Login>();
		
		String SQL = "SELECT * FROM Infologin";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);	
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Info_Login info = new Info_Login();
				
				Integer ID_usuario = rs.getInt("idUsuario");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				
				info.setIdUsuario(ID_usuario);
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
	
	
	public boolean atualizarInfo_Login(Info_Login info) {
		String SQL = "UPDATE Infologin SET login = ?, senha = ?, WHERE idUsuario = ?";
		
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
	
	public boolean removerInfo_Login(Info_Login end) {
		
		String SQL = "DELETE FROM Infologin WHERE idUsuario = ?";
		
		// Abre a conexão e cria a "ponte de conexao " com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getIdUsuario());
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			}
	
		return (retorno == 0 ? false : true);
	}
	
	public Info_Login buscarInfo_Login(Info_Login info) {
		return info;
	
		
	
	}

}
