package controle;

import java.util.ArrayList;
import modelo.*;

/**
 * Implementa o controle de dados dos patrimonios
 * 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Sousa Cavalcante
 * @since 2023;
 * @version 1.0;
 */

public class ControlePatrimonio {
	private ArrayList<ItemPatrimonio> patrimonios = new ArrayList<ItemPatrimonio>();
	
	/**
	 * Construtor responsável por pegar a lista de patrimônios presentes na classe {@link Filial}, permitindo que
	 * os métodos dessa classe possam acessar e manipular os patrimônios da {@link Filial} especificada pelo índice.
	 * 
	 * @param controleDados Permite o acesso da Classe {@link ControleDados} para pegar os patrimonios dentro do ArrayList .
	 * @param index	Representa o indice da filial.
	 */

	public ControlePatrimonio(ControleDados controleDados, int index) {
		patrimonios = controleDados.getFilial(index).getPatrimonio();
	}
	
	/**
	 * Adiciona cada patrimônio encontrado na lista patrimonios do controle de patrimônios, utilizando o método add(). 
	 * Dessa forma, o construtor percorre todas as filiais e seus patrimônios e os adiciona à 
	 * lista patrimonios do controle de patrimônios. Isso permite que o controle de patrimônios tenha acesso e possa 
	 * manipular todos os patrimônios presentes nas filiais.
	 * 
	 * @param controleDados Permite o acesso da Classe {@link ControleDados} para verificar ou adicionar um patrimonio dentro do ArrayList
	 */

	public ControlePatrimonio(ControleDados controleDados) {
		for (int i = 0; i < controleDados.getFiliais().size(); i++) {
			for (int j = 0; j < controleDados.getFilial(i).getPatrimonio().size(); j++) {
				patrimonios.add(controleDados.getFilial(i).getPatrimonio().get(j));
			}
		}
	}

	public ArrayList<ItemPatrimonio> getPatrimonios() {
		return patrimonios;
	}

	public int getQtdPatrimonios() {
		return patrimonios.size();
	}

	public void setPatrimonios(ArrayList<ItemPatrimonio> patrimonios) {
		this.patrimonios = patrimonios;
	}
	
	/**
	 * Método responsável por pegar o nome de todas os patrimônios cadastrados para 
	 * armazenar nas listas presentes no pacote view.
	 * 
	 * @return retorna os nomes dos patrimônios.
	 * */
	
	public String[] getNomesPatrimonios() {
		String[] nomes = new String[patrimonios.size()];

		for (int i = 0; i < patrimonios.size(); i++) {
			nomes[i] = patrimonios.get(i).getNomeItem();
		}
		
		return nomes;
	}

}
