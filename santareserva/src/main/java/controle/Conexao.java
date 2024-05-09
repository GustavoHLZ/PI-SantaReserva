package controle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao { // Connection

	private static String DATABASE;
	private static String USER;
	private static String PSW;
	private Connection con; // jdbc
	private static Conexao instancia; // singleton

	private Conexao() {
	} // construtor privado

	/**
	 * Metodo singleton
	 * 
	 * @return
	 */

	public static Conexao getInstancia() {
		if (instancia == null) {
			instancia = new Conexao();
			lerArquivoBD();
		}
		return instancia;
	}

	public static void lerArquivoBD() {
		FileReader arquivo;
		try {
			arquivo = new FileReader("credenciais.txt");

			if (arquivo != null) {
				
				BufferedReader conteudo = new BufferedReader(arquivo);
				
				DATABASE = conteudo.readLine();
				USER = conteudo.readLine();
				PSW = conteudo.readLine();

				conteudo.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que faz conexao com o MySQL
	 * 
	 * @return
	 */

	public Connection conectar() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE + "?serverTimezone=UTC", PSW, USER);
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


