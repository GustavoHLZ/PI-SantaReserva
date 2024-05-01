package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
		ps.setDate(6, java.sql.Date.valueOf(sala.getCheckIn()));
		ps.setDate(7, java.sql.Date.valueOf(sala.getCheckOut()));

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
		java.sql.Date sqlcheckIn = rs.getDate("checkIn");
		LocalDate checkinsala = sqlcheckIn == null ? null : sqlcheckIn.toLocalDate();
		java.sql.Date sqlcheckOut = rs.getDate("checkOut");
		LocalDate checkoutsala = sqlcheckOut == null ? null : sqlcheckOut.toLocalDate();

		sala.setIdSala(idSala);
		sala.setDisp(disp);
		sala.setTemp(temp);
		sala.setCap(cap);
		sala.setPreco(preco);
		sala.setCheckIn(checkinsala);
		sala.setCheckOut(checkoutsala);

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

}
