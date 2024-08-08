package controle;

import java.time.LocalDate;

public interface IReserva {
	
	public LocalDate getCheckIn();
	public LocalDate getCheckOut();
	public int getId() ;
	public Float getPreco();
	public Boolean getStatus();
	public void efetuarPagamento();	
	

}
