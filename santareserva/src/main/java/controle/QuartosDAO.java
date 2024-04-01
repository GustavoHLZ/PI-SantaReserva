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
			
			ps.setInt(1, qua.getidQuarto());
			ps.setString(2, qua.gettipo());
			ps.setFloat(3, qua.getpreco());
			ps.setBoolean(4, qua.getdispo());
			ps.setInt(5, qua.getcap());
			
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
				
				Integer idQuarto = rs.getInt("idQuarto");
				String tipo = rs.getString("tipo");
				Float preco = rs.getFloat("preco");
				Boolean dispo = rs.getBoolean("dispo");
				Integer cap = rs.getInt("cap");
				
				qua.setidQuarto(idQuarto);
				qua.settipo(tipo);
				qua.setpreco(preco);
				qua.setdispo(dispo);
				qua.setcap(cap);
				
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
		
		//Comando SQL a ser executado
		String SQL = "UPDATE Quartos Set Dispo_Quarto = ? WHERE ID_Quarto = ?";
		
		// Abre a conexao e cria a "ponte de conexao" com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setBoolean(1, end.getdispo());
			ps.setInt(2, end.getidQuarto());
			
			retorno = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return (retorno == 0 ? false : true);
		
	}
	
	public boolean removerQuartos(Quartos end) {
		// Provalmente não vai ser usado este metodo pois não irá ser removido um quarto do hotel
		String SQL = "DELETE FROM Quartos WHERE ID_Quartos = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getidQuarto());
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			}
	
		return (retorno == 0 ? false : true);
		
	}
	
	public Quartos buscarQuartos(Quartos end) {
	
		return null;
	}

}
