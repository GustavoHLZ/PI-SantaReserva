package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
		
		String SQL = "INSERT INTO Quartos (idQuarto, tipo, preco, disp, cap, temp) VALUES (?, ?, ?, ?, ?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, qua.getIdQuarto());
			ps.setString(2, qua.getTipo());
			ps.setFloat(3, qua.getPreco());
			ps.setBoolean(4, qua.getDisp());
			ps.setInt(5, qua.getCap());
			ps.setInt(6, qua.getTemp());
			
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
				Boolean disp = rs.getBoolean("disp");
				Integer cap = rs.getInt("cap");
				Integer temp = rs.getInt("temp");
				
				qua.setIdQuarto(idQuarto);
				qua.setTipo(tipo);
				qua.setPreco(preco);
				qua.setDisp(disp);
				qua.setCap(cap);
				qua.setTemp(temp);
				
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
	    // Comando SQL a ser executado
	    String SQL = "UPDATE Quartos SET disp = ? WHERE idQuarto = ?";

	    // Abre a conexão e cria a "ponte de conexão" com o MySQL
	    Conexao con = Conexao.getInstancia();
	    Connection conBD = con.conectar();

	    int retorno = 0;

	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL);

	        ps.setBoolean(1, end.getDisp());
	        ps.setInt(2, end.getIdQuarto());

	        retorno = ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }

	    return (retorno != 0);
	}
	
	public boolean removerQuartos(Quartos end) {
		// Provalmente não vai ser usado este metodo pois não irá ser removido um quarto do hotel
		String SQL = "DELETE FROM Quartos WHERE ID_Quartos = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getIdQuarto());
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
