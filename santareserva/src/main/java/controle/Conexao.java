package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao { //Connection
	
	private static final String USERNAME = "root";
	private static final String SENHA = "gusta2023157c.c";
	private static final String BD = "mydb";
	private Connection con; // jdbc
	private static  Conexao instancia; // singleton
	
	private Conexao() {} // construtor privado
	
	/**
	 * Metodo singleton
	 * 
	 * @return
	 */
	
	public static Conexao getInstancia() {
		if(instancia == null) {
			instancia = new Conexao();
		}
		return instancia;
	}
	
	/**
	 * Método que faz conexao com o MySQL
	 * 
	 * @return
	 */
	
	public Connection conectar() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/"+ BD + "?serverTimezone=UTC", USERNAME, SENHA);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	/**
	 * Fecha a conexao com o MySQL
	 * 
	 * @return
	 */
	
	public boolean fecharConexao() {
		try {
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
