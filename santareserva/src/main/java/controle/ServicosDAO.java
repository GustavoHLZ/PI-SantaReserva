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
			
			ps.setInt(1, servico.getidServico());
			ps.setString(2,servico.getnomeServico());
			ps.setFloat(3,servico.getprecoServico());
			ps.setBoolean(4, servico.getpagEfetuado());
			
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
				
				Integer idServico = rs.getInt("idServico");
				String nomeServico = rs.getString("nomeServico");
				Float precoServico	= rs.getFloat("precoServico");
				Boolean pagEfetuado = rs.getBoolean("pagEfetuado");
				
				servico.setidServico(idServico);
				servico.setnomeServico(nomeServico);
				servico.setPreco_servico(precoServico);
				servico.setpagEfetuado(pagEfetuado);
				
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
			
			ps.setBoolean(1,end.getpagEfetuado());
			ps.setInt(2, end.getidServico());
			
			retorno = ps.executeUpdate();
			
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return (retorno == 0 ? false : true);
		
		
		
	}
	
	public boolean removerServicos(Servicos end ) {
		
String SQL = "DELETE FROM Servicos WHERE ID_servico = ?";
		
		// Abre a conexão e cria a "ponte de conexao " com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getidServico());
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			}
	
		return (retorno == 0 ? false : true);
	}
	
	public Servicos buscarServicos(Servicos end) {
		
		return null;
	}
	
}
