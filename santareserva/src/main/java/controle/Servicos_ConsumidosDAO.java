package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Servicos_Consumidos;

public class Servicos_ConsumidosDAO implements IServicos_ConsumidosDAO {
	
	private static Servicos_ConsumidosDAO instancia;
	
	private Servicos_ConsumidosDAO() {}
	
	public static Servicos_ConsumidosDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new Servicos_ConsumidosDAO();
		}
		return instancia;
	}

	public int InserirServicos_Consumidos(Servicos_Consumidos consumido) {
		
		String SQL = "INSERT INTO Servicos_Consumidos (FK,ID_Hospede, FK_ID_Servico) VALUES (?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int chavePrimariaGerada = Integer.MIN_VALUE;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, consumido.getFK_ID_Hospede());
			ps.setInt(2, consumido.getFK_Servico());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				chavePrimariaGerada = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
	
		return chavePrimariaGerada;
	}
	
	public ArrayList<Servicos_Consumidos> listarServicos_Consumidos() {
		
		ArrayList<Servicos_Consumidos> servicos_consumidos = new ArrayList<Servicos_Consumidos>();
		
		String SQL = "SELECT * FROM Servicos_Consumidos";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Servicos_Consumidos consumido = new Servicos_Consumidos();
				
				Integer ID_servico_consumido = rs.getInt("ID_Servico_Consumidos");
				
				consumido.setID_Servico_Consumido(ID_servico_consumido);
				
				servicos_consumidos.add(consumido);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
	
		return servicos_consumidos;
	}
	
	public boolean atualizarServicos_Consumidos(Servicos_Consumidos end) {
	
		return false;
	}
	
	public boolean removerServicos_Consumidos(Servicos_Consumidos end) {
	
		return false;
	}

	public Servicos_Consumidos buscarServicos_Consumidos(Servicos_Consumidos end) {
	
		return null;
	}

}
