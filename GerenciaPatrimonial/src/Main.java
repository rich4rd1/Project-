
public class Main {
	public static void main(String[] arg) {
		Filial filial1 = new Filial("SAConstrucao", "12345678912345", "QR5 Conj C 46, Brasilia-DF", null);
		EquipamentoConstrucao patrimonio1 = new EquipamentoConstrucao("Furadeira", 2, 750, "Borch", 1.5);
		EquipamentoEletronico patrimonio2 = new EquipamentoEletronico("Notebook", 1, 3800, "Acer", 2.4);
		Veiculo patrimonio3 = new Veiculo("F-150", 1, 500000, "Pesado", "Ford", "Azul", 4);
		
		System.out.println("------------BSA Construcao & Associados------------\n");
		System.out.println("--------------FILIAL--------------");
		System.out.println(filial1.toString());
		System.out.println("------------PATRIMONIO------------");
		System.out.println(patrimonio1.toString());
		System.out.println(patrimonio2.toString());
		System.out.println(patrimonio3.toString());
		System.out.println("----------------------------------");
	}
}
