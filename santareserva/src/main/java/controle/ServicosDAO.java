package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Servicos;

public class ServicosDAO implements IServicosDAO{

	private static ServicosDAO instancia;
	
	private ServicosDAO () {}
	
	public static ServicosDAO getInstancia () {
		if(instancia == null ) {
			instancia = new ServicosDAO();
		}
		return instancia;
	}
	
	public int InserirServicos(Servicos servico) {
		String SQL = "INSERT INTO Servicos (ID_servico, Nome_servico, Preco_servico, PAG_Efetuado) VALUES (?,?,?,?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, servico.getID_servico());
			ps.setString(2,servico.getNome_servico());
			ps.setFloat(3,servico.getPreco_servico());
			ps.setBoolean(4, servico.getPag_Efetuado());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return 0;
		
	}
	
	public ArrayList<Servicos> listarServicos() {
		
		ArrayList<Servicos> servicos = new ArrayList<Servicos>();
		
		String SQL = "SELECT * FROM Servicos";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Servicos servico = new Servicos();
				
				Integer ID_servico = rs.getInt("ID_servico");
				String nome_servico = rs.getString("Nome_servico");
				Float preco_servico	= rs.getFloat("Preco_servico");
				Boolean pag_efetuado = rs.getBoolean("Pag_Efetuado");
				
				servico.setID_servico(ID_servico);
				servico.setNome_servico(nome_servico);
				servico.setPreco_servico(preco_servico);
				servico.setPag_Efetuado(pag_efetuado);
				
				servicos.add(servico);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return servicos;
		
	}
	
	public boolean atualizarServicos(Servicos end) {
			
		String SQL = "UPDATE Servicos SET Pag_efetuado = ? WHERE ID_Servico = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setBoolean(1,end.getPag_Efetuado());
			ps.setInt(2, end.getID_servico());
			
			retorno = ps.executeUpdate();
			
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return (retorno == 0 ? false : true);
		
		
		
	}
	
	public boolean removerServicos(Servicos end ) {
		return false;
	}
	
	public Servicos buscarServicos(Servicos end) {
		
		return null;
	}
	
}
