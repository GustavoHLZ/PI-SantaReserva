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
		
		String SQL = "INSERT INTO Espacos (ocupante, checkIn, checkOut, fkidComputador, fkidSalaReuniao, fkidQuartos) VALUES (?, ?, ?, ?, ?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, esp.getOcupante());
			ps.setDate(2, esp.getCheckIn());
			ps.setDate(3, esp.getCheckOut());
			ps.setInt(4, esp.getFkidComputador());
			ps.setInt(5, esp.getFkidSalaReuniao());
			ps.setInt(6, esp.getFkidQuartos());
			
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

				Integer IDEspaco = rs.getInt("idEspaco");
				Integer OcupanteEspaco = rs.getInt("ocupante");
				Date CheckIn = rs.getDate("checkIn");
				Date CheckOut = rs.getDate("checkOut");

				esp.setIdEspaco(IDEspaco);
				esp.setOcupante(OcupanteEspaco);
				esp.setCheckIn(CheckIn);
				esp.setCheckOut(CheckOut);

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

		String SQL = "UPDATE Espacos SET ocupante = ?, checkIn = ?, checkOut = ? WHERE idEspaco = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, espc.getOcupante());
			ps.setDate(2, espc.getCheckIn());
			ps.setDate(3, espc.getCheckOut());
			
			
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		
		return (retorno == 0 ? false : true);
		
	}

	public boolean removerEspacos(Espacos end) {
		
String SQL = "DELETE FROM Espacos WHERE idEspaco = ?";
		
		// Abre a conexão e cria a "ponte de conexao " com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getIdEspaco());
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
