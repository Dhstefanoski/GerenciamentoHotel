package projeto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaQuarto {
	public static List<Quarto> lista = new ArrayList<>();
	public static Scanner scan = new Scanner(System.in);

	
	
	public Quarto buscarQuarto(int numero) {
		for (Quarto quarto : lista) {
	        if (quarto.getNumeroQuarto() == numero) {
	            return quarto;
	        }
	    }
	    return null;
	}

	public void ocuparQuarto(int numero) {
		Quarto quarto = buscarQuarto(numero);
		if (quarto.isDisponivel()) {
			quarto.setDisponivel(false);
			System.out.println("Disponibilidade atualizada.");
		}
		else {
			System.out.println("Esse quarto já está marcado como ocupado.");
		}
	}

	public void liberarQuarto(int numero) {
		Quarto quarto = buscarQuarto(numero);
		if (!quarto.isDisponivel()) {
			quarto.setDisponivel(true);
			System.out.println("Disponibilidade atualizada.");
		}
		else {
			System.out.println("Esse quarto já está marcado como liberado.");
		}
	}

	public void listarQuarto() {
		if (lista.isEmpty()) {
			System.out.println("A lista está vazia");
		}
		else {
			for (int i=0;i<lista.size();i++) {
				Quarto quarto = lista.get(i);
				System.out.println("Quarto " + quarto.getNumeroQuarto());
				System.out.println("--------------------------------------");
				System.out.println(lista.get(i));
			}
		}

	}
	
	public void cadQuarto() {
		int n = 0;
		System.out.println("Digite o número do quarto:");
		int numero = scan.nextInt();
		String tipo = "";
		do {
			System.out.println("Digite o número correspondente ao tipo de quarto:");
			System.out.println("1 - Solteiro");
			System.out.println("2 - Casal");
			System.out.println("3 - Suíte");
			n = scan.nextInt();
			if (n == 1) {
				tipo = "Solteiro";
			}
			else if (n == 2) {
				tipo = "Casal";
			}
			else if (n == 3) {
				tipo = "Suíte";
			}
			else {
				System.out.println("Opção Inválida!");
			}
		} while ((n < 1) && (n > 3));
		System.out.println("Digite o preço por diária do quarto:");
		float preco = scan.nextFloat();
		Quarto novoQuarto = new Quarto(numero, tipo, preco);
		lista.add(novoQuarto);
	}
	
	public boolean verificarDisponibilidadeQuartos(int quantidade, String tipo, Reserva reserva) {
	    int contador = 0;
	    ArrayList<Quarto> quartosReserva = new ArrayList<>();
	     
	    for (Quarto quarto : lista) {
	        if (quarto.getTipoQuarto().equals(tipo) && quarto.isDisponivel()) {
	            contador++;
	            quartosReserva.add(quarto);
	            
	            if (contador == quantidade) {
	                reserva.setQuartosReservados(quartosReserva);
	                
	                return true;
	            }
	        }
	    }

	    return false;
	}
	  public ArrayList<Quarto> ocuparQuartos(Reserva reserva) {
	        ArrayList<Quarto> quartosReserva = new ArrayList<>();
	        
	        for (Quarto quarto : lista) {
	            if (quarto.getTipoQuarto().equals(reserva.getTipoQuarto()) && quarto.isDisponivel()) {
	            	ocuparQuarto(quarto.getNumeroQuarto());
	                quartosReserva.add(quarto);
	                
	                if (quartosReserva.size() == reserva.getNumeroQuartos()) {
	                	System.out.println("Quartos reservados com sucesso");
	                    return quartosReserva; 
	                }
	            }
	        }
	        System.out.println("Não foi possivel reservar a quantidade desejada");
	        return null; 
	    }
	  
	  public void passarOcupação(Reserva reserva) {
		    for (Quarto quarto : reserva.getQuartosReservados()) {
		        quarto.setDataCheckIn(reserva.getDataCheckIn());
		        quarto.setDataCheckOut(reserva.getDataCheckOut()); 
		    }
		}
	  
	  public void liberarQuartos(Reserva reserva) {
	        for (Quarto quarto : reserva.getQuartosReservados()) {
	            	liberarQuarto(quarto.getNumeroQuarto());
	            	System.out.println("Quartos liberados com sucesso");
	        }
	  }
	  
	  public void gerarRelatorioOcupacao() {
		    int totalOcupados = 0;
		    System.out.println("==== Relatório de Ocupação de Quartos ====");

		    for (Quarto quarto : lista) { 
		        if (quarto.isOcupado()) {
		            totalOcupados++;
		            System.out.println("Quarto: " + quarto.getNumeroQuarto() +
		                               " | Tipo: " + quarto.getTipoQuarto() +
		                               " | Período: " + quarto.getPeriodoOcupacao());
		        }
		    }

		    System.out.println("Total de Quartos Ocupados: " + totalOcupados);
		}
	  
	  public boolean listaQuartoVazia() {
	        return lista.isEmpty();
	    }
}
