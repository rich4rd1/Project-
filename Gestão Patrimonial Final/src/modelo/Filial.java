package modelo;

import java.util.ArrayList;

/**
 * Implementação da classe Filial.
 * 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Sousa Cavalcante
 * @since 2023
 * @version 1.0
 * */

public class Filial {
	private String nome;
	private String cnpj;
	private String endereco;
	private ArrayList<ItemPatrimonio> patrimonio = new ArrayList<ItemPatrimonio>();
	
	/**
	 * Instância o objeto vazio para caso queira pegar um parametro separado.
	 * */

	public Filial() {

	}
	
	/**
	 * Atribui os parâmetros a cada atributo da classe.
	 * 
	 * @param nomeItem Nome da filial.
	 * @param cnpj CNPJ da filial.
	 * @param endereco Endereço da filial.
	 * */

	public Filial(String nome, String cnpj, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		this.cnpj = cnpj;
		this.patrimonio = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<ItemPatrimonio> getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(ArrayList<ItemPatrimonio> patrimonios) {
		patrimonio = patrimonios;
	}

	public String toString() {
		return "\nNOME FILIAL: " + nome + "\nCNPJ: " + cnpj + "\nENDERECO: " + endereco + "\n";
	}
	
	/**
	 * Método responsável por editar ou cadastrar os itens validados na classe ControleDados presentes no pacote controle.
	 * 
	 * @param item Objeto do tipo {@link ItemPatrimonio} que permite trabalhar com os gets e sets das classes filhas.
	 * */

	public void editarCadastrarPatrimonio(ItemPatrimonio item) {
		patrimonio.add(item);
	}
	
	/**
	 * Método responsável remover os validados na classe ControleDados presentes no pacote controle.
	 * 
	 * @param item Objeto do tipo {@link ItemPatrimonio} que permite trabalhar com os gets e sets das classes filhas.
	 * */

	public void removerPatrimonio(int index, ItemPatrimonio item) {
		patrimonio.remove(index);
	}
	
	/**
	 * Armazena o nome dos itens de patrimônio num vetor do tipo String.
	 * 
	 * @return retorna o vetor de String com os nomes dos itens de patrimônio.
	 * */

	public String[] listarPatrimonio() {
		String[] patrimonioListados = new String[patrimonio.size()];
		for (int i = 0; i < patrimonio.size(); i++) {
			patrimonioListados[i] = patrimonio.get(i).getNomeItem();
		}
		return patrimonioListados;

	}

}
