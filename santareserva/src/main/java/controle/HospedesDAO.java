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
		
		String SQL = "INSERT INTO Hospedes (nome, sobrenome, nascimento, telefone, fkidUsuario) VALUES (?, ?, ?, ?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int chavePrimariaGerada = Integer.MIN_VALUE;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, hosp.getNome());
			ps.setString(2, hosp.getSobrenome());
			ps.setDate(3, java.sql.Date.valueOf(hosp.getNascimento()));
			ps.setString(4, hosp.getTelefone());
			// puxa o objeto de Infologin em hospede e coloca seu id na chave estrangeira
			ps.setInt(5, hosp.getLogin().getIdUsuario());
		
			 
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		//return chavePrimariaGerada;
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
				
				Integer IDHospede = rs.getInt("idHospede");
				String NomeHospede = rs.getString("nome");
				String sobrenomehospede = rs.getString("sobrenome");
				Date nascimentohospede = rs.getDate("nascimento");
				String telefonehospede = rs.getString("telefone");
				String emailhospede = rs.getString("email");
				String senhahospede = rs.getString("senha");
				
				hosp.setIdHospede(0);
				hosp.setNome(NomeHospede);
				hosp.setSobrenome(sobrenomehospede);
//				hosp.setNascimento(nascimentohospede);
				hosp.setTelefone(telefonehospede);
//				hosp.setEmail(emailhospede);
//				hosp.setSenha(senhahospede);
				
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
		
String SQL = "UPDATE Hospedes SET nome = ? , sobrenome = ?, nascimento = ?, telefone = ?, email = ?, senha = ? WHERE idHospede = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setString(1, hosp.getNome());
			ps.setString(2, hosp.getSobrenome());
//			ps.setDate(3, hosp.getNascimento());
			ps.setString(4, hosp.getTelefone());
//			ps.setString(5, hosp.getEmail());
//			ps.setString(6, hosp.getSenha());
			
			
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		
		return (retorno == 0 ? false : true);
		

	}
	
	public boolean removerHospedes(Hospedes end) {
		
		String SQL = "DELETE FROM Hospedes WHERE idHospede = ?";
		
		// Abre a conexão e cria a "ponte de conexao " com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getIdHospede());
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			}
	
		return (retorno == 0 ? false : true);
		
	}
	
	public Hospedes buscarHospedes(String email,String senha) {
		
		
		Hospedes login = null;
		String SQL = "SELECT * FROM Hospedes WHERE email = ? AND senha = ?";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
	try {
		PreparedStatement ps = conBD.prepareStatement(SQL);
		ps.setString(1,email);
		ps.setString(2, senha);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			login = new Hospedes();
			int ID = rs.getInt("idHospede");
			String Email = rs.getString("email");
			String Senha = rs.getString("senha");
//			login.setEmail(Email);
//			login.setSenha(Senha);
			login.setIdHospede(ID);
		}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		
		
		return login;
	}
	
}

