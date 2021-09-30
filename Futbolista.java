package crearConfigYSerializarClases;

/*
 * PRG-Clase18
 * 14 ene. 2021
 * Javier Faus Llopis 
 */

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * The class Futbolista 
 * @author 		Javier Faus LLopis (javier.faus@gmail.com)
 * @version     Current version of the program.
 * @since       When this part of the program was first added.
 */
//@deprecated  For showing the code is outdated or shouldn't be used.
//* @param       For describing the different parameters for a method.
//* @return      For describing what the method returns.
//* @see         Links to another part of documentation.


public class Futbolista extends Persona implements Comparable, Serializable {

	/** The dorsal. */
	private int dorsal;
	
	private int velocidad;
	private int resistencia;
	private int fuerza;
	private int potencia;
	private int control;
	private int pase;
	private int chute;
	private int goles;
	private String posicion;
	private String categoria;//baja, media, alta, estrella.
	private ArrayList<Futbolista> futbolistas = new ArrayList<>();
	private Futbolista futbolista;
	/**
	 * @param nombre			String
	 * @param fechaNacimiento	LocalDate 
	 * @param altura			float
	 * @param peso				float
 	 * @param experiencia 		int Vamos acumulando experiencia para subir de categor�a (cada 100 puntos)
	 * @param nomEquipo 		String
	 * @param sueldo			float
	 * 
	 * @param dorsal			int
	 * @param velocidad			int De 1 a 100
	 * @param resistencia		int De 1 a 100
	 * @param fuerza			int De 1 a 100
	 * @param potencia			int De 1 a 100
	 * @param control			int De 1 a 100
	 * @param pase				int De 1 a 100
	 * @param chute				int De 1 a 100
	 * @param goles				int Acumula los goles de este jugador
	 * @param posicion			String Portero, defensa, centrocampista, delantero	
	 * @param categor�a			String baja, media, alta, estrella.
	 */
	
	
	public Futbolista(float altura, float peso, LocalDate fechaNacimiento, String nombre, int dorsal,
			float sueldo, int velocidad, int resistencia, int fuerza, int potencia, int control,
			int pase, int chute, int goles, String posicion, int experiencia, String categoria ) {

		super(nombre,fechaNacimiento,altura,peso,experiencia,sueldo);

		this.velocidad = velocidad;
		this.resistencia = resistencia;
		this.fuerza = fuerza;
		this.potencia = potencia;
		this.control = control;
		this.pase = pase;
		this.chute = chute;
		this.goles = goles;
		this.posicion = posicion;
		this.categoria = categoria;
		this.dorsal = dorsal;
	}
	
	public Futbolista(String nombre,String posicion,int experiencia, int dorsal) {
		super();
		this.setNombre(nombre);
		this.posicion = posicion;
		this.setExperiencia(experiencia);
		this.setDorsal(dorsal);
		this.setFechaNacimiento(LocalDate.of(Helper.numeroAleatorioEntreRango(1989, 1995), Helper.numeroAleatorioEntreRango(1, 12), Helper.numeroAleatorioEntreRango(1, 28)));
		this.velocidad = Helper.numeroAleatorioEntreRango(1, 100);
		this.resistencia = Helper.numeroAleatorioEntreRango(1, 100);
		this.fuerza = Helper.numeroAleatorioEntreRango(1, 100);
		this.potencia = Helper.numeroAleatorioEntreRango(1, 100);
		this.control = Helper.numeroAleatorioEntreRango(1, 100);
		this.pase = Helper.numeroAleatorioEntreRango(1, 100);
		this.chute = Helper.numeroAleatorioEntreRango(1, 100);
		this.resistencia = Helper.numeroAleatorioEntreRango(1, 100);
		this.goles = getGoles();
		this.setCategoria();
	}
	
	public Futbolista() {
		super();

		this.velocidad = 0;
		this.resistencia = 0;
		this.fuerza = 0;
		this.potencia = 0;
		this.control = 0;
		this.pase = 0;
		this.chute = 0;
		this.goles = 0;
		this.posicion = "";
		this.categoria = "";
	}
	
	
	public Futbolista(Futbolista f) {
		super((Persona)f);
		this.velocidad = f.getVelocidad();
		this.resistencia = f.getResistencia();
		this.fuerza = f.getFuerza();
		this.potencia = f.getPotencia();
		this.control = f.getControl();
		this.pase = f.getPase();
		this.chute = f.getChute();
		this.goles = f.getGoles();
		this.posicion = f.getPosicion();
		this.categoria = f.getCategoria();
	}
	
	
	
	// sobrecarga del constructor con solo atributo nombre
	public Futbolista(String nombre) {
			this.setNombre(nombre);
		}


		public void copiar(Futbolista f) {
			
			super.copiar((Persona)f);
			
			this.velocidad = f.getVelocidad();
			this.resistencia = f.getResistencia();
			this.fuerza = f.getFuerza();
			this.potencia = f.getPotencia();
			this.control = f.getControl();
			this.pase = f.getPase();
			this.chute = f.getChute();
			this.goles = f.getGoles();
			this.posicion = f.getPosicion();
			this.categoria = f.getCategoria();
		}
		
		
		public float calcValor(){
			float valor=0;
			
			valor = (velocidad + resistencia + potencia + fuerza + control + pase + chute) / 7.0f;
			
			return valor;
			
		} //devuelve el valor que aporta el entrenador al equipo
		public void mostrarJugador() {
			for (int i = 0; i < futbolistas.size(); i++) {
				System.out.println((i+1) + ": "+futbolistas.get(i).toString());
			}
		}
		
		
		
		@Override
		public String toString() {
			return  "nombre: " + getNombre() + ", posicion: " +  getPosicion() + ", dorsal=" + dorsal + ", velocidad=" + velocidad + ", resistencia=" + resistencia
					+ ", fuerza=" + fuerza + ", potencia=" + potencia + ", control=" + control + ", pase=" + pase
					+ ", chute=" + chute + ", goles=" + goles + ", posicion=" + posicion + ", categoria=" + categoria
					+ "]\n";
		}

		
		
		
		
		@Override
		public int compareTo(Object futbolistaComparado) {

			int resultado=0;

			if( futbolistaComparado instanceof Futbolista ) {


				float valorFutbolistaComparado=((Futbolista)futbolistaComparado).calcValor();


				if( this.calcValor() >  valorFutbolistaComparado ) {
					resultado = 1; //valor positivo, yo soy mayor.
				}
				else if(this.calcValor() <  valorFutbolistaComparado) {
					resultado = -1; // valor negativo, el objetoComparado es mayor
				}
				else {
					resultado=0; // valor cero indica igualdad
				}
				
			} 
			else {
				//si el objeto comparado no es de este tipo EstudianteComparable devolveremos 0 igualmente, podriamos hacer otras acciones.
				System.err.println("Error: comparando objeto Futbolista con otro tipo de objeto:");
				System.err.print(futbolistaComparado.getClass());
				
			}

			// Si queremos invertir el orden devuelto para que sea descendente
			resultado*= -1;
		
			return resultado;
		
		}
		
		
		public int getDorsal() {
			return dorsal;
		}

		public void setDorsal(int dorsal) {
			this.dorsal = dorsal;
		}

		public int getVelocidad() {
			return velocidad;
		}

		public void setVelocidad(int velocidad) {
			this.velocidad = velocidad;
		}

		public int getResistencia() {
			return resistencia;
		}

		public void setResistencia(int resistencia) {
			this.resistencia = resistencia;
		}

		public int getFuerza() {
			return fuerza;
		}

		public void setFuerza(int fuerza) {
			this.fuerza = fuerza;
		}

		public int getPotencia() {
			return potencia;
		}

		public void setPotencia(int potencia) {
			this.potencia = potencia;
		}

		public int getControl() {
			return control;
		}

		public void setControl(int control) {
			this.control = control;
		}

		public int getPase() {
			return pase;
		}

		public void setPase(int pase) {
			this.pase = pase;
		}

		public int getChute() {
			return chute;
		}

		public void setChute(int chute) {
			this.chute = chute;
		}

		public int getGoles() {
			return goles;
		}

		public void setGoles(int goles) {
			this.goles = goles;
		}

		public String getPosicion() {
			return posicion;
		}

		public void setPosicion(String posicion) {
			this.posicion = posicion;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
			result = prime * result + chute;
			result = prime * result + control;
			result = prime * result + dorsal;
			result = prime * result + fuerza;
			result = prime * result + goles;
			result = prime * result + pase;
			result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
			result = prime * result + potencia;
			result = prime * result + resistencia;
			result = prime * result + velocidad;
			return result;
		}
		
		public void setCategoria() {
			if (getExperiencia() < 100)
				this.categoria = "Baja";
			else if (getExperiencia() > 100 && getExperiencia() < 200)
				this.categoria = "Media";
			else if (getExperiencia() > 200 && getExperiencia() < 300)
				this.categoria = "Alta";
			else if (getExperiencia() >= 300)
				this.categoria = "Estrella";
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			Futbolista other = (Futbolista) obj;
			if (categoria == null) {
				if (other.categoria != null)
					return false;
			} else if (!categoria.equals(other.categoria))
				return false;
			if (chute != other.chute)
				return false;
			if (control != other.control)
				return false;
			if (dorsal != other.dorsal)
				return false;
			if (fuerza != other.fuerza)
				return false;
			if (goles != other.goles)
				return false;
			if (pase != other.pase)
				return false;
			if (posicion == null) {
				if (other.posicion != null)
					return false;
			} else if (!posicion.equals(other.posicion))
				return false;
			if (potencia != other.potencia)
				return false;
			if (resistencia != other.resistencia)
				return false;
			if (velocidad != other.velocidad)
				return false;
			return true;
		}
	
	
	
	
	
}
