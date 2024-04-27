package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Pagamento;

public class PagamentoDAO implements IPagamentoDAO{
	
	
	private static PagamentoDAO instancia;

	private PagamentoDAO() {
	}

	public static PagamentoDAO getInstancia() {

		if (instancia == null) {
			instancia = new PagamentoDAO();
		}
		return instancia;
	}
	

	@Override
	public int InserirPagamento(Pagamento pag) {

		String SQL = "INSERT INTO Pagamento (nometitular, numeroCartao, dataValidade, codigoSeguranca, numeroBoleto, numeroPix) VALUES (?, ?, ?, ?, ?, ?)";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, pag.getNometitular());
			ps.setString(2, pag.getNumeroCartao());
			ps.setString(3, pag.getDataValidade());
			ps.setString(4, pag.getCodigoSeguranca());
			ps.setString(5, pag.getNumeroBoleto());
			ps.setString(6, pag.getNumeroPix());
			
			
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

	@Override
	public ArrayList<Pagamento> listarPagamento() {
		
		ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();

		String SQL = "SELECT * FROM Pagamento";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Pagamento pags = new Pagamento();

				String nometitular = rs.getString("nometitular");
				String numeroCartao = rs.getString("numeroCartao");
				String dataValidade = rs.getString("dataValidade");
				String codigoSeguranca = rs.getString("codigoSeguranca");
				String numeroBoleto = rs.getString("numeroBoleto");
				String numeroPix = rs.getString("numeroPix");

				pags.setNometitular(nometitular);
				pags.setNumeroCartao(numeroCartao);
				pags.setDataValidade(dataValidade);
				pags.setCodigoSeguranca(codigoSeguranca);
				pags.setNumeroBoleto(numeroBoleto);
				pags.setNumeroPix(numeroPix);

				pagamentos.add(pags);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return pagamentos;
	}

	@Override
	public boolean atualizarPagamento(Pagamento end) {
		
		String SQL = "UPDATE Pagamento SET nometitular = ? WHERE idPagamento = ?";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, end.getIdPagamento());
			
			
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		
		return (retorno == 0 ? false : true);
	}

	@Override
	public boolean removerPagamento(Pagamento end) {
		
		String SQL = "DELETE FROM Pagamento WHERE idPagamento = ?";
		
		// Abre a conexão e cria a "ponte de conexao " com MYSQL
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		int retorno = 0;
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ps.setInt(1, end.getIdPagamento());
			retorno = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
			}
	
		return (retorno == 0 ? false : true);
	}

	@Override
	public Pagamento buscarPagamento(Pagamento end) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
