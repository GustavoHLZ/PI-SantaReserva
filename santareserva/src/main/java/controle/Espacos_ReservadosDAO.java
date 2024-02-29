package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		
		String SQL = "INSERT INTO Espacos_Reservados (FK_ID_Hospede, FK_ID_Espaco) VALUES (?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int chavePrimariaGerada = Integer.MIN_VALUE;
		
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, esr.getFK_ID_Hospede());
			ps.setInt(1, esr.getFK_ID_Espaco());
		
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
