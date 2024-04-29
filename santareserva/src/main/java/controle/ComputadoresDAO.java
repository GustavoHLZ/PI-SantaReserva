package controle;
	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Computadores;
	
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
			ps.setString(6, comp.getCheckIn());
			ps.setString(7, comp.getCheckOut());
		
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
				String checkIn = rs.getString("checkIn");
				String checkOut = rs.getString("checkOut");
				
				comp.setIdPC(idPC);
				comp.setTemp(Temp_alugado);
				comp.setNum(Num_PC);
				comp.setPreco(Preco);
				comp.setDisp(Disp);
				comp.setCheckIn(checkIn);
				comp.setCheckOut(checkOut);
				
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
		
		String SQL = "UPDATE Computadores SET temp = ? Where idPC = ?";
		
		// Abre a conexão e cria a "ponte de conexao " com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			
			ps.setInt(1, comp.getTemp());
			
			retorno = ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			}
		
			return (retorno == 0 ? false : true);
	}
		
		
	public boolean removerComputadores(Computadores comp) {
		
		
		String SQL = "DELETE FROM Computadores WHERE idPC = ?";

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
	
		return (retorno == 0 ? false : true);
		
	
	}
		
		
	public Computadores buscarComputadores(Computadores end) {
		
		return null;
	}
	
}