package view;

import controle.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Implementa a interface que permite o cadastro e a listagem de filiais.
 * 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Souza Cavalcante
 * @since 2023
 * @version 1.0
 */

public class TelaGerenciamentoFilial implements ActionListener, ListSelectionListener {
	private JFrame janela = new JFrame("Gerenciamento Filiais");
	private JLabel titulo = new JLabel("Filiais Cadastradas");
	private JButton cadastrarFilial = new JButton("Cadastrar Filial");
	private JButton refreshFilial = new JButton("Refresh");
	private JList<String> listaFiliaisCadastradas;
	private String[] listaFiliais;
	private static ControleDados controleDados;
	private int qtdFiliais;
	
	/**
	 * Constrói a tela de gerenciamento de filial. Definindo todas as configurações,
	 * implementando os botões na tela e suas funcionalidades.
	 * 
	 * @param dados Permite o acesso a classe Dados por meio do pacote Controle onde
	 * fica toda a gerência de dados do projeto.
	 * */

	public TelaGerenciamentoFilial(ControleDados dados) {
		controleDados = dados;
		listaFiliais = new ControleFilial(dados).getNomesFiliais();
		listaFiliaisCadastradas = new JList<String>(listaFiliais);

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(105, 10, 200, 50);
		listaFiliaisCadastradas.setBounds(15, 70, 355, 160);
		listaFiliaisCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaFiliaisCadastradas.setVisibleRowCount(10);
		cadastrarFilial.setFont(new Font("Arial", Font.BOLD, 13));
		cadastrarFilial.setBounds(15, 250, 130, 40);
		refreshFilial.setFont(new Font("Arial", Font.BOLD, 13));
		refreshFilial.setBounds(240, 250, 130, 40);

		janela.setLayout(null);

		janela.add(titulo);
		janela.add(listaFiliaisCadastradas);
		janela.add(cadastrarFilial);
		janela.add(refreshFilial);

		janela.setBounds(562, 435, 400, 350);
		janela.setVisible(true);

		cadastrarFilial.addActionListener(this);
		refreshFilial.addActionListener(this);
		listaFiliaisCadastradas.addListSelectionListener(this);
	}

	/**
	 * Método responsável por permitir o acesso a {@link TelaCadastroFilial} e atualizar a lista de filiais cadastradas.
	 * 
	 * @param e Parâmetro que define a ação dos botões da tela no método actionPerformed.
	 * */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cadastrarFilial) {
			qtdFiliais = (new ControleFilial(controleDados)).getQtdFiliais();
			new TelaCadastroFilial(controleDados, qtdFiliais);
		} else if (e.getSource() == refreshFilial) {
			qtdFiliais = (new ControleFilial(controleDados)).getQtdFiliais();
			listaFiliaisCadastradas.setListData(new ControleFilial(controleDados).getNomesFiliais());
			listaFiliaisCadastradas.updateUI();
		}
	}
	
	/**
	 * Método que adiciona as filiais cadastradas na {@link TelaCadastroFilial} na JList dessa interface.
	 * 
	 * @param e Parâmetro que define a ação dos botões da tela no método valueChanged.
	 * */

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		if (e.getValueIsAdjusting() && src == listaFiliaisCadastradas) {
			new TelaGerenciamentoPatrimonio(controleDados, listaFiliaisCadastradas.getSelectedIndex());
		}
	}
}
