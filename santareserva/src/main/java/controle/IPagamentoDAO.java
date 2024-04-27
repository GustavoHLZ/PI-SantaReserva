package controle;

import java.util.ArrayList;

import modelo.Pagamento;

public interface IPagamentoDAO {

	public int InserirPagamento(Pagamento end);
	
	public ArrayList<Pagamento> listarPagamento();
	
	public boolean atualizarPagamento(Pagamento end);
	
	public boolean removerPagamento(Pagamento end);
	
    public Pagamento buscarPagamento(Pagamento end);
	
}
