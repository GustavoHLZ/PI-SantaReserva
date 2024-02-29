package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public int InserirHospedes(Hospedes end) {
		String SQL = "INSERT INTO Hospedes (ID_Hospede, Nome_Hospede, sobrenome_hospede, nascimento_hospede, telefone_hospede, email_hospede) VALUES (?,?,?,?,?,?)";
		return 0;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			con.fecharConexao();
		}
	
		return hospedes;
	}
	
	public boolean atualizarHospedes(Hospedes end) {
		
		return false;
	}
	
	public boolean removerHospedes(Hospedes end) {
		
		return false;
	}
	
	public Hospedes buscarHospedes(Hospedes end) {
		
		return null;
	}

}