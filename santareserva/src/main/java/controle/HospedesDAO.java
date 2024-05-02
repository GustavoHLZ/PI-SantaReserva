package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Hospedes;
import modelo.Infologin;

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
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
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
				
				Integer id = rs.getInt("idHospede");
				String NomeHospede = rs.getString("nome");
				String sobrenomehospede = rs.getString("sobrenome");
				java.sql.Date sqlNascimento = rs.getDate("nascimento");
				LocalDate nascimentohospede = sqlNascimento == null ? null : sqlNascimento.toLocalDate();
				String telefonehospede = rs.getString("telefone");
				String emailhospede = rs.getString("email");
				String senhahospede = rs.getString("senha");
				
				hosp.setIdHospede(id);
				hosp.setNome(NomeHospede);
				hosp.setSobrenome(sobrenomehospede);
				hosp.setNascimento(nascimentohospede);
				hosp.setTelefone(telefonehospede);
				hosp.getLogin().setLogin(emailhospede);
				hosp.getLogin().setSenha(senhahospede);
				
				hospedes.add(hosp);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			con.fecharConexao();
		}
	
		return hospedes;
	}
	
	public Hospedes atualizarHospedes(String nome, String sobrenome, LocalDate nascimento, String telefone, Integer id) {
		
		String SQL = "UPDATE Hospedes SET nome = ? , sobrenome = ?, nascimento = ?, telefone = ? WHERE idHospede = ?";
		
		Hospedes update = null;
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setString(1, nome);
			ps.setString(2, sobrenome);
			java.sql.Date sqlNascimento = Date.valueOf(nascimento);
			ps.setDate(3, sqlNascimento);
			ps.setString(4, telefone);
			ps.setInt(5, id);
			
			
			
			ps.executeUpdate();
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				update = new Hospedes();
				String Unome = rs.getString("nome");
				String Usobrenome = rs.getString("sobrenome");
				java.sql.Date sqlUnascimento = rs.getDate("nascimento");
				LocalDate Unascimento = sqlUnascimento == null ? null : sqlUnascimento.toLocalDate();
				String Utelefone = rs.getString("telefone");
				Integer Uid = rs.getInt("idHospede");
				
				update.setNome(Unome);
				update.setSobrenome(Usobrenome);;
				update.setNascimento(Unascimento);
				update.setTelefone(Utelefone);
				update.setIdHospede(Uid);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		
		return update;
		

	}
	
	public Hospedes removerHospedes(String email) {
		
		String SQL = "DELETE FROM Hospedes WHERE nome = ?";
		
		Hospedes hospede = null;
		
		// Abre a conexão e cria a "ponte de conexao " com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setString(1, email);
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			}
	
		return hospede;
		
	}
	
	public Hospedes buscarHospedes(Infologin login) {
		
		
		Hospedes hospede = null;
		String SQL = "SELECT * FROM Hospedes Inner Join Infologin ON Hospedes.fkidUsuario = infologin.idUsuario WHERE infologin.email = ? AND infologin.senha = ?";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
	try {
		PreparedStatement ps = conBD.prepareStatement(SQL);
	
		ps.setString(1, login.getLogin());
		ps.setString(2, login.getSenha());
			ResultSet rs = ps.executeQuery();
			
			/**
		ps.setString(1, hospede.getNome());
		ps.setString(2, hospede.getSobrenome());
		java.sql.Date sqlNascimento = Date.valueOf(hospede.getNascimento());
		ps.setDate(3, sqlNascimento);
		ps.setString(4, hospede.getTelefone());**/
	
		
		
		
		if (rs.next()) {
			int ID = rs.getInt("idHospede");
			String nome = rs.getString("nome");
			String sobrenome = rs.getString("sobrenome");
			java.sql.Date sqlUnascimento = rs.getDate("nascimento");
			LocalDate Unascimento = sqlUnascimento == null ? null : sqlUnascimento.toLocalDate();
			String telefone = rs.getString("telefone");
			
			
			hospede = new Hospedes();
			hospede.setIdHospede(ID);
			hospede.setNome(nome);
			hospede.setSobrenome(sobrenome);
			hospede.setNascimento(Unascimento);
			hospede.setTelefone(telefone);
			hospede.setLogin(login);
		}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
				
		return hospede;
	}
	
}

