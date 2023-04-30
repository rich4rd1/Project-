import java.util.ArrayList;

public class Filial {
	private String nome;
	private String cnpj;
	private String endereco;
	private ArrayList<ItemPatrimonio> patrimonio = new ArrayList<ItemPatrimonio>();

	public Filial(String nome, String cnpj, String endereco, ArrayList<ItemPatrimonio> patrimonio) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.patrimonio = patrimonio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<ItemPatrimonio> getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(ArrayList<ItemPatrimonio> patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String toString() {
		return "\nNOME FILIAL: " + nome + "\nCNPJ: " + cnpj + "\nENDERECO: " + endereco + "\n";
	}
	
	

}
