package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Avaliacoes;
import modelo.Hospedes;

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
	    String SQL = "INSERT INTO Avaliacoes (avaliacao, avaliador, comentario, fkIDHospede) VALUES (?, ?, ?, ?)";
	    
	    Conexao con = Conexao.getInstancia();
	    Connection conBD = con.conectar();
	    
	    int chavePrimariaGerada = Integer.MIN_VALUE;
	    
	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
	        
	        ps.setFloat(1, ava.getAvaliacao());
	        ps.setString(2, ava.getAvaliador());
	        ps.setString(3, ava.getComentario());
	        ps.setInt(4, ava.getFkIDHospede().getIdHospede()); // Supondo que getId() retorna o ID do hospede   
	        ps.executeUpdate();
	        
	        ResultSet rs = ps.getGeneratedKeys();
	        if (rs.next()) {
	            chavePrimariaGerada = rs.getInt(1);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }
	    
	    return chavePrimariaGerada;
	}
	
	public ArrayList<Avaliacoes> listarAvaliacoes() {
	
		ArrayList<Avaliacoes> avaliacoes = new ArrayList<Avaliacoes>();
		
		String SQL = "SELECT * FROM Avaliacoes inner join Hospedes on Avaliacoes.fkIdHospede=hospedes.IdHospede";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
	
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
			
				Avaliacoes ava = new Avaliacoes();
				Hospedes hosp=new Hospedes();
				
				hosp.setIdHospede(rs.getInt("IdHospede"));
				Integer ID_avaliacao = rs.getInt("idAvaliacao");
				Float Avaliacao = rs.getFloat("avaliacao");
				String comentario = rs.getString("comentario");
				String Avaliador = rs.getString("avaliador");
				
			
				ava.setIdAvaliacao(ID_avaliacao);
				ava.setAvaliacao(Avaliacao);
				ava.setAvaliador(Avaliador);
				ava.setComentario(comentario);
				ava.setFkIDHospede(hosp);
		
				
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
	
	public boolean atualizarAvaliacoes(int idAvaliacao, String nome, Float avalia, String comentario,  int idUsuario) {
	    String SQL = "UPDATE Avaliacoes SET avaliador = ?, avaliacao = ?, comentario = ? WHERE idAvaliacao = ? AND fkIDHospede = ?";
	    
	    // Abre a conexão e cria a "ponte de conexão" com o MySQL
	    Conexao con = Conexao.getInstancia();
	    Connection conBD = con.conectar();
	    
	    int retorno = 0;
	    
	    try {
	        PreparedStatement ps = conBD.prepareStatement(SQL);
	        ps.setString(1, nome);
	        ps.setFloat(2, avalia);
	        ps.setInt(4, idAvaliacao);
	        ps.setString(3, comentario);
	        ps.setInt(5, idUsuario); // Verifica se o ID do usuário é o mesmo associado à avaliação
	        
	        retorno = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.fecharConexao();
	    }
	    
		
		
	// Usando IF ternário // isso é if ternário (operador condicional ternário)
	return (retorno == 0 ? false : true);
	}
	
	public boolean removerAvaliacoes(int idAvaliacao, int idHospede) {
        String SQL = "DELETE FROM Avaliacoes WHERE idAvaliacao = ? AND fkIDHospede = ?";

        Conexao con = Conexao.getInstancia();
        Connection conBD = con.conectar();

        int rowsAffected = 0;

        try (PreparedStatement ps = conBD.prepareStatement(SQL)) {
            ps.setInt(1, idAvaliacao);
            ps.setInt(2, idHospede);
            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }

        return rowsAffected > 0;
    }
	
	public Avaliacoes buscarAvaliacoes(Avaliacoes end) {
	
	return null;
	
	}

}