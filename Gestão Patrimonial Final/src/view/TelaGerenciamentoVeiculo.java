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
 * Implementa a interface da tela de gerenciamento de veiculo.
 * 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Sousa Cavalcante
 * @since 2023;
 * @version 1.0;
 */

public class TelaGerenciamentoVeiculo implements ActionListener {
	private JFrame janela = new JFrame("Edicao Veiculo");
	private JLabel titulo = new JLabel("Veiculo");
	private JLabel nomePatrimonio = new JLabel("Nome Patrimonio:");
	private JTextField nomePatrimonioJTF = new JTextField();
	private JLabel quantidade = new JLabel("Quantidade: ");
	private JTextField quantidadeJTF = new JTextField();
	private JLabel valor = new JLabel("Valor: ");
	private JTextField valorJTF = new JTextField();
	private JLabel marca = new JLabel("Marca: ");
	private JTextField marcaJTF = new JTextField();
	private JLabel tipoVeiculo = new JLabel("Tipo Veiculo: ");
	private JTextField tipoVeiculoJTF = new JTextField();
	private JLabel corVeiculo = new JLabel("Cor: ");
	private JTextField corVeiculoJTF = new JTextField();
	private JLabel quantidadePortas = new JLabel("Quantidade de Portas: ");
	private JTextField quantidadePortasJTF = new JTextField();
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

	public TelaGerenciamentoVeiculo(ControleDados controleDados, int indexFilial, int index) {
		this.controleDados = controleDados;
		this.indiceFilialSelecionada = indexFilial;
		this.indicePatrimonioSelecionado = index;

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(200, 0, 208, 50);

		nomePatrimonio.setBounds(10, 45, 208, 50);
		nomePatrimonio.setFont(new Font("Arial", Font.BOLD, 15));
		nomePatrimonioJTF.setBounds(150, 55, 280, 30);

		quantidade.setBounds(10, 85, 208, 50);
		quantidade.setFont(new Font("Arial", Font.BOLD, 15));
		quantidadeJTF.setBounds(110, 95, 280, 30);

		valor.setBounds(10, 125, 208, 50);
		valor.setFont(new Font("Arial", Font.BOLD, 15));
		valorJTF.setBounds(60, 135, 280, 30);

		marca.setBounds(10, 165, 208, 50);
		marca.setFont(new Font("Arial", Font.BOLD, 15));
		marcaJTF.setBounds(70, 175, 280, 30);

		tipoVeiculo.setBounds(10, 205, 208, 50);
		tipoVeiculo.setFont(new Font("Arial", Font.BOLD, 15));
		tipoVeiculoJTF.setBounds(115, 215, 280, 30);

		corVeiculo.setBounds(10, 245, 208, 50);
		corVeiculo.setFont(new Font("Arial", Font.BOLD, 15));
		corVeiculoJTF.setBounds(50, 255, 280, 30);

		quantidadePortas.setBounds(10, 285, 208, 50);
		quantidadePortas.setFont(new Font("Arial", Font.BOLD, 15));
		quantidadePortasJTF.setBounds(185, 295, 280, 30);

		salvar.setBounds(50, 350, 150, 40);
		excluir.setBounds(280, 350, 150, 40);

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

		janela.add(tipoVeiculo);
		janela.add(tipoVeiculoJTF);

		janela.add(corVeiculo);
		janela.add(corVeiculoJTF);

		janela.add(quantidadePortas);
		janela.add(quantidadePortasJTF);

		janela.add(salvar);
		janela.add(excluir);

		janela.setBounds(18, 220, 500, 450);
		janela.setVisible(true);

		salvar.addActionListener(this);
		excluir.addActionListener(this);

		// Preenche os JTextField's com os valores cadastrados na TelaCadastroVeiculo

		nomePatrimonioJTF
				.setText(controleDados.getFilial(indiceFilialSelecionada).getPatrimonio().get(index).getNomeItem());
		quantidadeJTF.setText(String
				.valueOf(controleDados.getFilial(indiceFilialSelecionada).getPatrimonio().get(index).getQuantidade()));
		valorJTF.setText(
				String.valueOf(controleDados.getFilial(indiceFilialSelecionada).getPatrimonio().get(index).getValor()));
		marcaJTF.setText(controleDados.getFilial(indiceFilialSelecionada).getPatrimonio().get(index).getMarca());
		tipoVeiculoJTF.setText(controleDados.veiculo(index, indiceFilialSelecionada).getTipoVeiculo());
		corVeiculoJTF.setText(controleDados.veiculo(index, indiceFilialSelecionada).getCor());
		quantidadePortasJTF
				.setText(String.valueOf(controleDados.veiculo(index, indiceFilialSelecionada).getQtdPortas()));
	}

	/**
	 * Pega os valores cadastrados na {@link TelaCadastroPatrimonio} e permite a edição ou
	 * exclusão dos mesmos através do método editarCadastrarPatrimonioVeiculo presente na classe
	 * ControleDados do pacote controle. Evitando o contato direto entre view e modelo.
	 * 
	 * @param e Parâmetro que define a ação dos botões no método actionPerformed.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvar) {
			// Verifica se todos os campos da JTextField estão preenchidos devidamente
			if (nomePatrimonioJTF.getText().equals("") || quantidadeJTF.getText().equals("")
					|| valorJTF.getText().equals("") || marcaJTF.getText().equals("")
					|| tipoVeiculoJTF.getText().equals("") || corVeiculoJTF.getText().equals("")
					|| quantidadePortasJTF.getText().equals("")) {
				JOptionPane.showMessageDialog(salvar, "Todos os campos precisam ser preenchidos!");
			} else {
				String novoNome = nomePatrimonioJTF.getText();
				String novaQuantidade = quantidadeJTF.getText();
				String novoValor = valorJTF.getText();
				String novaMarca = marcaJTF.getText();
				String novoTipoVeiculo = tipoVeiculoJTF.getText();
				String novaCorVeiculo = corVeiculoJTF.getText();
				String novaQtdPortas = quantidadePortasJTF.getText();
				controleDados.editarCadastrarPatrimonioVeiculo(novoNome, novaQuantidade, novoValor, novaMarca,
						novoTipoVeiculo, novaCorVeiculo, novaQtdPortas, indiceFilialSelecionada,
						indicePatrimonioSelecionado);
				JOptionPane.showMessageDialog(salvar, "Patrimonio atualizado com sucesso!");
				janela.dispose();
			}
			// Remove o patrimonio selecionado
		} else if (e.getSource() == excluir) {
			controleDados.removerPatrimonio(indiceFilialSelecionada, indicePatrimonioSelecionado);
			JOptionPane.showMessageDialog(excluir, "Patrimonio removido com sucesso!");
			janela.dispose();
		}
	}
}
