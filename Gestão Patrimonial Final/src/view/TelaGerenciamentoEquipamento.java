package view;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.*;

/**
 * Implementa a interface da tela de gerenciamento de equipamento de construção.
 * 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Sousa Cavalcante
 * @since 2023
 * @version 1.0
 */

public class TelaGerenciamentoEquipamento implements ActionListener {
	private JFrame janela = new JFrame("Edicao Equipamento de Construcao");
	private JLabel titulo = new JLabel("Equipamento de Construcao");
	private JLabel nomePatrimonio = new JLabel("Nome Patrimonio:");
	private JTextField nomePatrimonioJTF = new JTextField();
	private JLabel quantidade = new JLabel("Quantidade: ");
	private JTextField quantidadeJTF = new JTextField();
	private JLabel valor = new JLabel("Valor: ");
	private JTextField valorJTF = new JTextField();
	private JLabel marca = new JLabel("Marca: ");
	private JTextField marcaJTF = new JTextField();
	private JLabel peso = new JLabel("Peso: ");
	private JTextField pesoJTF = new JTextField();
	private JLabel anoFabricacao = new JLabel("Ano Fabricacao: ");
	private JTextField anoFabricacaoJTF = new JTextField();
	private JLabel material = new JLabel("Material: ");
	private JTextField materialJTF = new JTextField();
	private JButton excluir = new JButton("Excluir");
	private JButton salvar = new JButton("Salvar");
	private int indicePatrimonioSelecionado;
	private int indiceFilialSelecionada;
	private static ControleDados controleDados;
	
	/**
	 * Cria a tela de gerenciamento de veículos
	 * 
	 * @param controleDados Permite o acesso ao pacote Controle onde fica toda a
	 *                      gerência de dados do projeto.
	 * @param indexFilial   Representa a filial selecionada a partir da
	 *                      {@link TelaGerenciamentoPatrimonio}.
	 * @param index         Representa a posição do patrimônio selecionado.
	 */

	public TelaGerenciamentoEquipamento(ControleDados controleDados, int indexFilial, int index) {
		this.controleDados = controleDados;
		this.indiceFilialSelecionada = indexFilial;
		this.indicePatrimonioSelecionado = index;

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(110, 8, 408, 50);

		nomePatrimonio.setBounds(10, 55, 208, 50);
		nomePatrimonio.setFont(new Font("Arial", Font.BOLD, 15));
		nomePatrimonioJTF.setBounds(150, 65, 280, 30);

		quantidade.setBounds(10, 95, 208, 50);
		quantidade.setFont(new Font("Arial", Font.BOLD, 15));
		quantidadeJTF.setBounds(110, 105, 280, 30);

		valor.setBounds(10, 135, 208, 50);
		valor.setFont(new Font("Arial", Font.BOLD, 15));
		valorJTF.setBounds(60, 145, 280, 30);

		marca.setBounds(10, 175, 208, 50);
		marca.setFont(new Font("Arial", Font.BOLD, 15));
		marcaJTF.setBounds(70, 185, 280, 30);

		peso.setBounds(10, 215, 208, 50);
		peso.setFont(new Font("Arial", Font.BOLD, 15));
		pesoJTF.setBounds(60, 225, 280, 30);

		anoFabricacao.setBounds(10, 255, 208, 50);
		anoFabricacao.setFont(new Font("Arial", Font.BOLD, 15));
		anoFabricacaoJTF.setBounds(140, 265, 280, 30);

		material.setBounds(10, 295, 208, 50);
		material.setFont(new Font("Arial", Font.BOLD, 15));
		materialJTF.setBounds(80, 305, 280, 30);

		salvar.setBounds(50, 355, 150, 40);
		excluir.setBounds(280, 355, 150, 40);

		janela.setLayout(null);

		janela.add(titulo);

		janela.add(nomePatrimonio);
		janela.add(nomePatrimonioJTF);

		janela.add(quantidade);
		janela.add(quantidadeJTF);

		janela.add(valor);
		janela.add(valorJTF);

		janela.add(marca);
		janela.add(marcaJTF);

		janela.add(peso);
		janela.add(pesoJTF);

		janela.add(anoFabricacao);
		janela.add(anoFabricacaoJTF);

		janela.add(material);
		janela.add(materialJTF);

		janela.add(salvar);
		janela.add(excluir);

		janela.setBounds(18, 220, 500, 450);
		janela.setVisible(true);

		salvar.addActionListener(this);
		excluir.addActionListener(this);

		nomePatrimonioJTF
				.setText(controleDados.getFilial(indiceFilialSelecionada).getPatrimonio().get(index).getNomeItem());
		quantidadeJTF.setText(String
				.valueOf(controleDados.getFilial(indiceFilialSelecionada).getPatrimonio().get(index).getQuantidade()));
		valorJTF.setText(
				String.valueOf(controleDados.getFilial(indiceFilialSelecionada).getPatrimonio().get(index).getValor()));
		marcaJTF.setText(controleDados.getFilial(indiceFilialSelecionada).getPatrimonio().get(index).getMarca());
		anoFabricacaoJTF.setText(
				String.valueOf(controleDados.eqpConstrucao(index, indiceFilialSelecionada).getAnoFabricacao()));
		materialJTF.setText(controleDados.eqpConstrucao(index, indiceFilialSelecionada).getMaterial());
		pesoJTF.setText(
				String.valueOf(controleDados.eqpConstrucao(index, indiceFilialSelecionada).getPesoEquipamento()));

	}
	
	/**
	 * Pega os valores cadastrados na {@link TelaCadastroPatrimonio} e permite a edição ou
	 * exclusão dos mesmos através do método editarCadastrarPatrimonioConstrucao presente na classe
	 * ControleDados do pacote controle. Evitando a interação direta entre view e modelo.
	 * 
	 * @param e Parâmetro que define a ação dos botões no método actionPerformed.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvar) {
			if (nomePatrimonioJTF.getText().equals("") || quantidadeJTF.getText().equals("")
					|| valorJTF.getText().equals("") || marcaJTF.getText().equals("") || pesoJTF.getText().equals("")
					|| anoFabricacaoJTF.getText().equals("") || materialJTF.getText().equals("")) {
				JOptionPane.showMessageDialog(salvar, "Todos os campos precisam ser preenchidos!");
			} else {
				String novoNome = nomePatrimonioJTF.getText();
				String novaQuantidade = quantidadeJTF.getText();
				String novoValor = valorJTF.getText();
				String novaMarca = marcaJTF.getText();
				String novoPeso = pesoJTF.getText();
				String novoAnoFabricacao = anoFabricacaoJTF.getText();
				String novoMaterial = materialJTF.getText();
				controleDados.editarCadastrarPatrimonioConstrucao(novoNome, novaQuantidade, novoValor, novaMarca,
						novoPeso, novoAnoFabricacao, novoMaterial, indiceFilialSelecionada,
						indicePatrimonioSelecionado);
				JOptionPane.showMessageDialog(salvar, "Patrimonio atualizado com sucesso!");
				janela.dispose();
			}
		} else if (e.getSource() == excluir) {
			controleDados.removerPatrimonio(indiceFilialSelecionada, indicePatrimonioSelecionado);
			JOptionPane.showMessageDialog(excluir, "Patrimonio removido com sucesso!");
			janela.dispose();
		}
	}

}
