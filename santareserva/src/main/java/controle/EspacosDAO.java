package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Espacos;

public class EspacosDAO implements IEspacosDAO {

	private static EspacosDAO instancia;

	private EspacosDAO() {
	}

	public static EspacosDAO getInstancia() {

		if (instancia == null) {
			instancia = new EspacosDAO();
		}
		return instancia;
	}

	public int InserirEspacos(Espacos esp) {
		
		String SQL = "INSERT INTO Espacos (Ocupante_Espaco, Check_In, Check_Out, FK_ID_Quarto, FK_ID_Computador, FK_ID_Sala_Reuniao) VALUES (?, ?, ?, ?, ?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, esp.getOcupante_Espaco());
			ps.setDate(2, esp.getCheck_In());
			ps.setDate(3, esp.getCheck_Out());
			ps.setInt(4, esp.getFK_ID_Quarto());
			ps.setInt(5, esp.getFK_ID_Computador());
			ps.setInt(6, esp.getFK_ID_Sala_Reuniao());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				chavePrimariaGerada = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return chavePrimariaGerada;
	}

	public ArrayList<Espacos> listarEspacos() {
		
		ArrayList<Espacos> espacos = new ArrayList<Espacos>();

		String SQL = "SELECT * FROM Espacos";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Espacos esp = new Espacos();

				Integer ID_Espaco = rs.getInt("ID_Espaco");
				Integer Ocupante_Espaco = rs.getInt("Ocupante_Espaco");
				Date Check_In = rs.getDate("Check_In");
				Date Check_Out = rs.getDate("Check_Out");

				esp.setID_Espaco(ID_Espaco);
				esp.setOcupante_Espaco(Ocupante_Espaco);
				esp.setCheck_In(Check_In);
				esp.setCheck_Out(Check_Out);

				espacos.add(esp);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return espacos;
	}

	public boolean atualizarEspacos(Espacos espc) {

String SQL = "UPDATE Espacos SET Ocupante_Espaco = ?, Check_In = ?, Check_Out = ? WHERE ID_Espaco = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, espc.getOcupante_Espaco());
			ps.setDate(2, espc.getCheck_In());
			ps.setDate(3, espc.getCheck_Out());
			
			
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		
		return (retorno == 0 ? false : true);
		
	}

	public boolean removerEspacos(Espacos end) {
		
String SQL = "DELETE FROM Espacos WHERE ID_Espaco = ?";
		
		// Abre a conexão e cria a "ponte de conexao " com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getID_Espaco());
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			}
	
		return (retorno == 0 ? false : true);
	}

	public Espacos buscarEspacos(Espacos end) {

		return null;
	}

}
