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
			
			ps.setInt(1, sala.getidSala());
			ps.setBoolean(2, sala.getdisp());
			ps.setInt(3, sala.gettemp());
			ps.setInt(4, sala.getcap());
			
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
				
				Integer idSala = rs.getInt("idSala");
				Boolean disp = rs.getBoolean("disp");
				Integer temp = rs.getInt("temp");
				Integer cap = rs.getInt("Cap_Max");
				
				sala.setidSala(idSala);
				sala.setdisp(disp);
				sala.settemp(temp);
				sala.setcap(cap);
				
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
			
			ps.setBoolean(1, sala.getdisp());
			ps.setInt(2, sala.gettemp());
			
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
					ps.setInt(1, end.getidSala());
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
