package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Servicos;
import modelo.Servicos_Consumidos;

public class ServicosDAO implements IServicosDAO {
	
	private static ServicosDAO instancia;
	
	private ServicosDAO() {}
	
	public static ServicosDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new ServicosDAO();
		}
		return instancia;
	}
	
	public int InserirServicos(Servicos end) {
		
		String SQL = "INSERT INTO Servicos (ID_servico, Nome_servico, Preco_servico, Pag_Efetuado) VALUES (?, ?, ?, ?)";
			
		return 0;
	}
		
	public ArrayList<Servicos> listarServicos() {
		
		ArrayList<Servicos> servicos = new ArrayList<Servicos>();
		
		String SQL = "SELECT * FROM Servicos";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Servicos servico = new Servicos();
				
				Integer ID_servico = rs.getInt("ID_servico");
				String nome_servico = rs.getString("Nome_servico");
				Float preco_servico = rs.getFloat("Preco_servico");
				Boolean pag_efetuado = rs.getBoolean("Pag_Efetuado");
				
				servico.setID_servico(ID_servico);
				servico.setNome_servico(nome_servico);
				servico.setPreco_servico(preco_servico);
				servico.setPag_Efetuado(pag_efetuado);
				
				servicos.add(servico);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return servicos;
	}
		
	public boolean atualizarServicos(Servicos end) {
			
		return false;
	}
		
	public boolean removerServicos(Servicos end) {
			
		return false;
	}
	
	public Servicos buscarServicos(Servicos end) {
			
		return null;
	}

}