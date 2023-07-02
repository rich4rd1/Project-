package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import controle.*;

import java.awt.*;

/**
 * Implementa a interface de cadastro de patrimônio.
 * 
 * @author Paulo Henrique Melo de Souza
 * @author Kauã Richard de Sousa Cavalcante
 * @since 2023
 * @version 1.0
 * */

public class TelaCadastroPatrimonio implements ActionListener {

	private JFrame janela = new JFrame("Cadastro Patrimonio");
	private JPanel container = new JPanel();
	private JLabel titulo = new JLabel("Dados Patrimonio");
	private JButton botaoVeiculo = new JButton("Veiculo");
	private JButton botaoEletronico = new JButton("Eletronico");
	private JButton botaoEquipamento = new JButton("Equipamento");
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
	private JLabel tipoVeiculo = new JLabel("Tipo Veiculo: ");
	private JTextField tipoVeiculoJTF = new JTextField();
	private JLabel corVeiculo = new JLabel("Cor: ");
	private JTextField corVeiculoJTF = new JTextField();
	private JLabel quantidadePortas = new JLabel("Quantidade de Portas: ");
	private JTextField quantidadePortasJTF = new JTextField();
	private JLabel anoFabricacao = new JLabel("Ano Fabricacao: ");
	private JTextField anoFabricacaoJTF = new JTextField();
	private JLabel material = new JLabel("Material: ");
	private JTextField materialJTF = new JTextField();
	private JButton cadastrar = new JButton("Cadastrar");
	private static ControleDados controleDados;
	private int indicePatrimonio;
	private int patrimonio;
	private int index;
	private int indexFilial;
	
	/**
	 * Método que define as configurações iniciais de tela. Nesse método, é feito um switch case,
	 * onde cada caso representa uma tela de cadastro de patrimônio. Utilizando os métodos removeAll, revalidate e repaint, é
	 * possível reaproveitar a mesma tela para cadastrar os três tipos de patrimônios
	 * 
	 * 
	 * @param pos Posição indicada do switch case.
	 * @param posicao Posição utilizada para chamar o método no actionPerformed.
	 */

	public void cadastroPatrimonio(int pos, int posicao) {
		patrimonio = pos;
		indicePatrimonio = posicao;
		container.removeAll();
		container.revalidate();
		container.repaint();
		container.setBounds(0, 140, 500, 450);
		switch (pos) {
		case 1:
			nomePatrimonio.setBounds(10, 5, 208, 50);
			nomePatrimonio.setFont(new Font("Arial", Font.BOLD, 15));
			nomePatrimonioJTF.setBounds(150, 15, 280, 30);

			quantidade.setBounds(10, 45, 208, 50);
			quantidade.setFont(new Font("Arial", Font.BOLD, 15));
			quantidadeJTF.setBounds(110, 55, 280, 30);

			valor.setBounds(10, 85, 208, 50);
			valor.setFont(new Font("Arial", Font.BOLD, 15));
			valorJTF.setBounds(60, 95, 280, 30);

			marca.setBounds(10, 125, 208, 50);
			marca.setFont(new Font("Arial", Font.BOLD, 15));
			marcaJTF.setBounds(70, 135, 280, 30);

			tipoVeiculo.setBounds(10, 165, 208, 50);
			tipoVeiculo.setFont(new Font("Arial", Font.BOLD, 15));
			tipoVeiculoJTF.setBounds(115, 175, 280, 30);

			corVeiculo.setBounds(10, 205, 208, 50);
			corVeiculo.setFont(new Font("Arial", Font.BOLD, 15));
			corVeiculoJTF.setBounds(50, 215, 280, 30);

			quantidadePortas.setBounds(10, 245, 208, 50);
			quantidadePortas.setFont(new Font("Arial", Font.BOLD, 15));
			quantidadePortasJTF.setBounds(185, 255, 280, 30);

			container.add(nomePatrimonio);
			container.add(nomePatrimonioJTF);

			container.add(quantidade);
			container.add(quantidadeJTF);

			container.add(valor);
			container.add(valorJTF);

			container.add(marca);
			container.add(marcaJTF);

			container.add(tipoVeiculo);
			container.add(tipoVeiculoJTF);

			container.add(corVeiculo);
			container.add(corVeiculoJTF);

			container.add(quantidadePortas);
			container.add(quantidadePortasJTF);

			break;

		case 2:
			nomePatrimonio.setBounds(10, 5, 208, 50);
			nomePatrimonio.setFont(new Font("Arial", Font.BOLD, 15));
			nomePatrimonioJTF.setBounds(150, 15, 280, 30);

			quantidade.setBounds(10, 45, 208, 50);
			quantidade.setFont(new Font("Arial", Font.BOLD, 15));
			quantidadeJTF.setBounds(110, 55, 280, 30);

			valor.setBounds(10, 85, 208, 50);
			valor.setFont(new Font("Arial", Font.BOLD, 15));
			valorJTF.setBounds(60, 95, 280, 30);

			marca.setBounds(10, 125, 208, 50);
			marca.setFont(new Font("Arial", Font.BOLD, 15));
			marcaJTF.setBounds(70, 135, 280, 30);

			peso.setBounds(10, 165, 208, 50);
			peso.setFont(new Font("Arial", Font.BOLD, 15));
			pesoJTF.setBounds(60, 175, 280, 30);

			voltagem.setBounds(10, 205, 208, 50);
			voltagem.setFont(new Font("Arial", Font.BOLD, 15));
			voltagemJTF.setBounds(90, 215, 280, 30);

			sistema.setBounds(10, 245, 208, 50);
			sistema.setFont(new Font("Arial", Font.BOLD, 15));
			sistemaJTF.setBounds(80, 255, 280, 30);

			modelo.setBounds(10, 285, 208, 50);
			modelo.setFont(new Font("Arial", Font.BOLD, 15));
			modeloJTF.setBounds(80, 295, 280, 30);

			container.add(nomePatrimonio);
			container.add(nomePatrimonioJTF);

			container.add(quantidade);
			container.add(quantidadeJTF);

			container.add(valor);
			container.add(valorJTF);

			container.add(marca);
			container.add(marcaJTF);

			container.add(peso);
			container.add(pesoJTF);

			container.add(voltagem);
			container.add(voltagemJTF);

			container.add(sistema);
			container.add(sistemaJTF);

			container.add(modelo);
			container.add(modeloJTF);

			break;

		case 3:

			nomePatrimonio.setBounds(10, 5, 208, 50);
			nomePatrimonio.setFont(new Font("Arial", Font.BOLD, 15));
			nomePatrimonioJTF.setBounds(150, 15, 280, 30);

			quantidade.setBounds(10, 45, 208, 50);
			quantidade.setFont(new Font("Arial", Font.BOLD, 15));
			quantidadeJTF.setBounds(110, 55, 280, 30);

			valor.setBounds(10, 85, 208, 50);
			valor.setFont(new Font("Arial", Font.BOLD, 15));
			valorJTF.setBounds(60, 95, 280, 30);

			marca.setBounds(10, 125, 208, 50);
			marca.setFont(new Font("Arial", Font.BOLD, 15));
			marcaJTF.setBounds(70, 135, 280, 30);

			peso.setBounds(10, 165, 208, 50);
			peso.setFont(new Font("Arial", Font.BOLD, 15));
			pesoJTF.setBounds(60, 175, 280, 30);

			anoFabricacao.setBounds(10, 205, 208, 50);
			anoFabricacao.setFont(new Font("Arial", Font.BOLD, 15));
			anoFabricacaoJTF.setBounds(140, 215, 280, 30);

			material.setBounds(10, 245, 208, 50);
			material.setFont(new Font("Arial", Font.BOLD, 15));
			materialJTF.setBounds(80, 255, 280, 30);

			container.add(nomePatrimonio);
			container.add(nomePatrimonioJTF);

			container.add(quantidade);
			container.add(quantidadeJTF);

			container.add(valor);
			container.add(valorJTF);

			container.add(marca);
			container.add(marcaJTF);

			container.add(peso);
			container.add(pesoJTF);

			container.add(anoFabricacao);
			container.add(anoFabricacaoJTF);

			container.add(material);
			container.add(materialJTF);

		}
	}
	
	/**
	 * Constrói a tela de cadastro de patrimonio no geral
	 * 
	 * @param controleDados Permite o acesso a classe ControleDados por meio do pacote controle onde 
	 * fica toda a gerência de dados do projeto.
	 * @param index Utilizado para cadastrar o patrimônio na posição desejada.
	 * @param indexFilial Cadastra o patrimônio no respectivo indice da filial selecionado na {@link TelaGerenciamentoFilial}.
	 * */

	public TelaCadastroPatrimonio(ControleDados controleDados, int index, int indexFilial) {
		this.index = index;
		this.indexFilial = indexFilial;
		this.controleDados = controleDados;
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(150, 10, 208, 50);
		botaoVeiculo.setBounds(5, 80, 150, 40);
		botaoEletronico.setBounds(170, 80, 150, 40);
		botaoEquipamento.setBounds(330, 80, 150, 40);
		cadastrar.setBounds(160, 600, 150, 40);

		janela.add(titulo);
		janela.add(botaoVeiculo);
		janela.add(botaoEletronico);
		janela.add(botaoEquipamento);
		janela.add(cadastrar);

		janela.setLayout(null);
		container.setLayout(null);

		janela.add(container);

		janela.setBounds(18, 140, 500, 700);
		janela.setVisible(true);

		botaoVeiculo.addActionListener(this);
		botaoEletronico.addActionListener(this);
		botaoEquipamento.addActionListener(this);
		cadastrar.addActionListener(this);

	}
	
	/**
	 * Método actionPerformed que pega os atributos nome, quantidade, valor e 
	 * marca e adiciona ao respectivo método na ControleDados
	 * através da chamada do método cadastrarPatrimonio. 
	 * Define qual janela de cadastro abrir a partir do valor retornado definido na
	 * funçao de cima. Já definindo o indice do patrimonio e o tipo dele.
	 * 
	 * 
	 * @param Parâmetro que define a ação dos botões no método actionPerformed.
	 * */

	public void actionPerformed(ActionEvent e) {
		String nome = nomePatrimonioJTF.getText();
		String quantidade = quantidadeJTF.getText();
		String valor = valorJTF.getText();
		String marca = marcaJTF.getText();

		if (e.getSource() == botaoVeiculo) {
			cadastroPatrimonio(1, indicePatrimonio);
		} else if (e.getSource() == botaoEletronico) {
			cadastroPatrimonio(2, indicePatrimonio);
		} else if (e.getSource() == botaoEquipamento) {
			cadastroPatrimonio(3, indicePatrimonio);
		} else if (e.getSource() == cadastrar) {
			cadastrarPatrimonio(nome, quantidade, valor, marca);
		}
	}
	
	/**
	 * Cadastra um patrimônio e verifica se os campos estão sendo preenchidos corretamente.
	 * Caso patrimõnio seja igual a 1, os seguintes atributos: tipoVeiculo, cor e qtdPortas.
	 * Caso patrimonio seja igual a 2, recebe os seguintes atributos: pesoEletronico, voltagem
	 * sistema, modelo. Caso o patrimônio seja igual a 3, recebe os seguintes atributos: pesoEquipamento
	 * anoFabricacao, material. Todos recebem os atributos nome, quantidade, valor e marca.
	 * 
	 * @param nome Nome do patrimônio.
	 * @param quantidade Quantidade do patrimônio.
	 * @param valor Valor do patrimônio.
	 * @marca marca Marca do patrimônio.
	 * */

	private void cadastrarPatrimonio(String nome, String quantidade, String valor, String marca) {
		if (patrimonio == 1) {
			String tipo = tipoVeiculoJTF.getText();
			String cor = corVeiculoJTF.getText();
			String quantidadePortas = quantidadePortasJTF.getText();
			if (nome.equals("") || quantidade.equals("") || valor.equals("") || marca.equals("") || tipo.equals("")
					|| cor.equals("") || quantidadePortas.equals("")) {
				JOptionPane.showMessageDialog(cadastrar, "Preencha todos os campos!");
			} else if (!quantidade.matches("[0-9]+") || !valor.matches("[-+]?[0-9]*\\.?[0-9]*")
					|| !quantidadePortas.matches("[0-9]+")) {
				JOptionPane.showMessageDialog(cadastrar,
						"Preencha os campos de quantidade, valor e quantidade de portas corretamente!");
			} else {
				controleDados.editarCadastrarPatrimonioVeiculo(nome, quantidade, valor, marca, tipo, cor,
						quantidadePortas, indexFilial, index);
				JOptionPane.showMessageDialog(cadastrar, "Veiculo cadastrado com sucesso!");
				janela.dispose();
			}

		} else if (patrimonio == 2) {
			String pesoEletronico = pesoJTF.getText();
			String voltagem = voltagemJTF.getText();
			String sistema = sistemaJTF.getText();
			String modelo = modeloJTF.getText();
			if (nome.equals("") || quantidade.equals("") || valor.equals("") || marca.equals("")
					|| pesoEletronico.equals("") || voltagem.equals("") || sistema.equals("") || modelo.equals("")) {
				JOptionPane.showMessageDialog(cadastrar, "Preencha todos os campos!");
			} else if (!quantidade.matches("[0-9]+") || !valor.matches("[-+]?[0-9]*\\.?[0-9]*")
					|| !pesoEletronico.matches("[-+]?[0-9]*\\.?[0-9]*") || !voltagem.matches("[-+]?[0-9]*\\.?[0-9]*")) {
				JOptionPane.showMessageDialog(cadastrar, "Preencha os campos de quantidade, valor, peso e voltagem corretamente!");
			} else {
				controleDados.editarCadastrarPatrimonioEletronico(nome, quantidade, valor, marca, pesoEletronico,
						voltagem, sistema, modelo, indexFilial, index);
				JOptionPane.showMessageDialog(cadastrar, "Eletronico cadastrado com sucesso!");
				janela.dispose();
			}
			
		} else if (patrimonio == 3) {
			String pesoEquipamento = pesoJTF.getText();
			String anoFabricacao = anoFabricacaoJTF.getText();
			String material = materialJTF.getText();
			if (nome.equals("") || quantidade.equals("") || valor.equals("") || marca.equals("")
					|| pesoEquipamento.equals("") || material.equals("") || anoFabricacao.equals("")) {
				JOptionPane.showMessageDialog(cadastrar, "Preencha todos os campos!");
			} else if (!quantidade.matches("[0-9]+") || !valor.matches("[-+]?[0-9]*\\.?[0-9]*")
					|| !pesoEquipamento.matches("[-+]?[0-9]*\\.?[0-9]*") || !anoFabricacao.matches("[0-9]+")) {
				JOptionPane.showMessageDialog(cadastrar, "Preencha os campos de quantidade, valor, peso e ano de fabricacao corretamente!");
			} else {
				controleDados.editarCadastrarPatrimonioConstrucao(nome, quantidade, valor, marca, pesoEquipamento,
						anoFabricacao, material, indexFilial, index);
				JOptionPane.showMessageDialog(cadastrar, "Equipamento cadastrado com sucesso!");
				janela.dispose();
			}

		}
	}
}
