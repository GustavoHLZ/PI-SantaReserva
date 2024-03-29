package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Avaliacoes;

public class AvaliacoesDAO implements IAvaliacoesDAO{


	private static AvaliacoesDAO instancia;
	
	private AvaliacoesDAO() {}
	
	public static AvaliacoesDAO getInstancia() {
	
		if(instancia == null) {
			instancia = new AvaliacoesDAO();
		}
		return instancia;
	}
	
	public int InserirAvaliacao(Avaliacoes ava) {
	
		String SQL = "INSERT INTO Avaliacoes (Avaliacao, FK_ID_Hospede) VALUES (?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int chavePrimariaGerada = Integer.MIN_VALUE;
		
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			
			
			ps.setFloat(1, ava.getAvaliacao());
			ps.setInt(2, ava.getFK_ID_Hospede());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				chavePrimariaGerada = rs.getInt(1);
			}
		
		} 	catch (SQLException e) {
		     e.printStackTrace();
		} 	finally {
		     con.fecharConexao();
		}
	
		return chavePrimariaGerada;
	}
	
	public ArrayList<Avaliacoes> listarAvaliacoes() {
	
		ArrayList<Avaliacoes> avaliacoes = new ArrayList<Avaliacoes>();
		
		String SQL = "SELECT * FROM Avaliacoes";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
	
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
			
				Avaliacoes ava = new Avaliacoes();
				
				Integer ID_avaliacao = rs.getInt("ID_avaliacao");
				Float Avaliacao = rs.getFloat("Avaliacao");
				String Avaliador = rs.getString("Avaliador");
				
				ava.setID_avaliacao(ID_avaliacao);
				ava.setAvaliacao(Avaliacao);
				ava.setAvaliador(Avaliador);
				
				avaliacoes.add(ava);
	
			}
	
		}	 catch (SQLException e) {
			  e.printStackTrace();
		}	 finally {
			  con.fecharConexao();
		}
	
		return avaliacoes;
	}
	
	/*
	 * Tem que possuir a chave primeira (ID, etc.)
	 */
	
	public boolean atualizarAvaliacoes(Avaliacoes end) {
		
		// Comando SQL a se executado
		String SQL = "UPDATE Avaliacoes SET avaliacao = ? Where avaliador = ?";
		
		// Abre a conexão e cria a "ponte de conexao " com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			
			ps.setFloat(1, end.getAvaliacao());
			ps.setString(2, end.getAvaliador());
			
			retorno = ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			}
		
		
	// Usando IF ternário // isso é if ternário (operador condicional ternário)
	return (retorno == 0 ? false : true);
	}
	
	public boolean removerAvaliacoes(Avaliacoes end) {
		
		String SQL = "DELETE FROM Avaliacoes WHERE ID_Avaliacao = ?";
		
		// Abre a conexão e cria a "ponte de conexao " com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getIdAvaliacao());
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			}
	
		return (retorno == 0 ? false : true);
	}
	
	public Avaliacoes buscarAvaliacoes(Avaliacoes end) {
	
	return null;
	
	}

}