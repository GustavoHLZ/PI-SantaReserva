package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.PreparedStatementWrapper;

import modelo.Infologin;

public class InfologinDAO implements IInfologinDAO{
	
private static InfologinDAO instancia;
	
	private InfologinDAO() {}
	
	public static InfologinDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new InfologinDAO();
		}
		return instancia;
	}

	public int InserirInfologin(Infologin info) {
		
		String SQL = "INSERT INTO Infologin (admin, email, senha) VALUES (?, ?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int ChavePrimariaGerada = Integer.MIN_VALUE;
				
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, info.getAdmin());
			ps.setString(2, info.getLogin());
			ps.setString(3, info.getSenha());
			
			ps.executeUpdate();
			
			// Pega as chaves criadas e coloca no id do usuario
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				ChavePrimariaGerada = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return ChavePrimariaGerada;
	}
	
	public ArrayList<Infologin> listarInfologin() {
		
		ArrayList<Infologin> info_login = new ArrayList<Infologin>();
		
		String SQL = "SELECT * FROM Infologin";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);	
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Infologin info = new Infologin();
				
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
	
	
	public boolean atualizarInfologin(Infologin info) {
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
	
	public boolean removerInfologin(Infologin end) {
		
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
	
	public Infologin buscarInfologin(Infologin info) {
		return info;
	
		
	
	}

}
