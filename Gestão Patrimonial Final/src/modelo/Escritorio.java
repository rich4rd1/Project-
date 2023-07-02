package modelo;

import java.util.ArrayList;

/**
* 	Implementa a classe de Escritorio.
* 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Sousa Cavalcante
 * @since 2023
 * @version 1.0
*/

public class Escritorio {
	private String nomeEscritorio;
	private ArrayList<Filial> filiais = new ArrayList<Filial>();

/**
 *  Instância do objeto vazio para caso queira pegar um parâmetro separado
 */
	public Escritorio() {

	}

/**
 * Atribuição dos parâmetros.
 * 
 * @param nomeEscritorio Nome do escritório.
 * @param filiais ArrayList de filiais.
 * */
	public Escritorio(String nomeEscritorio, ArrayList<Filial> filiais) {
		super();
		this.nomeEscritorio = nomeEscritorio;
		this.filiais = filiais;
	}

	public String getNomeEscritorio() {
		return nomeEscritorio;
	}

	public void setNomeEscritorio(String nomeEscritorio) {
		this.nomeEscritorio = nomeEscritorio;
	}

	public void setFiliais(ArrayList<Filial> filial) {
		filiais = filial;
	}

	public ArrayList<Filial> getFiliais() {
		return filiais;
	}

	/**
	 * Método responsável por cadastrar cinco filiais para que o programa sempre inicie com filiais pré-cadastradas.
	 * Esses dados são pré-cadastrados com valores de modo que passam pela validação do método editarCadastrarFilial.
	 * */
	
	public void fillFilialWithSomeData() {
		for (int i = 0; i < 5; i++) {
			Filial f = new Filial();
			
			String nomeFilial = "Filial" + i;
			String cnpjFilial = "12345678912345" + i;
			String enderecoFilial = "Endereco" + i;
			
			f.setNome(nomeFilial);
			f.setCnpj(cnpjFilial);
			f.setEndereco(enderecoFilial);
			filiais.add(f);
		}

	}
	
	/**
	 * Método responsável por cadastrar um patrimônio de cada tipo (Veiculo, Eletrônico, Equipamento Construção)
	 * para que o programa sempre inicie com patrimônios pré-cadastrados. Esses dados são pré-cadastrados com
	 * valores de modo que passam pela validação do método editarCadastrarPatrimônio.
	 * */
	
	public void fillPatrimonioWithSomeData() {
		int i = 0; // Número da filial

		for (Filial filial : getFiliais()) {
			for (int j = 0; j < 3; j++) { // Ajuste para percorrer apenas 3 vezes (para cada tipo de patrimônio)
				ItemPatrimonio patrimonio;
				String tipo;
				String nome;
				int quantidade = 1;
				double valor = 2500 + j;
				String marca = "Marca" + j;

				if (j == 0) {
					patrimonio = new Veiculo();
					tipo = "Veiculo";
					((Veiculo) patrimonio).setTipoVeiculo("Tipo" + i);
					((Veiculo) patrimonio).setCor("Cor" + i);
					((Veiculo) patrimonio).setQtdPortas(2);
				} else if (j == 1) {
					patrimonio = new EquipamentoEletronico();
					tipo = "Eletronico";
					((EquipamentoEletronico) patrimonio).setPesoEquipamento(i);
					((EquipamentoEletronico) patrimonio).setVoltagem(220);
					((EquipamentoEletronico) patrimonio).setSistema("Sistema" + i);
					((EquipamentoEletronico) patrimonio).setModelo("Modelo" + i);
				} else {
					patrimonio = new EquipamentoConstrucao();
					tipo = "Equipamento";
					((EquipamentoConstrucao) patrimonio).setPesoEquipamento(i);
					((EquipamentoConstrucao) patrimonio).setAnoFabricacao(2010 + i);
					((EquipamentoConstrucao) patrimonio).setMaterial("Material" + i);
				}

				nome = tipo + i; // Concatena o tipo e o número da filial

				patrimonio.setNomeItem(nome);
				patrimonio.setQuantidade(quantidade);
				patrimonio.setValor(valor);
				patrimonio.setMarca(marca);

				filial.editarCadastrarPatrimonio(patrimonio);
			}

			i++; // Incrementa o número da filial para a próxima iteração
		}
	}

	/**
	 * Método responsável por armazenar os dados, validados, recebidos do método editarCadastrarFilial presente na classe
	 * ControleDados do pacote controle para que, de fato, seja feito o cadastro ou edição de uma filial.
	 * 
	 * @param index Posição da filial selecionada.
	 * @param filial Objeto do tipo {@link Filial} para trabalhar com gets e sets da filial.
	 * */
	
	public void editarCadastrarFilial(int index, Filial filial) {
		if (index == filiais.size()) {
			filiais.add(filial);
		} else {
			filiais.get(index).setNome(filial.getNome());
			filiais.get(index).setCnpj(filial.getCnpj());
			filiais.get(index).setEndereco(filial.getEndereco());
			filiais.get(index).setPatrimonio(filial.getPatrimonio());
		}
	}
	
	/**
	 * Armazena o nome das filiais num vetor do tipo String.
	 * 
	 * @return retorna o vetor de String com os nomes de todas as filiais.
	 * */

	public String[] listarFiliais() {
		String[] filiaisListadas = new String[filiais.size()];
		for (int i = 0; i < filiais.size(); i++) {
			filiaisListadas[i] = filiais.get(i).getNome();
		}
		return filiaisListadas;
	}
	
	/**
	 * Método responsável por validar se o nome da Filial adquirido é igual ao parâmetro nome.
	 * 
	 * @param nome Nome utilizado para comparar se o nome inserido é igual ao nome da filial.
	 * @return {@code true} se o nome for igual ao nome da filial e {@code false} caso o contrário.
	 * */
	
	public boolean buscarPatrimonio(String nome) {
	    for (Filial filial : getFiliais()) {
	        for (ItemPatrimonio item : filial.getPatrimonio()) {
	            if (item.getNomeItem().equals(nome)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
	/**
	 * Método responsável por remover uma filial.
	 * 
	 * @param filial Objeto do tipo {@link Filial} para trabalhar com gets e sets da filial.
	 * */

	public void removerFilial(Filial filial) {
		filiais.remove(filial);
	}

	public String toString() {
		return nomeEscritorio + filiais;
	}
}
