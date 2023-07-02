package testes;

import controle.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Teste {
	/**
	 * Realiza os testes para verificar se os campos do cadastro de filiais
	 * foram respeitados.
	 */
	@Test
	void testEditarCadastrarFilial() {
		ControleDados d = new ControleDados();
		String nomeFilial = "Filial1";
		String cnpjFilialerrado = "123.456.789/0001-12";
		String cnpjFilialcorreto = "1234567891234567";
		String enderecoFilial = "Endereco1";
		int index = 1;

		assertTrue(d.editarCadastrarFilial(nomeFilial, cnpjFilialcorreto, enderecoFilial, index));
		assertFalse(d.editarCadastrarFilial(nomeFilial, cnpjFilialerrado, enderecoFilial, index));

	}

	/**
	 * Realiza os testes para verificar se os campos do cadastro e edição de veiculo
	 * foram respeitados, alem de verificar se os patrimonios cadastrados estão
	 * respeitando os castings da clase de veiculo.
	 */
	@Test
	void testEditarCadastrarPatrimonioVeiculo() {
		ControleDados d = new ControleDados();
		String nome = "Veiculo0";
		String quantidade = "0";
		String quantidadeErrado = "um";
		String valor = "0";
		String valorErrado = "zero";
		String marca = "Nissan";
		String marcaErrada = "1346";
		String tipoVeiculo = "pesado";
		String tipoVeiculoErrado = "pesado";
		String cor = "azul";
		String corErrada = "#156741d";
		String qtdPortas = "2";
		String qtdPortasErrado = "duas";
		int index = 0;

		assertTrue(d.editarCadastrarPatrimonioVeiculo(nome, quantidade, valor, marca, tipoVeiculo, cor, qtdPortas,
				index, index));
		assertFalse(d.editarCadastrarPatrimonioVeiculo(nome, quantidadeErrado, valorErrado, marcaErrada,
				tipoVeiculoErrado, corErrada, qtdPortasErrado, index, index));

	}

	/**
	 * Realiza os testes para verificar se os campos do cadastro e edição de equipamento de construção
	 * foram respeitados, alem de verificar se os patrimonios cadastrados estão
	 * respeitando os castings da classe de equipamentoConstrucao.
	 */
	@Test
	void testEditarCadastrarPatrimonioConstrucao() {
		ControleDados d = new ControleDados();
		String nome = "Equipamento0";
		String quantidade = "1";
		String quantidadeErrada = "um";
		String valor = "2502";
		String valorErrado = "dois mil";
		String marca = "Marca2";
		String marcaErrado = "2";
		String peso = "0";
		String pesoErrado = "zero";
		String anoFabricacao = "2010";
		String anoFabricacaoErrado = "dois mil e dez";
		String material = "material0";
		String materialErrado = "0";
		int index = 2;
		assertTrue(d.editarCadastrarPatrimonioConstrucao(nome, quantidade, valor, marca, peso, anoFabricacao, material,
				index, index));
		assertFalse(d.editarCadastrarPatrimonioConstrucao(nome, quantidadeErrada, valorErrado, marcaErrado, pesoErrado,
				anoFabricacaoErrado, materialErrado, index, index));
	}

		/**
	 * Realiza os testes para verificar se os campos do cadastro e edição de patrimonio eletronico
	 * foram respeitados, alem de verificar se os patrimonios cadastrados estão
	 * respeitando os castings da classe EquipamentoEletronico.
	 */
	@Test
	void testEditarCadastrarPatrimonioEletronico() {
		ControleDados d = new ControleDados();
		String nome = "Eletronioco0";
		String nomeErrado = "12315";
		String quantidade = "1";
		String quantidadeErrado = "um";
		String valor = "2501.0";
		String valorErrado = "0";
		String marca = "marca1";
		String marcaErrado = "13245";
		String peso = "0";
		String pesoErrado = "0";
		String voltagem = "220";
		String voltagemErrado = "0";
		String sistema = "sistema0";
		String sistemaErrado = "13456";
		String modelo = "modelo0";
		String modeloErrado = "1325";
		int index = 1;

		assertTrue(d.editarCadastrarPatrimonioEletronico(nome, quantidade, valor, marca, peso, voltagem, sistema,
				modelo, index, index));
		assertFalse(d.editarCadastrarPatrimonioEletronico(nomeErrado, quantidadeErrado, valorErrado, marcaErrado,
				pesoErrado, voltagemErrado, sistemaErrado, modeloErrado, index, index));
	}
}
