package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Hospedes;

public class HospedesDAO implements IHospedesDAO {
	

private static HospedesDAO instancia;
	
	private HospedesDAO() {}
	
	public static HospedesDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new HospedesDAO();
		}
		return instancia;
	}
	
	public int InserirHospedes(Hospedes hosp) {
		
		String SQL = "INSERT INTO Hospedes (Nome_Hospede, sobrenome_hospede, nascimento_hospede, telefone_hospede, email_hospede, FK_ID_usuario) VALUES (?, ?, ?, ?, ?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int chavePrimariaGerada = Integer.MIN_VALUE;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, hosp.getNome_Hospede());
			ps.setString(2, hosp.getSobrenome_hospede());
			ps.setDate(3, hosp.getNascimento_hospede());
			ps.setInt(4, hosp.getTelefone_hospede());
			ps.setString(5, hosp.getEmail_hospede());
			ps.setInt(6, hosp.getFK_ID_usuario());
			
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
	
	public ArrayList<Hospedes> listarHospedes() {
		
		ArrayList<Hospedes> hospedes = new ArrayList<Hospedes>();
		
		String SQL = "SELECT * FROM Hospedes";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Hospedes hosp = new Hospedes();
				
				Integer ID_Hospede = rs.getInt("ID_Hospede");
				String Nome_Hospede = rs.getString("Nome_Hospede");
				String sobrenome_hospede = rs.getString("sobrenome_hospede");
				Date nascimento_hospede = rs.getDate("nascimento_hospede");
				Integer telefone_hospede = rs.getInt("telefone_hospede");
				String email_hospede = rs.getString("email_hospede");
				
				hosp.setID_Hospede(ID_Hospede);
				hosp.setNome_Hospede(Nome_Hospede);
				hosp.setSobrenome_hospede(sobrenome_hospede);
				hosp.setNascimento_hospede(nascimento_hospede);
				hosp.setTelefone_hospede(telefone_hospede);
				hosp.setEmail_hospede(email_hospede);
				
				hospedes.add(hosp);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			con.fecharConexao();
		}
	
		return hospedes;
	}
	
	public boolean atualizarHospedes(Hospedes hosp) {
		
String SQL = "UPDATE Hospedes SET Nome_Hospede = ? , sobrenome_hospede = ?, nascimento_hospede = ?, telefone_hospede = ?, email_hospede = ? WHERE ID_Hospede = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setString(1, hosp.getNome_Hospede());
			ps.setString(2, hosp.getSobrenome_hospede());
			ps.setDate(3, hosp.getNascimento_hospede());
			ps.setInt(4, hosp.getTelefone_hospede());
			ps.setString(5, hosp.getEmail_hospede());
			
			
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		
		return (retorno == 0 ? false : true);
		

	}
	
	public boolean removerHospedes(Hospedes end) {
		
		return false;
	}
	
	public Hospedes buscarHospedes(Hospedes end) {
		
		return null;
	}

}