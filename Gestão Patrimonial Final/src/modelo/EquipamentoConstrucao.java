package modelo;

/**
 * Implementa a classe de Equipamento de contrução herdando de ItemPatrimonio.
 * 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Sousa Cavalcante
 * @since 2023
 * @version 1.0
 * */

public class EquipamentoConstrucao extends ItemPatrimonio {
	private double pesoEquipamento;
	private int anoFabricacao;
	private String material;

	/** 
	 * Instância o objeto vazio para caso queira pegar um parametro separadamente.
	 */

	public EquipamentoConstrucao() {
		super();
	}

	/**
	 * Atribui os parâmetros a cada atributo da classe pai {@link ItemPatrimonio} e sua filha que herda seus atributos.
	 * 
	 * @param nomeItem Nome do equipamento de construção.
	 * @param quantidade Quantidade do equipamento de construção.
	 * @param valor Valor do equipamento de construção. 
	 * @param marca	Marca do equipamento de construção.
	 * @param pesoEquipamento Peso do equipamento de construção.
	 * @param anoFabricacao	Ano de fabriação do equipamento de construção.
	 * @param material Material do equipamento de construção.
	 */
	
	public EquipamentoConstrucao(String nomeItem, int quantidade, double valor, String marca, double pesoEquipamento,
			int anoFabricacao, String material) {
		this.nomeItem = nomeItem;
		this.quantidade = quantidade;
		this.valor = valor;
		this.marca = marca;
		this.pesoEquipamento = pesoEquipamento;
		this.anoFabricacao = anoFabricacao;
		this.material = material;
	}

	public double getPesoEquipamento() {
		return pesoEquipamento;
	}

	public void setPesoEquipamento(double pesoEquipamento) {
		this.pesoEquipamento = pesoEquipamento;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return super.toString() + "\nPESO: " + pesoEquipamento + "\nANO FABRICACAO: " + anoFabricacao + "\nMATERIAL: "
				+ "\n";
	}

}
