package modelo;

/**
 * Implementa a classe de Equipamento Eletronico herdando de ItemPatrimonio.
 * 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Sousa Cavalcante
 * @since 2023
 * @version 1.0
 * */

public class EquipamentoEletronico extends ItemPatrimonio {
	private double pesoEquipamento;
	private int voltagem;
	private String sistema;
	private String modelo;

	/**
	 *  Instância do objeto vazio para caso queira pegar um parametro separado.
	 */

	public EquipamentoEletronico() {
		super();
	}

	
	/**
	 * Atribui os parâmetros a cada atributo da classe pai {@link ItemPatrimonio} e sua filha que herda seus atributos.
	 * 
	 * @param nomeItem Nome do eletrônico.
	 * @param quantidade Quantidade do eletrônico.
	 * @param valor Valor do eletrônico.
	 * @param marca	Marca do eletrônico.
	 * @param pesoEquipamento Peso do eletrônico.
	 * @param voltagem Voltagem do eletrônico.
	 * @param sistema Sistema do eletrônico.
	 * @param modelo Modelo do eletrônico.
	 */
	public EquipamentoEletronico(String nomeItem, int quantidade, double valor, String marca, double pesoEquipamento,
			int voltagem, String sistema, String modelo) {
		this.nomeItem = nomeItem;
		this.quantidade = quantidade;
		this.valor = valor;
		this.marca = marca;
		this.pesoEquipamento = pesoEquipamento;
		this.voltagem = voltagem;
		this.sistema = sistema;
		this.modelo = modelo;
	}

	public double getPesoEquipamento() {
		return pesoEquipamento;
	}

	public void setPesoEquipamento(double pesoEquipamento) {
		this.pesoEquipamento = pesoEquipamento;
	}

	public int getVoltagem() {
		return voltagem;
	}

	public void setVoltagem(int voltagem) {
		this.voltagem = voltagem;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return super.toString() + "\nPESO: " + pesoEquipamento + "\nVOLTAGEM: " + voltagem + "\nSISTEMA: " + sistema
				+ "\nMODELO: " + modelo + "\n";
	}

}
