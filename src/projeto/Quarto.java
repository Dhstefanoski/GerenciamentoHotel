package projeto;

public class Quarto {
int numeroQuarto;
String tipoQuarto;
float precoDiario;
boolean disponivel = true;
String dataCheckIn;
String dataCheckOut;

public int getNumeroQuarto() {
	return numeroQuarto;
}
public void setNumeroQuarto(int numeroQuarto) {
	this.numeroQuarto = numeroQuarto;
}
public String getTipoQuarto() {
	return tipoQuarto;
}
public void setTipoQuarto(String tipoQuarto) {
	this.tipoQuarto = tipoQuarto;
}
public float getPrecoDiario() {
	return precoDiario;
}
public void setPrecoDiario(float precoDiario) {
	this.precoDiario = precoDiario;
}
public boolean isDisponivel() {
	return disponivel;
}
public void setDisponivel(boolean disponivel) {
	this.disponivel = disponivel;
}
public Quarto(int numeroQuarto, String tipoQuarto, float precoDiario) {
	this.numeroQuarto = numeroQuarto;
	this.tipoQuarto = tipoQuarto;
	this.precoDiario = precoDiario;
}

public Quarto() {

}

public String toString() {
	if(disponivel) {
	return "Número: " + numeroQuarto + " | Tipo: " + tipoQuarto + " | Preço: " + precoDiario
			+ " | Disponibilidade: Disponível";
	}
	else {
		return "Número: " + numeroQuarto + " | Tipo: " + tipoQuarto + " | Preço: " + precoDiario
				+ " | Disponibilidade: Ocupado";
		}
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

public boolean isOcupado() {
    return !disponivel; 
}

public String getPeriodoOcupacao() {
    return "Check-in: " + dataCheckIn + " | Check-out: " + dataCheckOut;
}



}
