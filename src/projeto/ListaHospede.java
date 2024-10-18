package projeto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ListaHospede {
	public static List<Hospede> lista = new ArrayList<>();
	public static Scanner scan = new Scanner(System.in);
	
	public void cadastrarHospede(String nome) {
		Hospede novoHospede = new Hospede(nome);
		lista.add(novoHospede);
	}
	 public Hospede buscarHospede (String nome) {
	        for (Hospede hospede : lista) {
	            if (hospede.getNome().equalsIgnoreCase(nome)) {
	            	 System.out.println("Hospede encontrado");
	                return hospede;
	               
	            }
	        }
	        System.out.println("Hospede não encontrado");
	        return null;
	    }
	 public void adicionarHistorico(Reserva reserva, Hospede hospede) {
		String dataCheckIn = reserva.getDataCheckIn();
		int numeroQuartos = reserva.getNumeroQuartos();
		String tipoQuarto = reserva.getTipoQuarto();
		Historico historico = new Historico(dataCheckIn, numeroQuartos, tipoQuarto);
		hospede.getHistoricoReservas().add(historico);
	 }
	 public boolean listaHospedesVazia() {
	        return lista.isEmpty();
	    }
	 
	 public void mostrarHistorico(String nome) {
		 Hospede hospede = buscarHospede(nome);
		 if (hospede.getHistoricoReservas().isEmpty()) {
				System.out.println("A lista está vazia");
			}
			else {
				for (int i=0;i<hospede.getHistoricoReservas().size();i++) {
					System.out.println("---------------------------------------------");
					System.out.println(hospede.getHistoricoReservas().get(i));
					System.out.println("---------------------------------------------");
				}
			}
	 }
}
