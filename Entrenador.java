package crearConfigYSerializarClases;

/*
 * PRG-Clase18
 * 14 ene. 2021
 * Javier Faus Llopis  
 */

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

// TODO: Auto-generated Javadoc
/**
 * The Class Entrenador.
 */
public class Entrenador extends Persona implements Serializable{
	
	/** The liderazgo. */
	//atributos sobre caracteristicas tecnicas
	int liderazgo;//1-100.
	
	/** The estrategia. */
	int estrategia;//1-100.
	
	/** The comunicacion. */
	int comunicacion;//1-100.

	
	/**
	 * Instantiates a new entrenador.
	 *
	 * @param nombre the nombre
	 * @param fechaNacimiento the fecha nacimiento
	 * @param altura the altura
	 * @param peso the peso
	 * @param sueldo the sueldo
	 * @param experiencia the experiencia
	 * @param liderazgo the liderazgo
	 * @param estrategia the estrategia
	 * @param comunicacion the comunicacion
	 */
	/*Constructor sobrecargado con todos los atributos */
	public Entrenador(String nombre, LocalDate fechaNacimiento, float altura, float peso,
			float sueldo, int experiencia, int liderazgo, int estrategia, int comunicacion) {
		
		super(nombre,fechaNacimiento,altura,peso,experiencia,sueldo);
		
		this.liderazgo = liderazgo;
		this.estrategia = estrategia;
		this.comunicacion = comunicacion;
	}


	/**
	 * Instantiates a new entrenador.
	 *
	 * @param nombre the nombre
	 */
	/*Constructor sobrecargado solo con el nombre*/
	public Entrenador(String nombre) {
		super();
		setNombre(nombre);
		setFechaNacimiento(LocalDate.of(Helper.numeroAleatorioEntreRango(1989, 1995), Helper.numeroAleatorioEntreRango(1, 12), Helper.numeroAleatorioEntreRango(1, 28)));
		setAltura(Helper.numeroAleatorioEntreRango(165, 195));
		setPeso(Helper.numeroAleatorioEntreRango(65, 80));
		setSueldo(Helper.numeroAleatorioEntreRango(1500, 2500));
		setExperiencia(Helper.numeroAleatorioEntreRango(0, 400));
		this.liderazgo = Helper.numeroAleatorioEntreRango(1, 100);
		this.estrategia = Helper.numeroAleatorioEntreRango(1, 100);
		this.comunicacion = Helper.numeroAleatorioEntreRango(1, 100);
	}


	/**
	 * Instantiates a new entrenador.
	 *
	 * @param e the e
	 */
	public Entrenador(Entrenador e) {
		super((Persona)e);
		this.liderazgo=e.getLiderazgo() ;//1-100.
		this.estrategia=e.getEstrategia();//1-100.
		this.comunicacion=e.getComunicacion();//1-100.
	}
	
	
	/**
	 * Copiar.
	 *
	 * @param e the e
	 */
	public void copiar(Entrenador e) {
		super.copiar((Persona)e);
		this.liderazgo=e.getLiderazgo() ;//1-100.
		this.estrategia=e.getEstrategia();//1-100.
		this.comunicacion=e.getComunicacion();//1-100.
	}
	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return  super.toString() + ", liderazgo=" + liderazgo + ", estrategia=" + estrategia + ", comunicacion=" + comunicacion + "]";
	}



	/* Metodos implementados */



	/**
	 * Calc valor.
	 *
	 * @return the float
	 */
	/*Devuelve un float que expresa el valor que aporta el entrenador en cada partido.*/
	public float calcValor() {
		float valor=0;
		valor = (float) (this.liderazgo + this.estrategia + this.comunicacion) /3;
		return valor;
	}
	
	
	
	/**
	 * Organizar entrenamiento.
	 *
	 * @param jugadores the jugadores
	 */
	public void organizarEntrenamiento(ArrayList<Futbolista> jugadores) {
		
	}
	
	

	
	/**
	 * Poner alineacion.
	 *
	 * @param jugadores the jugadores
	 * @return the array list
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Futbolista> ponerAlineacion( ArrayList<Futbolista> jugadores ) {
		
//		Preparamos las estructuras de datos a utilizar
		
		ArrayList<Futbolista> porteros = new ArrayList<>();
		ArrayList<Futbolista> defensas = new ArrayList<>();
		ArrayList<Futbolista> centrocampistas = new ArrayList<>();
		ArrayList<Futbolista> delanteros = new ArrayList<>();
		
		
//		Parseamos el ArrayList con todos todos los jugadores y los a�adimos seg�n su posici�n en su respectivo ArrayList
		
		for (Futbolista futbolista : jugadores) {
			
			if(futbolista.getPosicion().equalsIgnoreCase("portero"))
				porteros.add(futbolista);
			
			if(futbolista.getPosicion().equalsIgnoreCase("defensa"))
				defensas.add(futbolista);
			
			if(futbolista.getPosicion().equalsIgnoreCase("centrocampista"))
				centrocampistas.add(futbolista);
			
			if(futbolista.getPosicion().equalsIgnoreCase("delantero"))
				delanteros.add(futbolista);
			
		}
		
		
		Collections.sort(porteros);
		Collections.sort(defensas);
		Collections.sort(centrocampistas);
		Collections.sort(delanteros);

		
		//Vamos ahora a construir el ArrayList<Futbolista> alineacion en el que ir�n solo los jugadores titulares
		ArrayList<Futbolista> alineacion = new ArrayList<>();
		
		alineacion.addAll(porteros.subList(0, 1));//.subList() empieza en 0 y el �ltimo indicado no se incluye
		alineacion.addAll(defensas.subList(0, 4));
		alineacion.addAll(centrocampistas.subList(0, 4));
		alineacion.addAll(delanteros.subList(0, 2));
		
		return alineacion;
	}
	

	/* Getters and Setters */


	/**
	 * Gets the liderazgo.
	 *
	 * @return the liderazgo
	 */
	public int getLiderazgo() {
		return liderazgo;
	}


	/**
	 * Sets the liderazgo.
	 *
	 * @param liderazgo the liderazgo to set
	 */
	public void setLiderazgo(int liderazgo) {
		this.liderazgo = liderazgo;
	}


	/**
	 * Gets the estrategia.
	 *
	 * @return the estrategia
	 */
	public int getEstrategia() {
		return estrategia;
	}


	/**
	 * Sets the estrategia.
	 *
	 * @param estrategia the estrategia to set
	 */
	public void setEstrategia(int estrategia) {
		this.estrategia = estrategia;
	}


	/**
	 * Gets the comunicacion.
	 *
	 * @return the comunicacion
	 */
	public int getComunicacion() {
		return comunicacion;
	}


	/**
	 * Sets the comunicacion.
	 *
	 * @param comunicacion the comunicacion to set
	 */
	public void setComunicacion(int comunicacion) {
		this.comunicacion = comunicacion;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + comunicacion;
		result = prime * result + estrategia;
		result = prime * result + liderazgo;
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrenador other = (Entrenador) obj;
		if (comunicacion != other.comunicacion)
			return false;
		if (estrategia != other.estrategia)
			return false;
		if (liderazgo != other.liderazgo)
			return false;
		return true;
	}

}
