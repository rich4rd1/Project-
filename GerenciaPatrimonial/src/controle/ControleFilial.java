package controle;

import java.util.ArrayList;
import modelo.*;

/**
 * Implementa o controle de dados da filial
 * 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Sousa Cavalcante
 * @since 2023;
 * @version 1.0;
 */

public class ControleFilial {
	private ArrayList<Filial> filiais = new ArrayList<Filial>();

	/**
	 *O construtor está inicializando o objeto ControleFilial com a lista de filiais obtida do objeto 
	 *Escritorio presente no objeto ControleDados, permitindo que a classe ControleFilial tenha acesso às filiais 
	 *para realizar operações de controle sobre elas.
	 *
	 *@param controleDados Utilizado para obter informações sobre as filiais do escritório.
	 **/
	
	public ControleFilial(ControleDados controleDados) {
		filiais = controleDados.getEscritorio().getFiliais();
	}

	public ArrayList<Filial> getFiliais() {
		return filiais;
	}

	public int getQtdFiliais() {
		return filiais.size();
	}

	public void setFiliais(ArrayList<Filial> filiais) {
		this.filiais = filiais;
	}
	
	/**
	 * Método responsável por pegar o nome de todas as filiais cadastradas para 
	 * armazenar na lista presente no pacote view.
	 * 
	 * @return retorna os nomes das filiais.
	 * */
	
	public String[] getNomesFiliais() {
		String[] nomes = new String[filiais.size()];

		for (int i = 0; i < filiais.size(); i++) {
			nomes[i] = filiais.get(i).getNome();
		}

		return nomes;
	}

}