package modelo;

import java.sql.Date;

public class Hospedes {

	private int idHospede;
	private String nome;
	private String sobrenome;
	private Date nascimento;
	private int telefone;
	private String email;
	private String senha;
	private int fkidUsuario;
	
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
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getFkidUsuario() {
		return fkidUsuario;
	}
	public void setFkidUsuario(int fkidUsuario) {
		this.fkidUsuario = fkidUsuario;
	}
	

}
