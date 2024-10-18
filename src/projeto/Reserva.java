package projeto;

import java.util.ArrayList;

public class Reserva {
Hospede nomeHospede;
String dataCheckIn;
String dataCheckOut;
int numeroQuartos;
String tipoQuarto;
ArrayList<Quarto> quartosReservados;
boolean checkInRealizado = false;

public Hospede getNomeHospede() {
	return nomeHospede;
}
public void setNomeHospede(Hospede nomeHospede) {
	this.nomeHospede = nomeHospede;
}
public String getDataCheckIn() {
	return dataCheckIn;
}
public void setDataCheckIn(String dataCheckIn) {
	this.dataCheckIn = dataCheckIn;
}
public String getDataCheckOut() {
	return dataCheckOut;
}
public void setDataCheckOut(String dataCheckOut) {
	this.dataCheckOut = dataCheckOut;
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
public Reserva(Hospede nomeHospede, String dataCheckIn, String dataCheckOut, int numeroQuartos, String tipoQuarto) {
	this.nomeHospede = nomeHospede;
	this.dataCheckIn = dataCheckIn;
	this.dataCheckOut = dataCheckOut;
	this.numeroQuartos = numeroQuartos;
	this.tipoQuarto = tipoQuarto;
	this.quartosReservados = new ArrayList<>();
}

public Reserva() {
	this.quartosReservados = new ArrayList<>();
}
@Override
public String toString() {
	return "Nome do Hospede: " + nomeHospede + "  | Data do Check-in: " + dataCheckIn + " | Data do Check-out" + dataCheckOut
			+ "  | Quantidade de Quartos: " + numeroQuartos + " | tipoQuarto=" + tipoQuarto;
}
public ArrayList<Quarto> getQuartosReservados() {
	return quartosReservados;
}
public void setQuartosReservados(ArrayList<Quarto> quartosReservados) {
	this.quartosReservados = quartosReservados;
}
public boolean isCheckInRealizado() {
	return checkInRealizado;
}
public void setCheckInRealizado(boolean checkInRealizado) {
	this.checkInRealizado = checkInRealizado;
}


}
