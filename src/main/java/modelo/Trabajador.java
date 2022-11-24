package modelo;

public class Trabajador extends Persona {
	private String isapre;
	private String afp;


	public String[] obtenerAtributos(){
		String[] atributos = new String[5];
		atributos[0] = nombre;
		atributos[1] = apellido;
		atributos[2] = rut;
		atributos[3] = isapre;
		atributos[4] = afp;
		return atributos;
	}
	public String getIsapre() {
		return isapre;
	}

	public void setIsapre(String isapre) {
		this.isapre = isapre;
	}

	public String getAFP() {
		return afp;
	}

	public void setAFP(String afp) {
		this.afp = afp;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s", nombre, apellido, rut, isapre, afp);
	}
}