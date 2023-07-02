package view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import controle.*;

/**
 * Implementa a interface da tela de gerenciamento de eletrônico.
 * 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Sousa Cavalcante
 * @since 2023
 * @version 1.0
 */

public class TelaGerenciamentoEletronico implements ActionListener {
	private JFrame janela = new JFrame("Edicao Eletronico");
	private JLabel titulo = new JLabel("Eletronico");
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
	private JLabel voltagem = new JLabel("Voltagem: ");
	private JTextField voltagemJTF = new JTextField();
	private JLabel sistema = new JLabel("Sistema: ");
	private JTextField sistemaJTF = new JTextField();
	private JLabel modelo = new JLabel("Modelo: ");
	private JTextField modeloJTF = new JTextField();
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

	public TelaGerenciamentoEletronico(ControleDados controleDados, int indexFilial, int index) {
		this.controleDados = controleDados;
		this.indiceFilialSelecionada = indexFilial;
		this.indicePatrimonioSelecionado = index;

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(190, 8, 208, 50);

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

		voltagem.setBounds(10, 255, 208, 50);
		voltagem.setFont(new Font("Arial", Font.BOLD, 15));
		voltagemJTF.setBounds(90, 265, 280, 30);

		sistema.setBounds(10, 295, 208, 50);
		sistema.setFont(new Font("Arial", Font.BOLD, 15));
		sistemaJTF.setBounds(80, 305, 280, 30);

		modelo.setBounds(10, 335, 208, 50);
		modelo.setFont(new Font("Arial", Font.BOLD, 15));
		modeloJTF.setBounds(80, 345, 280, 30);

		salvar.setBounds(50, 390, 150, 40);
		excluir.setBounds(280, 390, 150, 40);

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

		janela.add(voltagem);
		janela.add(voltagemJTF);

		janela.add(sistema);
		janela.add(sistemaJTF);

		janela.add(modelo);
		janela.add(modeloJTF);

		janela.add(salvar);
		janela.add(excluir);

		janela.setBounds(18, 220, 500, 480);
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
		pesoJTF.setText(String
				.valueOf(controleDados.eqpEquipamentoEletronico(index, indiceFilialSelecionada).getPesoEquipamento()));
		voltagemJTF.setText(
				String.valueOf(controleDados.eqpEquipamentoEletronico(index, indiceFilialSelecionada).getVoltagem()));
		sistemaJTF.setText(
				String.valueOf(controleDados.eqpEquipamentoEletronico(index, indiceFilialSelecionada).getSistema()));
		modeloJTF.setText(
				String.valueOf(controleDados.eqpEquipamentoEletronico(index, indiceFilialSelecionada).getModelo()));

	}
	
	/**
	 * Pega os valores cadastrados na {@link TelaCadastroPatrimonio} e permite a edição ou
	 * exclusão dos mesmos através do método editarCadastrarPatrimonioEletronico presente na classe
	 * ControleDados do pacote controle. Evitando a interação direta entre view e modelo.
	 * 
	 * @param e Parâmetro que define a ação dos botões no método actionPerformed.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvar) {
			// Verifica se todos os campos da JTextField estão preenchidos devidamente
			if (nomePatrimonioJTF.getText().equals("") || quantidadeJTF.getText().equals("")
					|| valorJTF.getText().equals("") || marcaJTF.getText().equals("")
					|| pesoJTF.getText().equals("") || voltagemJTF.getText().equals("")
					|| sistemaJTF.getText().equals("") || modeloJTF.getText().equals("")) {
				JOptionPane.showMessageDialog(salvar, "Todos os campos precisam ser preenchidos!");
			} else {
				String novoNome = nomePatrimonioJTF.getText();
				String novaQuantidade = quantidadeJTF.getText();
				String novoValor = valorJTF.getText();
				String novaMarca = marcaJTF.getText();
				String novoPeso = pesoJTF.getText();
				String novaVoltagem = voltagemJTF.getText();
				String novoSistema = sistemaJTF.getText();
				String modelo = modeloJTF.getText();

				controleDados.editarCadastrarPatrimonioEletronico(novoNome, novaQuantidade, novoValor, novaMarca,
						novoPeso, novaVoltagem, novoSistema, modelo, indiceFilialSelecionada,
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