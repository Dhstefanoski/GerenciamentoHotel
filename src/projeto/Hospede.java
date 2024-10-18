package projeto;
import java.util.ArrayList;

public class Hospede {
String nome;
ArrayList<Historico> historicoReservas;

public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public ArrayList<Historico> getHistoricoReservas() {
	return historicoReservas;
}
public void setHistoricoReservas(ArrayList<Historico> historicoReservas) {
	this.historicoReservas = historicoReservas;
}
public Hospede(String nome) {
	this.nome = nome;
	 this.historicoReservas = new ArrayList<>();
}
public Hospede() {
}
public String toString() {
	return "Hospede: " + nome;
}





}
