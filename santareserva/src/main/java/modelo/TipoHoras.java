package modelo;

public enum TipoHoras {

	uma_hora(1, "1 hora"), duas_horas(2, "2 horas"), tres_horas(3, "3 horas");

	private int num;
	private String desc;

	TipoHoras(int valorNumerico, String descricao) {
		this.num = valorNumerico;
		this.desc = descricao;
	}

	public int getValorNumerico() {
		return num;
	}

	public String getDesc() {
		return desc;
	}
	
	public static TipoHoras converteEnumPorValor(String descricao) {
		
		for (TipoHoras tipoHora : TipoHoras.values()) {
			if(descricao.equals(tipoHora.getDesc())) {
				return tipoHora;
			}
		}
		
		return null;
	}

}
