package controle;

import java.util.ArrayList;

import modelo.Hospedes;

public interface IHospedesDAO {

	public int InserirHospedes(Hospedes end);
	
	public ArrayList<Hospedes> listarHospedes();
	
	public Hospedes atualizarHospedes(Hospedes hosp);
	
	public Hospedes removerHospedes(String email);
	
    public Hospedes buscarHospedes(String email_hospede,String senha_hospede);
	
}
