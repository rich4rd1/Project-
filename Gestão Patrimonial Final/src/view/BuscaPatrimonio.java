package view;

import java.awt.event.*;
import controle.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class BuscaPatrimonio implements ActionListener, ListSelectionListener {
	private JFrame janela = new JFrame("Busca Patrimonio");
	private JLabel buscaPatrimonio = new JLabel("Buscar Patrimonio: ");
	private JTextField buscaPatrimonioJTF = new JTextField();
	private JButton botaoBuscar = new JButton("Buscar");
	private JList<String> listaPatrimoniosVinculados;
	private JScrollPane scrollPane;
	private String[] listaNomesPatrimonios;
	private static ControleDados controleDados;
	private int qtdPatrimonios;

	public BuscaPatrimonio(ControleDados controleDados) {
		this.controleDados = controleDados;

		buscaPatrimonio.setFont(new Font("Arial", Font.BOLD, 15));
		buscaPatrimonio.setBounds(10, 10, 180, 50);
		buscaPatrimonioJTF.setBounds(160, 20, 250, 30);
		botaoBuscar.setBounds(415, 20, 100, 30);

		listaNomesPatrimonios = new ControlePatrimonio(controleDados).getNomesPatrimonios();
		listaPatrimoniosVinculados = new JList<>(listaNomesPatrimonios);
		scrollPane = new JScrollPane(listaPatrimoniosVinculados);
		scrollPane.setBounds(18, 75, 490, 250);
		listaPatrimoniosVinculados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaPatrimoniosVinculados.setVisibleRowCount(10);

		janela.setLayout(null);

		janela.add(buscaPatrimonio);
		janela.add(buscaPatrimonioJTF);
		janela.add(botaoBuscar);
		janela.add(scrollPane);

		janela.setBounds(1000, 140, 540, 385);
		janela.setVisible(true);

		botaoBuscar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoBuscar) {
			// Implemente a lógica para buscar patrimônios
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// Implemente a lógica para lidar com a seleção na lista
	}

}
