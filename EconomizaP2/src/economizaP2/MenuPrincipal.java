package economizaP2;

public class MenuPrincipal {

	public static void main(String[] args) {
		EconomizaP2 loja = new EconomizaP2();
		int opcao;
		
		do {

			imprimeMenu();
			opcao = loja.recebeInteiro();
			
			switch (opcao) {
			case 1:
				loja.cadastroDeProdutos();
				break;
			case 2:
				//VENDER
				break;
			case 3:
				//IMPRIMIR BALAN�O
			default:
				//QUALQUER OUTRO SAI
				break;
			}

		} while (opcao != 4);
		
		 System.out.println("-- Fim da execu��o --");

	}
	
	public static void imprimeMenu(){
		System.out.println("= = = = Bem-vindo(a) ao EconomizaP2 = = = =\nDigite a op��o desejada:\n1 - Cadastrar um Produto");
		System.out.print("2 - Vender um Produto\n3 - Imprimir Balan�o\n4 - Sair\n\nOp��o: ");



	}


}
