package controle;
	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Computadores;
import modelo.Infologin;
	
public class ComputadoresDAO implements IComputadoresDAO {
	
	private static ComputadoresDAO instancia;
	
	private ComputadoresDAO() {}
	
	public static ComputadoresDAO getInstancia() {
	
		if(instancia == null) {
		instancia = new ComputadoresDAO();
		
		}
		return instancia;
	}
	
	public int inserirComputadores(Computadores comp) {
	
		String SQL = "INSERT INTO Computadores (idPC, num, temp, preco, disp, checkIn, checkOut) VALUES (?, ?, ?, ?, ?, ? ,?)";
	
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
	
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);
	
	
			ps.setInt(1, comp.getIdPC());
			ps.setInt(2, comp.getNum());
			ps.setInt(3, comp.getTemp());
			ps.setFloat(4, comp.getPreco());
			ps.setBoolean(5, comp.getDisp());
			ps.setDate(6, java.sql.Date.valueOf(comp.getCheckIn()));
			ps.setDate(7, java.sql.Date.valueOf(comp.getCheckOut()));
		
			ps.executeUpdate();
		
			} catch (SQLException e) {
			e.printStackTrace();
			} finally {
			con.fecharConexao();
		}
	return 0;
	}
	
	public ArrayList<Computadores> listarComputadores() {
	
		ArrayList<Computadores> computadores = new ArrayList<Computadores>();
	
		String SQL = "SELECT * FROM Computadores";
	
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				Computadores comp = new Computadores();
				
				Integer idPC = rs.getInt("idPC");
				Integer Temp_alugado = rs.getInt("temp");
				Integer Num_PC = rs.getInt("num");
				Float Preco = rs.getFloat("preco");
				Boolean Disp = rs.getBoolean("disp");
				
				java.sql.Date sqlcheckIn = rs.getDate("checkIn"); 
				LocalDate checkincomp = sqlcheckIn == null ? null : sqlcheckIn.toLocalDate(); 
				java.sql.Date sqlcheckOut = rs.getDate("checkOut"); 
				LocalDate checkoutcomp = sqlcheckOut == null ? null : sqlcheckOut.toLocalDate(); 
				
				comp.setIdPC(idPC);
				comp.setTemp(Temp_alugado);
				comp.setNum(Num_PC);
				comp.setPreco(Preco);
				comp.setDisp(Disp);
				comp.setCheckIn(checkincomp);
				comp.setCheckOut(checkoutcomp);
				
				computadores.add(comp);
		
			}
		
		} 	catch (SQLException e) {
			 e.printStackTrace();
		}	finally {
			 con.fecharConexao();
		}
		
		return computadores;
	}
		
		
	public boolean atualizarComputadores(Computadores comp) {
		
	    String SQL = "UPDATE Computadores SET num = ?, temp = ?, preco = ?, disp = ? WHERE idPC = ?";
	    
	    boolean atualizacaoRealizada = false;

	    Conexao con = Conexao.getInstancia();
	    Connection conBD = con.conectar();

	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL);
	        ps.setInt(1, comp.getNum());
	        ps.setInt(2, comp.getTemp());
	        ps.setFloat(3, comp.getPreco());
	        ps.setBoolean(4, comp.getDisp());
	        ps.setInt(5, comp.getIdPC());

	        int linhasAfetadas = ps.executeUpdate();

	        if (linhasAfetadas > 0) {
	            atualizacaoRealizada = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }

	    return atualizacaoRealizada;
	}
	    
	public Computadores removerComputadores(Computadores comp) {
		
		
		String SQL = "DELETE FROM Computadores WHERE idPC = ?";
		
		Computadores computador = null;

		// Abre a conexão e cria a "ponte de conexao " com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, comp.getIdPC());
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			}
	
		return computador;
		
	
	}
		
		
	public Computadores buscarComputadores(Computadores end) {
		
		return null;
	}
	
	public boolean removerComputadoresPorId(int idPC) {
	    String SQL = "DELETE FROM Computadores WHERE idPC = ?";
	    boolean remocaoRealizada = false;

	    Conexao con = Conexao.getInstancia();
	    Connection conBD = con.conectar();

	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL);
	        ps.setInt(1, idPC);
	        int linhasAfetadas = ps.executeUpdate();

	        if (linhasAfetadas > 0) {
	            remocaoRealizada = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }

	    return remocaoRealizada;
	}

	public Computadores buscarComputadoresPorId(int idPC) {
	    String SQL = "SELECT * FROM Computadores WHERE idPC = ?";
	    Computadores comp = null;
	
	    Conexao con = Conexao.getInstancia();
	    Connection conBD = con.conectar();
	
	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL);
	        ps.setInt(1, idPC);
	        ResultSet rs = ps.executeQuery();
	
	        if (rs.next()) {
	            comp = new Computadores();
	
	            comp.setIdPC(rs.getInt("idPC"));
	            comp.setNum(rs.getInt("num"));
	            comp.setTemp(rs.getInt("temp"));
	            comp.setPreco(rs.getFloat("preco"));
	            comp.setDisp(rs.getBoolean("disp"));
	            // Defina outras propriedades, se necessário
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }
	
	    return comp;
	}
}