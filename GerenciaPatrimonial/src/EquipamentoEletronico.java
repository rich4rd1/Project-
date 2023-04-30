
public class EquipamentoEletronico extends ItemPatrimonio {
	private String marcaEquipamento;
	private double pesoEquipamento;

	public EquipamentoEletronico() {
		super();
	}

	public EquipamentoEletronico(String nomeItem, int quantidade, double valor, String marcaEquipamento,
			double pesoEquipamento) {
		this.nomeItem = nomeItem;
		this.quantidade = quantidade;
		this.valor = valor;
		this.marcaEquipamento = marcaEquipamento;
		this.pesoEquipamento = pesoEquipamento;
	}

	public String getMarcaEquipamento() {
		return marcaEquipamento;
	}

	public void setMarcaEquipamento(String marcaEquipamento) {
		this.marcaEquipamento = marcaEquipamento;
	}

	public double getPesoEquipamento() {
		return pesoEquipamento;
	}

	public void setPesoEquipamento(double pesoEquipamento) {
		this.pesoEquipamento = pesoEquipamento;
	}

	@Override
	public String toString() {
		return super.toString() + "MARCA: " + marcaEquipamento + "\nPESO: " + pesoEquipamento + "\n";
	}

}
