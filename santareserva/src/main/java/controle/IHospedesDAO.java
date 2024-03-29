package controle;

import java.util.ArrayList;

import modelo.Hospedes;

public interface IHospedesDAO {

	public int InserirHospedes(Hospedes end);
	
	public ArrayList<Hospedes> listarHospedes();
	
	public boolean atualizarHospedes(Hospedes end);
	
	public boolean removerHospedes(Hospedes end);
	
    public Hospedes buscarHospedes(String email_hospede,String senha_hospede);
	
}
