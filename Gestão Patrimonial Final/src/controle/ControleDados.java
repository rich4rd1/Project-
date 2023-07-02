package controle;

import java.util.ArrayList;
import modelo.*;

/**
 * Implementa a classe ControleDados
 * 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Sousa Cavalcante
 * @since 2023;
 * @version 1.0;
 */

public class ControleDados {
	private Escritorio escritorio = new Escritorio();

	/**
	 * Chamada dos métodos de preenchimento de dados no construtor da classe
	 */
	public ControleDados() {
		escritorio.fillFilialWithSomeData();
		escritorio.fillPatrimonioWithSomeData();
	}

	public Filial getFilial(int index) {
		return escritorio.getFiliais().get(index);
	}

	public ArrayList<Filial> getFiliais() {
		return escritorio.getFiliais();
	}

	public void setFilial(ArrayList<Filial> filial) {
		escritorio.setFiliais(filial);
	}

	public Escritorio getEscritorio() {
		return escritorio;
	}

	public void setEscritorio(Escritorio escritorio) {
		this.escritorio = escritorio;
		escritorio.getFiliais();
	}

	
	/**
	 * Edita ou cadastra uma {@link Filial}. Esse método é responsável por validar a edição ou cadastro de uma filial, criando uma instância temporária
	 * na classe ControleDados e, caso seja validado, passa os valores para a classe {@link Escritorio}, presente no pacote modelo, efetivando a edição ou cadastro
	 * de uma filial.
	 * 
	 * @param nome Nome da filial a ser editada ou cadastrada.
	 * @param cnpj CNPJ da filial a ser editada ou cadastrada.
	 * @param endereco Endereço da filial a ser editada ou cadastrada.
	 * @param index Define o index referente a filial que será cadastrada ou editada.
	 * @return {@code true} caso o parâmetro CNPJ seja composto apenas por números, permitindo que o método dê prosseguimento ou {@code false} caso contrário.
	 */
	
	public boolean editarCadastrarFilial(String nome, String cnpj, String endereco, int index) {
		// Verifica se o campo de CNPJ foi preenchido com caracteres numéricos
		if (!cnpj.matches("[0-9]+")) {
			return false;
		} else {
			Filial filialTemporaria = new Filial(nome, cnpj, endereco);

			if (index == escritorio.getFiliais().size()) {
				// Adiciona a nova filial ao escritório
				escritorio.editarCadastrarFilial(index, filialTemporaria);
			} else {
				// Copia os patrimônios da filial existente para a nova filial
				Filial filialExistente = escritorio.getFiliais().get(index);
				filialTemporaria.setPatrimonio(filialExistente.getPatrimonio());

				// Substitui a filial existente pela nova filial
				escritorio.getFiliais().set(index, filialTemporaria);
			}
			return true;
		}
	}

	/**
	 * Edita ou cadastra um patrimônio do tipo {@link Veiculo}. Esse método é responsável por validar a edição ou cadastro de um patrimônio
	 * do tipo {@link Veiculo} no pacote controle para efetivar sua edição ou cadastro na classe {@link Filial} presente no pacote modelo. Satisfazendo a relação entre os pacotes view
	 * e modelo através do pacote controle.
	 * 
	 * 
	 * @param nome Define o nome do veiculo a ser editado ou cadastrado.
	 * @param quantidade Define a quantidade de veiculos a serem editados ou cadastrados.
	 * @param valor Define o valor do veiculo a ser editado ou cadastrado.
	 * @param marca Define a marca do veiculo a ser editado ou cadastrado.
	 * @param tipoVeiculo Define o tipo do veiculo a ser editado ou cadastrado.
	 * @param cor Define a cor do veiculo a ser editado ou cadastrado.
	 * @param qtdPortas Define a quantidade de portas que o veiculo possui.
	 * @param indexFilial Define a posição do veiculo dentro do Arraylist de Filiais
	 * @param index Define a posição do patrimônio {@link Veiculo} dentro do ArryList de Patrimonios em uma determinada filial.
	 * @return {@code true} caso os campos numéricos sejam preenchidos corretamente e {@code false} caso contrário.
	 */

	public boolean editarCadastrarPatrimonioVeiculo(String nome, String quantidade, String valor, String marca,
			String tipoVeiculo, String cor, String qtdPortas, int indexFilial, int index) {
		// Verifica se os valores informados são válidos
		if (!quantidade.matches("[0-9]+") || !valor.matches("[-+]?[0-9]*\\.?[0-9]*") || !qtdPortas.matches("[0-9]+")) {
			return false;
		} else {
			// Cria um objeto Veiculo temporário com os valores informados
			Veiculo veiculoTemporario = new Veiculo(nome, Integer.parseInt(quantidade), Double.parseDouble(valor),
					marca, tipoVeiculo, cor, Integer.parseInt(qtdPortas));
			if (index == escritorio.getFiliais().get(indexFilial).getPatrimonio().size()) {
				// Se o índice for igual ao tamanho da lista de patrimônios da filial, cadastra o veículo na filial
				escritorio.getFiliais().get(indexFilial).editarCadastrarPatrimonio(veiculoTemporario);

			} else {
				// Caso contrário, realiza a edição do veículo na filial
				escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index).setNomeItem(nome);
				escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index).setQuantidade(Integer.parseInt(quantidade));
				escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index).setValor(Double.parseDouble(valor));
				escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index).setMarca(marca);
				((Veiculo) escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index)).setCor(cor);
				((Veiculo) escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index)).setTipoVeiculo(tipoVeiculo);
				((Veiculo) escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index)).setQtdPortas(Integer.parseInt(qtdPortas));

			}
			return true;
		}
	}

	/**
	 * Edita ou cadastra um patrimônio do tipo {@link EquipamentoEletronico}. Esse método é responsável por validar a edição ou cadastro do patrimônio
	 * do tipo {@link EquipamentoEletronico} na classe ControleDados presente no pacote controle. Caso a validação seja bem sucedida, os valores atribuidos
	 * são passados para a classe {@link Filial} presente no pacote modelo, evitando a interação direta entre os pacotes view e modelo.
	 * 
	 * @param nome Nome do eletrônico a ser editado ou cadastrado.
	 * @param quantidade Quantidade de eletrônicos a serem editados ou cadastrados.
	 * @param valor Valor do eletrônico a ser editado ou cadastrado.
	 * @param marca Marca do eletrônico a ser editado ou cadastrado.
	 * @param peso Peso do eletrônico a ser editado ou cadastrado.
	 * @param voltagem Voltagem do eletrônico a ser editado ou cadastrado.
	 * @param sistema Sistema do eletrônico a ser editado ou cadastrado.
	 * @param modelo Modelo do eletrônico a ser editado ou cadastrado.
	 * 
	 * @param indexFilial Define a posição do eletrônico dentro do
	 *                    Arraylist de Filiais
	 * @param index Define a posição do patrimonio {@link EquipamentoEletronico} dentro do
	 *                    ArryList de patrimonio em uma determinada filial.
	 * @return {@code true} caso os campos numéricos sejam preenchdidos de forma correta {@code false} caso contrário.
	 */

	public boolean editarCadastrarPatrimonioEletronico(String nome, String quantidade, String valor, String marca,
			String peso, String voltagem, String sistema, String modelo, int indexFilial, int index) {
		// Verifica se os valores informados são válidos
		if (!quantidade.matches("[0-9]+") || !valor.matches("[-+]?[0-9]*\\.?[0-9]*")
				|| !peso.matches("[-+]?[0-9]*\\.?[0-9]*") || !voltagem.matches("[0-9]+")) {
			return false;
		} else {
			// Cria um objeto temporário de EquipamentoEletronico com os valores informados
			EquipamentoEletronico eqpeletronicoTemporario = new EquipamentoEletronico(nome,
					Integer.parseInt(quantidade), Double.parseDouble(valor), marca, Double.parseDouble(peso),
					Integer.parseInt(voltagem), sistema, modelo);
			
			if (index == escritorio.getFiliais().get(indexFilial).getPatrimonio().size()) {
				escritorio.getFiliais().get(indexFilial).editarCadastrarPatrimonio(eqpeletronicoTemporario);
			} else {
				// Realiza a edição do equipamento eletrônico na filial
				escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index).setNomeItem(nome);
				escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index).setQuantidade(Integer.parseInt(quantidade));
				escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index).setValor(Double.parseDouble(valor));
				escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index).setMarca(marca);
				((EquipamentoEletronico) escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index)).setPesoEquipamento(Double.parseDouble(peso));
				((EquipamentoEletronico) escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index)).setVoltagem(Integer.parseInt(voltagem));
				((EquipamentoEletronico) escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index)).setSistema(sistema);
			}
			return true;
		}
	}


	/**
	 * Edita ou cadastro um patrimônio do tipo {@link EquipamentoConstrucao}.Esse método é responsável por validar a edição ou cadastro do patrimônio
	 * do tipo {@link EquipamentoConstrucao} na classe ControleDados presente no pacote controle. Caso a validação seja bem sucedida, os valores atribuidos
	 * são passados para a classe {@link Filial} presente no pacote modelo, evitando a interação direta entre os pacotes view e modelo.
	 * 
	 * @param nome Nome do equipamento a ser editado ou cadastrado.
	 * @param quantidade Quantidade do equipamento a ser editado ou cadastrado.
	 * @param valor Valor do equipamento a ser editado ou cadastrado.
	 * @param marca Marca do equipamento a ser editado ou cadastrado.
	 * @param pesoEquipamento Peso do equipamento a ser editado ou cadastrado.
	 * @param anoFabricacao Ano de fabricação do equipamento a ser editado ou cadastrado.
	 * @param material Material do equipamento a ser editado ou cadastrado.
	 * @param indexFilial Define a posição do patrimônio equipamento dentro do Arraylist de
	 *                        Filiais.
	 * @param index Define a posição do patrimônio {@link EquipamentoConstrucao} dentro do
	 *                        ArryList de patrimonio de uma determinada filial.
	 * @return Retorna {@code true} caso os campos numéricos sejam preenchidos de forma correta e {@code false}
	 *         caso contrário.
	 */

	public boolean editarCadastrarPatrimonioConstrucao(String nome, String quantidade, String valor, String marca,
			String pesoEquipamento, String anoFabricacao, String material, int indexFilial, int index) {
		// Verifica se os valores informados são válidos
		if (!quantidade.matches("[0-9]+") || !valor.matches("[-+]?[0-9]*\\.?[0-9]*")
				|| !pesoEquipamento.matches("[-+]?[0-9]*\\.?[0-9]*") || !anoFabricacao.matches("[0-9]+")) {
			return false;
		} else {
			// Cria um objeto temporário de EquipamentoEletronico com os valores informados
			EquipamentoConstrucao eqpconstrucaoTemporario = new EquipamentoConstrucao(nome,
					Integer.parseInt(quantidade), Double.parseDouble(valor), marca, Double.parseDouble(pesoEquipamento),
					Integer.parseInt(anoFabricacao), material);
			if (index == escritorio.getFiliais().get(indexFilial).getPatrimonio().size()) {
				escritorio.getFiliais().get(indexFilial).editarCadastrarPatrimonio(eqpconstrucaoTemporario);

			} else {
				// Realiza a edição do equipamento de construção na filial
				escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index).setNomeItem(nome);
				escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index).setQuantidade(Integer.parseInt(quantidade));
				escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index).setValor(Double.parseDouble(valor));
				escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index).setMarca(marca);
				((EquipamentoConstrucao) escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index)).setPesoEquipamento(Double.parseDouble(pesoEquipamento));
				((EquipamentoConstrucao) escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index)).setAnoFabricacao(Integer.parseInt(anoFabricacao));
				((EquipamentoConstrucao) escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index)).setMaterial(material);
			}
			return true;
		}
	}

	/**
	 * Verifica se o patrimônio cadastrado é uma instância de {@link Veiculo}, {@link EquipamentoEletronico} ou {@link EquipamentoConstrucao}, por meio
	 * do operador instanceof. Sendo que, cada patrimônio recebe um valor do tipo int (1 para eletrônico, 2 para equipamento e 3 para veiculo) para que
	 * a edição ou cadastro de patrimônio seja processada corretamente em uma das classes citadas, evitando erros alarmantes e facilitando a interação
	 * com o usuário na hora de gerenciar cada tipo de patrimônio.
	 * 
	 * @param index Retorna um inteiro que representa qual o tipo de
	 *                    patrimonio será verificado.
	 * @param indexFilial Retorna um inteiro que representa a posiçõa da filial
	 *                    dentro do ArrayList de Filiais.
	 * 
	 * @return Retorna o numero referente ao equipamento e, caso o retorno seja diferente de 1, 2 ou 3, retorna 0. Indicando que representa
	 * nenhum patrimônio.
	 */

	public int verificaPatrimonio(int index, int indexFilial) {
		int eletronico = 1;
		int equipamento = 2;
		int veiculo = 3;
		ItemPatrimonio patrimonio = escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index);
		if (patrimonio instanceof EquipamentoEletronico) {
			return eletronico;
		}
		if (patrimonio instanceof EquipamentoConstrucao) {
			return equipamento;
		}
		if (patrimonio instanceof Veiculo) {
			return veiculo;
		}
		return 0;
	}

	/**
	 * Método responsável por pegar os atributos vinculados ao patrimônio do tipo {@link Veiculo}, evitando que existe vínculo 
	 * direto entre modelo e view.
	 * 
	 * @param index Representa o indice do veiculo dentro do Arraylist
	 * @param indexFilial Representa o indice da filial dentro do vetor
	 * @return Retorna o equipamento a ser pesquisado
	 */

	public Veiculo veiculo(int index, int indexFilial) {
		ItemPatrimonio item = escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index);
		return ((Veiculo) item);
	}

	/**
	 * Método responsável por pegar os atributos vinculados ao patrimônio do tipo {@link EquipamentoConstrucao}, evitando que existe vínculo 
	 * direto entre modelo e view.
	 * 
	 * @param index Representa o indice do Equipamento de Construção dentro do
	 *                    Arraylist
	 * @param indexFilial Representa o indice da filial dentro do vetor
	 * @return Retorna o equipamento a ser pesquisado
	 */

	public EquipamentoConstrucao eqpConstrucao(int index, int indexFilial) {
		ItemPatrimonio item = escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index);
		return ((EquipamentoConstrucao) item);
	}

	/**
	 * Método responsável por pegar os atributos vinculados ao patrimônio do tipo {@link EquipamentoEletronico}, evitando que existe vínculo 
	 * direto entre modelo e view.
	 * 
	 * @param index Representa o indice do Equipamento de Eletronico dentro do
	 *                    Arraylist
	 * @param indexFilial Representa o indice da filial dentro do vetor
	 * @return Retorna o equipamento a ser pesquisado
	 */

	public EquipamentoEletronico eqpEquipamentoEletronico(int index, int indexFilial) {
		ItemPatrimonio item = escritorio.getFiliais().get(indexFilial).getPatrimonio().get(index);
		return ((EquipamentoEletronico) item);
	}

	/**
	 * chamada do método excluir filial presente na classe {@link Escritorio} presente na classe modelo, excluindo
	 * uma filial selecionada pelo seu index;
	 * 
	 * @param index Representa a posição da filial selecionada.
	 */

	public boolean removerFilial(int index) {
		if (index >= 0 && index < escritorio.getFiliais().size()) {
			escritorio.removerFilial(getFiliais().get(index));
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Exclui o patrimonio vinculado a uma determinada filial.
	 * @param indexFilial Representa a posição da filial.
	 * @param index Representa a posição do patrimônio.
	 */

	public boolean removerPatrimonio(int indexFilial, int index) {
		if (index >= 0 && index < escritorio.getFiliais().get(indexFilial).getPatrimonio().size()) {
			escritorio.getFiliais().get(indexFilial).removerPatrimonio(index, null);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Faz a busca do patrimônio com base no seu nome. Sendo que, na classe ControleDados, esse método é validado para de fato permitir que a busca seja feita
	 * na classe {@link Escritorio} presente no pacote modelo. Evitando que haja relação direta entre view e modelo. Dessa forma, ao pesquisar por um patrimônio
	 * dado o seu nome, caso ele esteja presente na lista, abre a tela de gerenciamento do respectivo patrimônio pesquisado.
	 * 
	 * @param nome Nome inserido como base para procurar o patrimônio desejado.
	 * @return retorna um vetor com valores atribuídos {-1,-1} para representar que nenhum patrimônio foi selecionado, visto que não existe
	 * posição negativa no ArrayList de patrimônios.
	 * */

	public int[] buscarPatrimonio(String nome) {
		int index = 0;
		int indexPatrimonio = 0;
		if (escritorio.buscarPatrimonio(nome) == false) {
			int[] naoEncontrado = { -1, -1 };
			return naoEncontrado;
		} else {
			for (Filial filial : escritorio.getFiliais()) {
				for (ItemPatrimonio item : filial.getPatrimonio()) {
					if (item.getNomeItem().equals(nome)) {
						int[] nomeSelecionado = new int[2];
						nomeSelecionado[0] = index;
						nomeSelecionado[1] = indexPatrimonio;
						return nomeSelecionado;
					}
					indexPatrimonio++;

				}

				indexPatrimonio = 0;
				index++;

			}
			int[] naoEncontrado = { -1, -1 };
			return naoEncontrado;
		}
	}

}
