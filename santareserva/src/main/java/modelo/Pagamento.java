package modelo;

public class Pagamento {

	private int idPagamento;
	private String nometitular;
	private long numeroCartao;
	private String dataValidade;
	private int codigoSeguranca;
	private int numeroBoleto;
	private int numeroEspaco;
	private Hospedes hosp;
	
	public Hospedes getHosp() {
		return hosp;
	}
	public void setHosp(Hospedes hosp) {
		this.hosp = hosp;
	}
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
	
	public long getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(long numeroCartao) {
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
	public int getNumeroEspaco() {
		return numeroEspaco;
	}
	public void setnumeroEspaco(int numeroEspaco) {
		this.numeroEspaco = numeroEspaco;
	}
	
}
	
	
