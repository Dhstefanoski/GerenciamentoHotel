package projeto;

public class Historico {
String dataCheckIn;
int numeroQuartos;
String tipoQuarto;

public String getDataCheckIn() {
	return dataCheckIn;
}
public void setDataCheckIn(String dataCheckIn) {
	this.dataCheckIn = dataCheckIn;
}
public int getNumeroQuartos() {
	return numeroQuartos;
}
public void setNumeroQuartos(int numeroQuartos) {
	this.numeroQuartos = numeroQuartos;
}
public String getTipoQuarto() {
	return tipoQuarto;
}
public void setTipoQuarto(String tipoQuarto) {
	this.tipoQuarto = tipoQuarto;
}

public Historico() {

}

public Historico(String dataCheckIn, int numeroQuartos, String tipoQuarto) {
	this.dataCheckIn = dataCheckIn;
	this.numeroQuartos = numeroQuartos;
	this.tipoQuarto = tipoQuarto;
}

public String toString() {
	return "Data de Reserva: " + dataCheckIn + "  | Número de Quartos Reservados: " + numeroQuartos + "  | Tipo de Quarto: " + tipoQuarto
		;
}




}
