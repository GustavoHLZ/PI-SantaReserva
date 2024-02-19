package modelo;

import java.sql.Date;

public class Espacos {
	private int ID_Espaco;
	private int Ocupante_Espaco;
	private Date Check_In;
	private Date Check_Out;
	public int getID_Espaco() {
		return ID_Espaco;
	}
	public void setID_Espaco(int iD_Espaco) {
		ID_Espaco = iD_Espaco;
	}
	public int getOcupante_Espaco() {
		return Ocupante_Espaco;
	}
	public void setOcupante_Espaco(int ocupante_Espaco) {
		Ocupante_Espaco = ocupante_Espaco;
	}
	public Date getCheck_In() {
		return Check_In;
	}
	public void setCheck_In(Date check_In) {
		Check_In = check_In;
	}
	public Date getCheck_Out() {
		return Check_Out;
	}
	public void setCheck_Out(Date check_Out) {
		Check_Out = check_Out;
	}
	
}
