package view;

import controle.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Implementa a interface de cadastro de filial.
 * 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Sousa Cavalcante
 * @since 2023;
 * @version 1.0;
 *
 */

public class TelaCadastroFilial implements ActionListener {

	private JFrame janela = new JFrame("Cadastro Filial");
	private JLabel titulo = new JLabel("Dados Filial");
	private JLabel nomeFilial = new JLabel("Nome Filial:");
	private JTextField nomeFilialJTF = new JTextField();
	private JLabel cnpj = new JLabel("CNPJ: ");
	private JTextField cnpjJTF = new JTextField();
	private JLabel endereco = new JLabel("Endereco: ");
	private JTextField enderecoJTF = new JTextField();
	private JButton cadastrar = new JButton("Cadastrar");
	private static ControleDados controleDados;
	private int index;
	
	/**
	 * @param controleDados permite o acesso a classe ControleDados por meio do pacote 
	 * controle onde fica toda a gerência de dados do projeto
	 * 
	 * @param index Fornece o um inteiro que será usado para verificar o
	 * indice do patrimonio dentro de uma filial, definindo as configuraçoes de tela suas funcionalidades.
	 */

	public TelaCadastroFilial(ControleDados controleDados, int index) {
		this.controleDados = controleDados;
		this.index = index;
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(180, 10, 208, 50);

		nomeFilial.setBounds(10, 75, 208, 50);
		nomeFilial.setFont(new Font("Arial", Font.BOLD, 15));
		nomeFilialJTF.setBounds(100, 85, 280, 30);

		cnpj.setBounds(10, 115, 208, 50);
		cnpj.setFont(new Font("Arial", Font.BOLD, 15));
		cnpjJTF.setBounds(60, 125, 280, 30);

		endereco.setBounds(10, 155, 208, 50);
		endereco.setFont(new Font("Arial", Font.BOLD, 15));
		enderecoJTF.setBounds(90, 165, 280, 30);

		cadastrar.setBounds(160, 210, 150, 40);

		janela.setLayout(null);

		janela.add(titulo);
		janela.add(nomeFilial);
		janela.add(nomeFilialJTF);

		janela.add(cnpj);
		janela.add(cnpjJTF);

		janela.add(endereco);
		janela.add(enderecoJTF);

		janela.add(cadastrar);

		janela.setBounds(510, 465, 500, 300);
		janela.setVisible(true);

		cadastrar.addActionListener(this);
	}
	
	/**
	 * Cadastra uma filial e verifica se os campos foram preencido corretamente
	 * 
	 * @param e Parâmetro que define a ação dos botões no método actionPerformed.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cadastrar) {
			if (nomeFilialJTF.getText().equals("") || cnpjJTF.getText().equals("") || enderecoJTF.getText().equals("")) {
				JOptionPane.showMessageDialog(cadastrar, "Preencha todos os campos!");
			} else  if(!cnpjJTF.getText().matches("[0-9]+")){
				JOptionPane.showMessageDialog(cadastrar, "Preencha o CNPJ corretamente!");
			} else {
				controleDados.editarCadastrarFilial(nomeFilialJTF.getText(), cnpjJTF.getText(), enderecoJTF.getText(),
						index);
				JOptionPane.showMessageDialog(cadastrar, "Dados cadastrados com sucesso!");
				janela.dispose();
			}

		}

	}

}
