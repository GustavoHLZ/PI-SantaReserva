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

	public int InserirQuartos(Quartos end) {
		
		String SQL = "INSERT INTO Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) VALUES (?, ?, ?, ?, ?)";
	
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
				Boolean dispo_quarto = rs.getBoolean("Dispo_Quarto");
				Integer cap_max = rs.getInt("Cap_max");
				
				qua.setID_Quarto(ID_quarto);
				qua.setTipo_Quarto(tipo_quarto);
				qua.setPreco_Diaria(preco_diaria);
				qua.setID_Quarto(ID_quarto);
				qua.setID_Quarto(ID_quarto);
				
				quartos.add(qua);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
