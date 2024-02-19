package modelo;

import java.sql.Date;

public class Hospedes {

	private int ID_Hospede;
	private String Nome_Hospede;
	private String sobrenome_hospede;
	private Date nascimento_hospede;
	private char telefone_hospede;
	private String email_hospede;
	public int getID_Hospede() {
		return ID_Hospede;
	}
	public void setID_Hospede(int iD_Hospede) {
		ID_Hospede = iD_Hospede;
	}
	public String getNome_Hospede() {
		return Nome_Hospede;
	}
	public void setNome_Hospede(String nome_Hospede) {
		Nome_Hospede = nome_Hospede;
	}
	public String getSobrenome_hospede() {
		return sobrenome_hospede;
	}
	public void setSobrenome_hospede(String sobrenome_hospede) {
		this.sobrenome_hospede = sobrenome_hospede;
	}
	public Date getNascimento_hospede() {
		return nascimento_hospede;
	}
	public void setNascimento_hospede(Date nascimento_hospede) {
		this.nascimento_hospede = nascimento_hospede;
	}
	public char getTelefone_hospede() {
		return telefone_hospede;
	}
	public void setTelefone_hospede(char telefone_hospede) {
		this.telefone_hospede = telefone_hospede;
	}
	public String getEmail_hospede() {
		return email_hospede;
	}
	public void setEmail_hospede(String email_hospede) {
		this.email_hospede = email_hospede;
	}
	

}
