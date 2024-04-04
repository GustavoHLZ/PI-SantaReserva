package modelo;

public class Info_Login {
	private int idUsuario;
	private String login;
	private String senha;
	private int fkIDHospede;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getFkIDHospede() {
		return fkIDHospede;
	}
	public void setFkIDHospede(int fkIDHospede) {
		this.fkIDHospede = fkIDHospede;
	}
	
	

}
