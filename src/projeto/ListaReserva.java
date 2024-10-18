package projeto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaReserva {
	public static List<Reserva> lista = new ArrayList<>();
	public static Scanner scan = new Scanner(System.in);
	public static ListaHospede gerenciarHospede = new ListaHospede();
	public static ListaQuarto gerenciarQuarto = new ListaQuarto();
	
	public Reserva buscarReserva (String nome) {
        for (Reserva reserva : lista) {
        	Hospede hospede = reserva.getNomeHospede();
            if (hospede.getNome().equals(nome)) {
            	 System.out.println("Reserva encontrada!");
                return reserva;
               
            }
        }
        System.out.println("Reserva não encontrada.");
        return null;
    }
	public void cadastrarReserva() {
	    Reserva novaReserva;
	    Hospede hospede;
	    boolean verificar;

	    do {
	        System.out.println("Digite o nome do hóspede: ");
	        String nome = scan.nextLine();
	        hospede = gerenciarHospede.buscarHospede(nome);
	        if (hospede == null) {
	            System.out.println("Hóspede não encontrado. Por favor, tente novamente");
	            System.out.println("");
	        }
	    } while (hospede == null);

	    System.out.println("Digite a data de check-in, no formato DD/MM/AAAA");
	    String dataCheckIn = scan.nextLine();

	    System.out.println("Digite a data de check-out, no formato DD/MM/AAAA");
	    String dataCheckOut = scan.nextLine();

	    do {
	        System.out.println("Digite a quantidade de quartos para reservar:");
	        int numeroQuartos = scan.nextInt();
	        scan.nextLine(); 

	        String tipo = "";
	        int n;

	        do {
	            System.out.println("Digite o número correspondente ao tipo de quarto");
	            System.out.println("1 - Solteiro");
	            System.out.println("2 - Casal");
	            System.out.println("3 - Suíte");
	            n = scan.nextInt();
	            scan.nextLine(); 

	            if (n == 1) {
	                tipo = "Solteiro";
	            } else if (n == 2) {
	                tipo = "Casal";
	            } else if (n == 3) {
	                tipo = "Suíte";
	            } else {
	                System.out.println("Opção Inválida!");
	            }
	        } while (n < 1 || n > 3);

	        novaReserva = new Reserva(hospede, dataCheckIn, dataCheckOut, numeroQuartos, tipo);
	        verificar = gerenciarQuarto.verificarDisponibilidadeQuartos(numeroQuartos, tipo, novaReserva);

	    } while (!verificar);

	    lista.add(novaReserva);
	    gerenciarQuarto.ocuparQuartos(novaReserva);
	    gerenciarHospede.adicionarHistorico(novaReserva, hospede);
	    gerenciarQuarto.passarOcupação(novaReserva);
	}

	
	public void realizarChekIn(String nome) {
		Reserva reserva = buscarReserva(nome);
		if (reserva.isCheckInRealizado()) {
			System.out.println("Esse check in já foi realizado.");
		}
		else {
			reserva.checkInRealizado = true;
			System.out.println("Check in realizado com sucesso.");
		}
	}
	public void realizarCheckOut(String nome) {
		Reserva reserva = buscarReserva(nome);
		if (reserva.isCheckInRealizado()) {
			gerenciarQuarto.liberarQuartos(reserva);
			lista.remove(reserva);
			System.out.println("Check out realizado com sucesso.");
		}
		else {
			System.out.println("Nenhum check in foi realizado nesse nome.");
		}
	}
	
}
