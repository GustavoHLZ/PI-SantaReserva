package modelo;

import java.time.LocalDate;

public class Hospedes {

	private int idHospede;
	private String nome;
	private String sobrenome;
	private LocalDate nascimento;
	private String telefone;
	private Infologin login;

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	// cria um objeto do tipo Infologin

	public int getIdHospede() {
		return idHospede;
	}

	public void setIdHospede(int idHospede) {
		this.idHospede = idHospede;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Infologin getLogin() {
		return login;
	}

	public void setLogin(Infologin login) {
		this.login = login;
	}

}
