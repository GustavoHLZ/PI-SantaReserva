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

	public int InserirSala_Reunioes(Sala_Reunioes end) {
		
		String SQL = "INSERT INTO Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) VALUES (?, ?, ?, ?)";
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
	
		return sala_reunioes;
	}
	
	public boolean atualizarSala_Reunioes(Sala_Reunioes end) {
	
		return false;
	}
	
	public boolean removerSala_Reunioes(Sala_Reunioes end) {
	
		return false;
	}
	
	public Sala_Reunioes buscarSala_Reunioes(Sala_Reunioes end) {
	
		return null;
	}

}
