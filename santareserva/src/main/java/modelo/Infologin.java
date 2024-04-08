package modelo;

public class Infologin {
	private int idUsuario;
	private boolean admin;
	private String login;
	private String senha;
	
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
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	// verifica se o usuario é um admnistrador ou hospede
	public int getAdmin() {
		// TODO Auto-generated method stub
		if( admin == true) {
			return 0;
		}else {
			return 1;
		}
	}
	
	

}
