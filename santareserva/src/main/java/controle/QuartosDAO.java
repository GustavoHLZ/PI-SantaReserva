package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Computadores;
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
		
		String SQL = "INSERT INTO Quartos (idQuarto, tipo, preco, disp, cap, temp, checkIn,checkOut) VALUES (?, ?, ?, ?, ?, ?,?,?)";
		
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
			ps.setDate(7, java.sql.Date.valueOf(qua.getCheckIn()));
			ps.setDate(8, java.sql.Date.valueOf(qua.getCheckOut()));
			
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
				java.sql.Date sqlcheckIn = rs.getDate("checkIn");
				LocalDate checkinquarto = sqlcheckIn == null ? null : sqlcheckIn.toLocalDate();
				java.sql.Date sqlcheckOut = rs.getDate("checkOut");
				LocalDate checkoutquarto = sqlcheckOut == null ? null : sqlcheckOut.toLocalDate();
				
				qua.setIdQuarto(idQuarto);
				qua.setTipo(tipo);
				qua.setPreco(preco);
				qua.setDisp(disp);
				qua.setCap(cap);
				qua.setTemp(temp);
				qua.setCheckIn(checkinquarto);
				qua.setCheckOut(checkoutquarto);
				
				quartos.add(qua);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
	
		return quartos;
	}
	
	public Quartos atualizarQuartos(LocalDate checkin, LocalDate checkout, boolean disp, Integer idquarto) {
	    // Comando SQL a ser executado
	    String SQL = "UPDATE Quartos SET checkIn = ?, checkOut = ?, disp = ? WHERE idQuarto = ?";

	    Quartos quarto = null;
	    
	    // Abre a conexão e cria a "ponte de conexão" com o MySQL
	    Conexao con = Conexao.getInstancia();
	    Connection conBD = con.conectar();

	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL);

	        java.sql.Date sqlcheckIn = Date.valueOf(checkin);
	        ps.setDate(1, sqlcheckIn);
	        java.sql.Date sqlcheckOut = Date.valueOf(checkout);
	        ps.setDate(2, sqlcheckOut);
	        ps.setBoolean(3, disp);
	        ps.setInt(4, idquarto);

	        int linhasAfetadas = ps.executeUpdate();
	        
	        if (linhasAfetadas > 0) {
	            quarto = new Quartos();
	            quarto.setIdQuarto(idquarto);
	            quarto.setCheckIn(checkin);
	            quarto.setCheckOut(checkout);
	            quarto.setDisp(disp);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }

	    return quarto;
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
	
	@Override
	public Quartos atualizarQuartos(LocalDate checkin, LocalDate checkout, Integer idquarto) {
		// TODO Auto-generated method stub
		return null;
	}


}
