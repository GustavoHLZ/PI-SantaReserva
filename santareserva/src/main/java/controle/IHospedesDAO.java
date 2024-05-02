package controle;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Hospedes;
import modelo.Infologin;

public interface IHospedesDAO {

	public int InserirHospedes(Hospedes end);
	
	public ArrayList<Hospedes> listarHospedes();
	
	public Hospedes atualizarHospedes(String nome, String sobrenome, LocalDate nascimento, String telefone,  Integer id);
	
	public Hospedes removerHospedes(String email);
	
    public Hospedes buscarHospedes(Infologin login);
	
}
