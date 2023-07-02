package modelo;

/**
 * Implementa a classe ItemPatrimonio.
 * 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Sousa Cavalcante
 * @since 2023
 * @version 1.0
 */

public abstract class ItemPatrimonio {
	protected String nomeItem;
	protected int quantidade;
	protected double valor;
	protected String marca;

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String toString() {
		return "NOME PATRIMONIO: " + nomeItem + "\nQUANTIDADE: " + quantidade + "\nVALOR: " + valor +"\nMARCA: "+ marca +"\n";
	}
	
}
