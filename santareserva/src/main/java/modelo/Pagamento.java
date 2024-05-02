package modelo;

public class Pagamento {

	private int idPagamento;
	private String nometitular;
	private int numeroCartao;
	private String dataValidade;
	private int codigoSeguranca;
	private int numeroBoleto;
	private int numeroPix;
	
	public int getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}
	
	public String getNometitular() {
		return nometitular;
	}
	public void setNometitular(String nometitular) {
		this.nometitular = nometitular;
	}

	
	public int getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(int numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	public int getCodigoSeguranca() {
		return codigoSeguranca;
	}
	public void setCodigoSeguranca(int codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}
	public int getNumeroBoleto() {
		return numeroBoleto;
	}
	public void setNumeroBoleto(int numeroBoleto) {
		this.numeroBoleto = numeroBoleto;
	}
	public int getNumeroPix() {
		return numeroPix;
	}
	public void setNumeroPix(int numeroPix) {
		this.numeroPix = numeroPix;
	}
	
}
	
	
