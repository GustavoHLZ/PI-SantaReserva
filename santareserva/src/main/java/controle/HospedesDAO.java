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
				
				Integer IDHospede = rs.getInt("idHospede");
				String NomeHospede = rs.getString("nome");
				String sobrenomehospede = rs.getString("sobrenome");
//				LocalDate nascimentohospede = rs.getDate.valueOf("nascimento");
				String telefonehospede = rs.getString("telefone");
				String emailhospede = rs.getString("email");
				String senhahospede = rs.getString("senha");
				
				hosp.setIdHospede(0);
				hosp.setNome(NomeHospede);
				hosp.setSobrenome(sobrenomehospede);
//				hosp.setNascimento(nascimentohospede);
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
	
	public Hospedes atualizarHospedes(Hospedes hosp) {
		
		String SQL = "UPDATE Hospedes SET nome = ? , sobrenome = ?, nascimento = ?, telefone = ?, email = ?, senha = ? WHERE senha LIKE ?";
		
		Hospedes update = null;
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setString(1, hosp.getNome());
			ps.setString(2, hosp.getSobrenome());
			ps.setDate(3, java.sql.Date.valueOf(hosp.getNascimento()));
			ps.setString(4, hosp.getTelefone());
			ps.setString(5, hosp.getLogin().getLogin());
			ps.setString(6, hosp.getLogin().getSenha());
			
			
			ps.executeUpdate();
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				update = new Hospedes();
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
//				LocalDate nascimento = rs.getDate("nascimento");
				String telefone = rs.getString("telefone");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				
				update.setNome(nome);
				update.setSobrenome(sobrenome);;
//				update.setNascimento(nascimento);
				update.setTelefone(telefone);
				update.getLogin().setLogin(email);
				update.getLogin().setSenha(senha);
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
	
	public Hospedes buscarHospedes(String email,String senha) {
		
		
		Hospedes login = null;
		String SQL = "SELECT * FROM Hospedes Inner Join Infologin ON Hospedes.fkidUsuario = infologin.idUsuario WHERE infologin.email = ? AND infologin.senha = ?";
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
	try {
		PreparedStatement ps = conBD.prepareStatement(SQL);
		ps.setString(1,email);
		ps.setString(2, senha);
		System.out.println(ps);
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
		
		InfologinDAO loginDAO = InfologinDAO.getInstancia();
		
		Infologin info = loginDAO.buscarInfologin(email, senha);
		
		login.setLogin(info);
		
		return login;
	}
	
}

