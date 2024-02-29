package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import modelo.Espacos;
import modelo.Espacos_Reservados;

public class EspacosDAO implements IEspacosDAO {
	
private static EspacosDAO instancia;
	
	private EspacosDAO() {}
	
	public static EspacosDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new EspacosDAO();
		}
		return instancia;
	}

	public int InserirEspacos(Espacos end) {
		String SQL = "INSERT INTO Espacos (ID_Espaco, Ocupante_Espaco, Check_In, Check_Out) VALUES (?,?,?,?)";
		return 0;
	}

	public ArrayList<Espacos> listarEspacos() {
		ArrayList<Espacos> espacos = new ArrayList<Espacos>();
		
		String SQL = "SELECT * FROM Espacos";
		
		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps= conBD.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Espacos esp = new Espacos();
				
				Integer ID_Espaco = rs.getInt("ID_Espaco");
				Integer Ocupante_Espaco = rs.getInt("Ocupante_Espaco");
				Date Check_In = rs.getDate("Check_In");
				Date Check_Out = rs.getDate("Check_Out");
				
				esp.setID_Espaco(ID_Espaco);
				esp.setOcupante_Espaco(Ocupante_Espaco);
				esp.setCheck_In(Check_In);
				esp.setCheck_Out(Check_Out);
				
				espacos.add(esp);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			con.fecharConexao();
		}
	
		return espacos;
	}

	public boolean atualizarEspacos(Espacos end) {

		return false;
	}

	public boolean removerEspacos(Espacos end) {

		return false;
	}

	public Espacos buscarEspacos(Espacos end) {

		return null;
	}

}
