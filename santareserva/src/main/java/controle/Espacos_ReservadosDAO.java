package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Espacos_Reservados;

public class Espacos_ReservadosDAO implements IEspacos_ReservadosDAO {
	
private static Espacos_ReservadosDAO instancia;
	
	private Espacos_ReservadosDAO() {}
	
	public static Espacos_ReservadosDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new Espacos_ReservadosDAO();
		}
		return instancia;
	}

	public int inserirEspacos_Reservados(Espacos_Reservados esr) {
		String SQL = "INSERT INTO Espacos_Reservados (ID_Espacos_Reservados) VALUES (?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);
			
			
			ps.setInt(1, esr.getID_Espacos_Reservados());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return 0;
	}

	
	public ArrayList<Espacos_Reservados> listarEspacos_Reservados() {
		ArrayList<Espacos_Reservados> espaR = new ArrayList<Espacos_Reservados>();
		
		String SQL = "SELECT * FROM Espacos_Reservados";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Espacos_Reservados esr = new Espacos_Reservados();
				
				Integer ID_Espacos_Reservados = rs.getInt("ID_Espacos_Reservados");
				
				esr.setID_Espacos_Reservados(ID_Espacos_Reservados);
				
				espaR.add(esr);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			con.fecharConexao();
		}
	
		return espaR;
	}

	public boolean atualizarEspacos_Reservados(Espacos_Reservados end) {
		
		return false;
	}

	public boolean removerEspacos_Reservados(Espacos_Reservados end) {
		
		return false;
	}

	public Espacos_Reservados buscarEspacos_Reservados(Espacos_Reservados end) {
		
		return null;
	}

}
