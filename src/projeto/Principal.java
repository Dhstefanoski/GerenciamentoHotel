package projeto;
import java.util.Scanner;

public class Principal {
	  public static void main(String[] args) {
	        ListaHospede gerenciarHospede = new ListaHospede();
	        ListaQuarto gerenciarQuarto = new ListaQuarto();
	        ListaReserva gerenciarReserva = new ListaReserva();
	        Scanner scan = new Scanner(System.in);
	        int opcao;

	        System.out.println("===================================");
	        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Hotel");
	        System.out.println("===================================");

	        do {
	            menu();
	            opcao = scan.nextInt();
	            scan.nextLine();
	            
	            if (opcao == 1) {
	            	System.out.println("Digite o nome do hóspede: ");
	            	String nome = scan.nextLine();
                  gerenciarHospede.cadastrarHospede(nome);
	            } else if (opcao == 2) {
	            	gerenciarQuarto.cadQuarto();
	            } else if (opcao == 3) {
	            	if ((gerenciarHospede.listaHospedesVazia()) || (gerenciarQuarto.listaQuartoVazia())){
	            		System.out.println("É preciso ter ao menos 1 quarto e 1 hóspede cadastrados para realizar uma reserva.");
	            	}
	            	else {
	            		gerenciarReserva.cadastrarReserva();
	            	}
	            } else if (opcao == 4) {
	            	System.out.println("Digite o nome do hóspede que esta na reserva para realizar o Check-In: ");
	            	String nome = scan.nextLine();
	             gerenciarReserva.realizarChekIn(nome);
	                
	            } else if (opcao == 5) {
	            	System.out.println("Digite o nome do hóspede que esta na reserva para realizar o Check-Out: ");
	            	String nome = scan.nextLine();
	             gerenciarReserva.realizarCheckOut(nome);
	            } else if (opcao == 6) {
	                gerenciarQuarto.listarQuarto();
	            } else if (opcao == 7) {
	                gerenciarQuarto.gerarRelatorioOcupacao();
	            } else if (opcao == 8) {
	            	System.out.println("Digite o nome do hóspede que você deseja visualizar o histórico:");
	            	String nome = scan.nextLine();
	            	gerenciarHospede.mostrarHistorico(nome);
	            } else if (opcao == 9) {
	                System.out.println("Saindo do sistema...");
	            } else {
	                System.out.println("Opção inválida. Por favor, tente novamente.");
	            }
	        } while (opcao != 9); 
	        
	        System.out.println("Obrigado por usar o Sistema de Gerenciamento de Hotel. Até mais!");

	    }
	  public static void menu() {
		  System.out.println("========= Menu Principal =========");
          System.out.println("1. Cadastrar Hóspede");
          System.out.println("2. Cadastrar Quarto");
          System.out.println("3. Cadastrar Reserva");
          System.out.println("4. Fazer Check-in");
          System.out.println("5. Fazer Check-out");
          System.out.println("6. Listar Quartos");
          System.out.println("7. Consultar Ocupação Atual");
          System.out.println("8. Consultar Histórico de Reservas");
          System.out.println("9. Sair");
          System.out.println("===================================");
          System.out.println("Selecione uma opção: ");
	  }
}
