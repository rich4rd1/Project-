package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import controle.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Implementa a interface que gerencia os dados das filiais, permite o cadastro
 * de patrimônio e mostra os patrimonios vinculados a filial na Jlist.
 * 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Souza Cavalcante
 * @since 2023
 * @version 1.0
 */

public class TelaGerenciamentoPatrimonio implements ActionListener, ListSelectionListener {

	private JFrame janela = new JFrame("Gerenciamento de Patrimonios");
	private JLabel titulo = new JLabel("Dados Filial");
	private JLabel nomeFilial = new JLabel("Nome Filial:");
	private JTextField nomeFilialJTF = new JTextField();
	private JLabel cnpj = new JLabel("CNPJ: ");
	private JTextField cnpjJTF = new JTextField();
	private JLabel endereco = new JLabel("Endereco: ");
	private JTextField enderecoJTF = new JTextField();
	private JButton salvar = new JButton("Salvar");
	private JButton excluir = new JButton("Excluir");
	private JList<String> listaPatrimoniosCadastrados;
	private String[] listaPatrimonios;
	private JButton cadastrarPatrimonio = new JButton("Cadastrar Patrimonio");
	private JButton refreshPatrimonio = new JButton("Refresh");
	private static ControleDados controleDados;
	private int indiceFilialSelecionada;
	private int qtdPatrimonios;

	/**
	 * Cria a TelaGerenciamentoPatrimonio
	 * 
	 * @param controleDados Permite o acesso a classe ControleDados por meio do pacote
	 *                      controle onde fica toda a gerência de dados do projeto.
	 * @param index         Gerencia a posição da filial selecionada.
	 */

	public TelaGerenciamentoPatrimonio(ControleDados controleDados, int index) {
		this.indiceFilialSelecionada = index;
		this.controleDados = controleDados;

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

		salvar.setBounds(30, 210, 150, 40);
		excluir.setBounds(300, 210, 150, 40);

		listaPatrimonios = new ControlePatrimonio(controleDados, indiceFilialSelecionada).getNomesPatrimonios();
		listaPatrimoniosCadastrados = new JList<>(listaPatrimonios);
		listaPatrimoniosCadastrados.setBounds(18, 270, 450, 160);
		listaPatrimoniosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaPatrimoniosCadastrados.setVisibleRowCount(10);

		cadastrarPatrimonio.setFont(new Font("Arial", Font.BOLD, 10));
		cadastrarPatrimonio.setBounds(60, 450, 150, 40);
		refreshPatrimonio.setBounds(270, 450, 150, 40);

		janela.setLayout(null);

		janela.add(titulo);
		janela.add(nomeFilial);
		janela.add(nomeFilialJTF);

		janela.add(cnpj);
		janela.add(cnpjJTF);

		janela.add(endereco);
		janela.add(enderecoJTF);

		janela.add(salvar);
		janela.add(excluir);

		janela.add(listaPatrimoniosCadastrados);

		janela.add(cadastrarPatrimonio);
		janela.add(refreshPatrimonio);

		janela.setBounds(18, 140, 500, 550);
		janela.setVisible(true);

		salvar.addActionListener(this);
		excluir.addActionListener(this);
		refreshPatrimonio.addActionListener(this);
		cadastrarPatrimonio.addActionListener(this);
		listaPatrimoniosCadastrados.addListSelectionListener(this);

		nomeFilialJTF.setText(controleDados.getEscritorio().getFiliais().get(index).getNome());
		cnpjJTF.setText(controleDados.getEscritorio().getFiliais().get(index).getCnpj());
		enderecoJTF.setText(controleDados.getEscritorio().getFiliais().get(index).getEndereco());
	}

	/**
	 * Implementa as ações de salvar, excluir, cadastrarPatrimonio e
	 * refreshPatrimonio. Os botões cadastrarPatrimonio e refreshPatrimonio são
	 * respectivos a gerência de patrimônio. Já os botões salvar e excluir são
	 * referentes à gerência da Filial selecionada na Jlist da
	 * {@link TelaGerenciamentoFilial}.
	 * 
	 * @param e Parâmetro que define a ação dos botões no método actionPerformed.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvar) {
			if (nomeFilialJTF.getText().equals("") || cnpjJTF.getText().equals("")
					|| enderecoJTF.getText().equals("")) {
				JOptionPane.showMessageDialog(salvar, "Todos os campos precisam ser preenchidos!");
			} else {
				String novoNome = nomeFilialJTF.getText();
				String novoCNPJ = cnpjJTF.getText();
				String novoEndereco = enderecoJTF.getText();
				controleDados.editarCadastrarFilial(novoNome, novoCNPJ, novoEndereco, indiceFilialSelecionada);
				JOptionPane.showMessageDialog(salvar, "Dados atualizados com sucesso!");
				janela.dispose();
			}
		} else if (e.getSource() == excluir) {
			controleDados.removerFilial(indiceFilialSelecionada);
			JOptionPane.showMessageDialog(excluir, "Filial removida com sucesso!");
			janela.dispose();
		} else if (e.getSource() == cadastrarPatrimonio) {
			qtdPatrimonios = (new ControlePatrimonio(controleDados, indiceFilialSelecionada)).getQtdPatrimonios();
			new TelaCadastroPatrimonio(controleDados, qtdPatrimonios, indiceFilialSelecionada);
		} else if (e.getSource() == refreshPatrimonio) {
			qtdPatrimonios = (new ControlePatrimonio(controleDados, indiceFilialSelecionada)).getQtdPatrimonios();
			listaPatrimoniosCadastrados.setListData(controleDados.getFilial(indiceFilialSelecionada).listarPatrimonio());
			listaPatrimoniosCadastrados.updateUI();
		}
	}
	
	/**
	 * Chama o método verificaPatrimonio presente na classe ControleDados. Sendo que, caso indice do patrimônio selecionado 
	 * já cadastrado seja uma instância de veículo (3), abra a {@link TelaGerenciamentoVeiculo} ou, caso seja uma instância de equipamento
	 * de construção(2), abra a {@link TelaGerenciamentoEquipamento} ou, caso seja uma instância de eletrônico(1), abra a
	 * {@link TelaGerenciamentoEletronico}.
	 * 
	 * @param e Parâmetro que define a ação do método valueChanged.
	 * */

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		int indexPatrimonio = listaPatrimoniosCadastrados.getSelectedIndex();
		if (src == listaPatrimoniosCadastrados && e.getValueIsAdjusting()) {
			if (controleDados.verificaPatrimonio(indexPatrimonio, indiceFilialSelecionada) == 3) {
				new TelaGerenciamentoVeiculo(controleDados, indiceFilialSelecionada,
						listaPatrimoniosCadastrados.getSelectedIndex());
			}
			if (controleDados.verificaPatrimonio(indexPatrimonio, indiceFilialSelecionada) == 2) {
				new TelaGerenciamentoEquipamento(controleDados, indiceFilialSelecionada,
						listaPatrimoniosCadastrados.getSelectedIndex());
			}
			if (controleDados.verificaPatrimonio(indexPatrimonio, indiceFilialSelecionada) == 1) {
				new TelaGerenciamentoEletronico(controleDados, indiceFilialSelecionada,
						listaPatrimoniosCadastrados.getSelectedIndex());
			}
		}
	}

}
