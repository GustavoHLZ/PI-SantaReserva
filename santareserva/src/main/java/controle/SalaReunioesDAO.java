package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Infologin;
import modelo.SalaReunioes;

public class SalaReunioesDAO implements ISalaReunioesDAO{
	
	private static SalaReunioesDAO instancia;
	
	private SalaReunioesDAO() {}
	
	public static SalaReunioesDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new SalaReunioesDAO();
		}
		return instancia;
	}

	public int InserirSalaReunioes(SalaReunioes sala) {
		
		String SQL = "INSERT INTO SalaReunioes (idSala, disp, temp, cap, preco, checkIn, checkOut) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, sala.getIdSala());
			ps.setBoolean(2, sala.getDisp());
			ps.setInt(3, sala.getTemp());
			ps.setInt(4, sala.getCap());
			ps.setFloat(5, sala.getPreco());
			ps.setString(6, sala.getCheckIn());
			ps.setString(7, sala.getCheckOut());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
	
		return 0;
	}

	public ArrayList<SalaReunioes> listarSalaReunioes() {
		
		ArrayList<SalaReunioes> sala_reunioes = new ArrayList<SalaReunioes>();
		
		String SQL = "SELECT * FROM SalaReunioes";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				SalaReunioes sala = new SalaReunioes();
				
				Integer idSala = rs.getInt("idSala");
				Boolean disp = rs.getBoolean("disp");
				Integer temp = rs.getInt("temp");
				Integer cap = rs.getInt("cap");
				Float preco = rs.getFloat("preco");
				String checkIn = rs.getString("checkIn");
				String checkOut = rs.getString("checkOut");
				
				sala.setIdSala(idSala);
				sala.setDisp(disp);
				sala.setTemp(temp);
				sala.setCap(cap);
				sala.setPreco(preco);
				sala.setCheckIn(checkIn);
				sala.setCheckOut(checkOut);
				
				sala_reunioes.add(sala);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
	
		return sala_reunioes;
	}
	
	public boolean atualizarSalaReunioes(SalaReunioes sala) {
		
		String SQL = "UPDATE SalaReunioes SET disp, temp = ? WHERE idSala = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setBoolean(1, sala.getDisp());
			ps.setInt(2, sala.getTemp());
			
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		
		return (retorno == 0 ? false : true);
	}
	
	public boolean removerSalaReunioes(SalaReunioes end) {
		// Provalmente não vai ser usado este metodo pois não irá ser removido uma sala de reuniões do hotel
				String SQL = "DELETE FROM SalaReunioes WHERE idSala = ?";
				
				Conexao con = Conexao.getInstancia();
				Connection conBD = con.conectar();
				
				int retorno = 0;
				
				try {
					PreparedStatement ps = conBD.prepareStatement(SQL);
					ps.setInt(1, end.getIdSala());
					retorno = ps.executeUpdate();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					con.fecharConexao();
					}
			
				return (retorno == 0 ? false : true);
					}
	
	public SalaReunioes buscarSalaReunioes(SalaReunioes end) {
	
		return null;
	}

	@Override
	public int InserirSala_Reunioes(SalaReunioes end) {
		// TODO Auto-generated method stub
		return 0;
	}

}
