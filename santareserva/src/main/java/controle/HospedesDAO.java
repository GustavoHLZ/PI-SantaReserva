package controle;

import java.util.ArrayList;

import modelo.Hospedes;

public class HospedesDAO implements IHospedesDAO {
	
<<<<<<< HEAD
private static HospedesDAO instancia;
	
	private HospedesDAO() {}
	
	public static HospedesDAO getInstancia() {
		
		if(instancia == null) {
			instancia = new HospedesDAO();
		}
		return instancia;
	}
=======
>>>>>>> ConexaoBDD2
	
	public int InserirHospedes(Hospedes end) {
		
		return 0;
	}
	
	public ArrayList<Hospedes> listarHospedes() {
		
		return null;
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