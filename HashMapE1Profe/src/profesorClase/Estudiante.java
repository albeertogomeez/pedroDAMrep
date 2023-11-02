package profesorClase;

public class Estudiante {

	// Atributos
	public int ID;
	public String Nombre;
	public double Nota;
	
	// Constructor
	public Estudiante(int iD, String nombre, double nota) {
		this.ID = iD;
		this.Nombre = nombre;
		this.Nota = nota;
	}

	// Getters & Setters
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public double getNota() {
		return Nota;
	}


	public void setNota(double nota) {
		Nota = nota;
	}
	
	
}
