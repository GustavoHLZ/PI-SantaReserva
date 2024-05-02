package controle;

import java.util.ArrayList;

import modelo.Pagamento;

public interface IPagamentoDAO {

	public int InserirPagamento(Pagamento end);
	
	public ArrayList<Pagamento> listarPagamento();
	
	public boolean atualizarPagamento(int idpagamento, String nome, int numcartao, String validade, int seg, int numboleto,
			int numpix);
	
	public boolean removerPagamento(int idpagamento);
	
    public Pagamento buscarPagamento(Pagamento end);

}
