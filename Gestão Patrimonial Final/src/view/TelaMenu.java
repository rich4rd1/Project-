package view;

import controle.*;
import java.awt.event.*;
import javax.swing.*;
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

public class TelaMenu implements ActionListener {
	private static JFrame janela = new JFrame("Gerencia Patrimonial");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton gerenciarFiliais = new JButton("Gerenciar Filiais");
	private static JButton listarPatrimonios = new JButton("Listar Patrimonios");
	private static ControleDados controleDados = new ControleDados();

	/**
	 * Cria o menu principal do sistema.
	 */

	public TelaMenu() {
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(171, 15, 150, 50);
		gerenciarFiliais.setBounds(140, 90, 208, 50);
		listarPatrimonios.setBounds(140, 160, 208, 50);

		janela.setLayout(null);

		janela.add(titulo);
		janela.add(gerenciarFiliais);
		janela.add(listarPatrimonios);

		janela.setBounds(510, 140, 500, 300);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}

	/**
	 * Instancia os ActionListener para os botões do menu.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		TelaMenu Telamenu = new TelaMenu();
		gerenciarFiliais.addActionListener(Telamenu);
		listarPatrimonios.addActionListener(Telamenu);
	}

	/**
	 * Vai para a tela desejada a partir da ação de clique do botão selecionado.
	 * 
	 * @param e Parâmetro que define a ação dos botões no método actionPerformed.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == gerenciarFiliais) {
			new TelaGerenciamentoFilial(controleDados);
		}
		if (e.getSource() == listarPatrimonios) {
			new TelaBuscaPatrimonio(controleDados);
		}

	}
}
