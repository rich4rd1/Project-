package view;

import java.awt.event.*;
import controle.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Implementa a interface de menu do sistema.
 * 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Sousa Cavalcante
 * @since 2023
 * @version 1.0
 *
 */

public class TelaBuscaPatrimonio implements ActionListener {
	private JFrame janela = new JFrame("Busca Patrimonio");
	private JLabel buscaPatrimonio = new JLabel("Buscar Patrimonio: ");
	private JTextField buscaPatrimonioJTF = new JTextField();
	private JButton botaoBuscar = new JButton("Buscar");
	private JButton botaoRefresh = new JButton("Refresh");
	private JList<String> listaPatrimoniosVinculados;
	private JScrollPane scrollPane;
	private String[] listaNomesPatrimonios;
	private ControleDados controleDados;
	private int qtdPatrimonios;

	/**
	 * Define as configuraçoes de tela suas funcionalidades.
	 * 
	 * @param controleDados permite o acesso a classe ControleDados por meio do pacote
	 * controle onde fica toda a gerência de dados do projeto
	 * */
	
	public TelaBuscaPatrimonio(ControleDados controleDados) {
		this.controleDados = controleDados;
		buscaPatrimonio.setFont(new Font("Arial", Font.BOLD, 15));
		buscaPatrimonio.setBounds(10, 10, 180, 50);
		buscaPatrimonioJTF.setBounds(160, 20, 250, 30);
		botaoBuscar.setBounds(415, 20, 100, 30);
		botaoRefresh.setBounds(210, 330, 100, 40);

		listaNomesPatrimonios = new ControlePatrimonio(controleDados).getNomesPatrimonios();
		listaPatrimoniosVinculados = new JList<>(listaNomesPatrimonios);
		scrollPane = new JScrollPane(listaPatrimoniosVinculados);
		scrollPane.setBounds(18, 75, 490, 250);
		janela.setLayout(null);

		janela.add(buscaPatrimonio);
		janela.add(buscaPatrimonioJTF);
		janela.add(botaoBuscar);
		janela.add(botaoRefresh);
		janela.add(scrollPane);

		janela.setBounds(1000, 140, 540, 420);
		janela.setVisible(true);

		botaoBuscar.addActionListener(this);
		botaoRefresh.addActionListener(this);
	}
	
	/**
	 * Dentro do actionPerformed, o botaoBuscar recebe a instância de um vetor de teste que recebe o 
	 * método buscarPatrimonio e, com base nesse método, 
	 * faz a busca do patrimônio comparando o nome inserido chamando, em conjunto, o método verificaPatrimonio nas posições do
	 * vetor para checar a instância do patrimônio pesquisado. Sendo que, a posição [1] do vetor é o index do patrimônio
	 * pesquisado e a posição [0] é o index da filial onde estão os patrimônio cadastrados.
	 * Já o botaoRefresh atualiza a lista de todos os patrimônios.
	 * 
	 * @param e Parâmetro que define a ação dos botões no método actionPerformed.
	 * */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoBuscar) {
			String nomeSelecionado = buscaPatrimonioJTF.getText();
			int teste[] = controleDados.buscarPatrimonio(nomeSelecionado);
			if (teste[0] != -1 && teste[1] != -1) {
				if (controleDados.verificaPatrimonio(teste[1], teste[0]) == 3) {
					new TelaGerenciamentoVeiculo(controleDados, teste[0], teste[1]);
				}
				if (controleDados.verificaPatrimonio(teste[1], teste[0]) == 2) {
					new TelaGerenciamentoEquipamento(controleDados, teste[0], teste[1]);
				}
				if (controleDados.verificaPatrimonio(teste[1], teste[0]) == 1) {
					new TelaGerenciamentoEletronico(controleDados, teste[0], teste[1]);
				}
			} else {
				JOptionPane.showMessageDialog(botaoBuscar, "Patrimonio nao encontrado");
			}
		} else if (e.getSource() == botaoRefresh) {
			qtdPatrimonios = (new ControlePatrimonio(controleDados).getQtdPatrimonios());
			listaPatrimoniosVinculados.setListData(new ControlePatrimonio(controleDados).getNomesPatrimonios());
			listaPatrimoniosVinculados.updateUI();
		}
	}

}
