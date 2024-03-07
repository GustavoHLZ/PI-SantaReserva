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
	
		String SQL = "INSERT INTO Computadores (ID_PC, Num_PC, Temp_alugado) VALUES (?, ?, ?)";
	
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
	
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);
	
	
			ps.setInt(1, comp.getID_PC());
			ps.setInt(2, comp.getNum_PC());
			ps.setInt(3, comp.getTemp_alugado());
		
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
				
				Integer ID_PC = rs.getInt("ID_PC");
				Integer Temp_alugado = rs.getInt("Temp_alugado");
				Integer Num_PC = rs.getInt("Num_PC");
				
				comp.setID_PC(ID_PC);
				comp.setTemp_alugado(Temp_alugado);
				comp.setNum_PC(Num_PC);
				
				computadores.add(comp);
		
			}
		
		} 	catch (SQLException e) {
			 e.printStackTrace();
		}	finally {
			 con.fecharConexao();
		}
		
		return computadores;
	}
		
		
	public boolean atualizarComputadores(Computadores end) {
		
		String SQL = "UPDATE Computadores SET Temp_alugado = ? Where Num_PC = ?";
		
		// Abre a conexão e cria a "ponte de conexao " com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			
			ps.setInt(1, end.getTemp_alugado());
			ps.setInt(2, end.getNum_PC());
			
			retorno = ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			}
		
			return (retorno == 0 ? false : true);
	}
		
		
	public boolean removerComputadores(Computadores end) {
		
		return false;
	}
		
		
	public Computadores buscarComputadores(Computadores end) {
		
		return null;
	}
	
}