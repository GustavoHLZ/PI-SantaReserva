package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Info_Login;
import modelo.Sala_Reunioes;
import modelo.Sala_Reunioes;

public class Sala_ReunioesDAO implements ISala_ReunioesDAO{
	
	private static Sala_ReunioesDAO instancia;
	
	private Sala_ReunioesDAO() {}
	
	public static Sala_ReunioesDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new Sala_ReunioesDAO();
		}
		return instancia;
	}

	public int InserirSala_Reunioes(Sala_Reunioes sala) {
		
		String SQL = "INSERT INTO Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) VALUES (?, ?, ?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, sala.getID_Sala());
			ps.setBoolean(2, sala.getDisp_Sala());
			ps.setInt(3, sala.getTemp_Alugado());
			ps.setInt(4, sala.getCap_Max());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
	
		return 0;
	}

	public ArrayList<Sala_Reunioes> listarSala_Reunioes() {
		
		ArrayList<Sala_Reunioes> sala_reunioes = new ArrayList<Sala_Reunioes>();
		
		String SQL = "SELECT * FROM Sala_Reunioes";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Sala_Reunioes sala = new Sala_Reunioes();
				
				Integer ID_sala = rs.getInt("ID_Sala");
				Boolean disp_sala = rs.getBoolean("Disp_Sala");
				Integer temp_alugado = rs.getInt("Temp_Alugado");
				Integer cap_max = rs.getInt("Cap_Max");
				
				sala.setID_Sala(ID_sala);
				sala.setDisp_Sala(disp_sala);
				sala.setTemp_Alugado(temp_alugado);
				sala.setCap_Max(cap_max);
				
				sala_reunioes.add(sala);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
	
		return sala_reunioes;
	}
	
	public boolean atualizarSala_Reunioes(Sala_Reunioes sala) {
		
		String SQL = "UPDATE Sala_Reunioes SET Disp_Sala, Temp_Alugado = ? WHERE ID_Sala = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setBoolean(1, sala.getDisp_Sala());
			ps.setInt(2, sala.getTemp_Alugado());
			
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		
		return (retorno == 0 ? false : true);
	}
	
	public boolean removerSala_Reunioes(Sala_Reunioes end) {
		// Provalmente não vai ser usado este metodo pois não irá ser removido uma sala de reuniões do hotel
				String SQL = "DELETE FROM Quartos WHERE ID_Quartos = ?";
				
				Conexao con = Conexao.getInstancia();
				Connection conBD = con.conectar();
				
				int retorno = 0;
				
				try {
					PreparedStatement ps = conBD.prepareStatement(SQL);
					ps.setInt(1, end.getID_Sala());
					retorno = ps.executeUpdate();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					con.fecharConexao();
					}
			
				return (retorno == 0 ? false : true);
					}
	
	public Sala_Reunioes buscarSala_Reunioes(Sala_Reunioes end) {
	
		return null;
	}

}
