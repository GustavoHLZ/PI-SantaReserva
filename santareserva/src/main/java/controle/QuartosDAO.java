package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Info_Login;
import modelo.Quartos;
import modelo.Quartos;

public class QuartosDAO implements IQuartosDAO {
	
	private static QuartosDAO instancia;
	
	private QuartosDAO() {}
	
	public static QuartosDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new QuartosDAO();
		}
		return instancia;
	}

	public int InserirQuartos(Quartos qua) {
		
		String SQL = "INSERT INTO Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) VALUES (?, ?, ?, ?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, qua.getID_Quarto());
			ps.setString(2, qua.getTipo_Quarto());
			ps.setFloat(3, qua.getPreco_Diaria());
			ps.setBoolean(4, qua.getDispo_Quarto());
			ps.setInt(5, qua.getCap_max());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
	
		return 0;
	}
	
	public ArrayList<Quartos> listarQuartos() {
		
		ArrayList<Quartos> quartos = new ArrayList<Quartos>();
		
		String SQL = "SELECT * FROM Quartos";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Quartos qua = new Quartos();
				
				Integer ID_quarto = rs.getInt("ID_Quarto");
				String tipo_quarto = rs.getString("Tipo_Quarto");
				Float preco_diaria = rs.getFloat("Preco_Diaria");
				Boolean Dispo_Quarto = rs.getBoolean("Dispo_Quarto");
				Integer Cap_max = rs.getInt("Cap_max");
				
				qua.setID_Quarto(ID_quarto);
				qua.setTipo_Quarto(tipo_quarto);
				qua.setPreco_Diaria(preco_diaria);
				qua.setDispo_Quarto(Dispo_Quarto);
				qua.setCap_max(Cap_max);
				
				quartos.add(qua);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
	
		return quartos;
	}
	
	public boolean atualizarQuartos(Quartos end) {
	
		return false;
	}
	
	public boolean removerQuartos(Quartos end) {
	
		return false;
	}
	
	public Quartos buscarQuartos(Quartos end) {
	
		return null;
	}

}
