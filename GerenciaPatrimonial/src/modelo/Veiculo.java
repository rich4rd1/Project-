package modelo;

/**
 * Implementa a classe de Veiculo herdando de ItemPatrimonio.
 * 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Sousa Cavalcante
 * @since 2023
 * @version 1.0
 * */

public class Veiculo extends ItemPatrimonio {
	private String tipoVeiculo;
	private String cor;
	private int qtdPortas;
	/**
	 * Instância do objeto vazio para caso queira pegar um parâmetro separado.
	 */
	public Veiculo() {
		super();
	}

	/**
	 * Atribui os parâmetros a cada atributo da classe pai {@link ItemPatrimonio} e sua filha que herda seus atributos.
	 * 
	 * @param nomeItem Nome veiculo.
	 * @param quantidade Quantidade veiculo.
	 * @param valor	Valor veiculo.
	 * @param marca Marca veiculo.
	 * @param tipoVeiculo Tipo veiculo.
	 * @param cor Cor veiculo.
	 * @param qtdPortas Quantidade de portas do veiculo.
	 */
	public Veiculo(String nomeItem, int quantidade, double valor, String marca, String tipoVeiculo, String cor, int qtdPortas) {
		this.nomeItem = nomeItem;
		this.quantidade = quantidade;
		this.valor = valor;
		this.marca = marca;
		this.tipoVeiculo = tipoVeiculo;
		this.cor = cor;
		this.qtdPortas = qtdPortas;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getQtdPortas() {
		return qtdPortas;
	}

	public void setQtdPortas(int qtdPortas) {
		this.qtdPortas = qtdPortas;
	}

	@Override
	public String toString() {
		return super.toString() + "TIPO: " + tipoVeiculo + "\nCOR: " + cor + "\nQUANTIDADE DE PORTAS: " + qtdPortas + "\n";
	}

}
