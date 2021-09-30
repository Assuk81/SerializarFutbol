package crearConfigYSerializarClases;

/*
 * PRG-Clase18
 * 14 ene. 2021
 * Javier Faus Llopis 
 */

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Class Equipo.
 * Opcional: considerar la funcionalidad de hacer fichajes. Tener en cuenta que fichar a un futbolista implica darlo de baja en su respectivo equipo.
 * 
 * @author Javier Faus Llopis
 */
public class Equipo implements Comparable, Serializable {
	
	private String nombre;
	private ArrayList<Futbolista> aEquipo;
	private ArrayList<Entrenador>entrenadores;
	private String localidad;
	private LocalDate fechFundacion;
	private ArrayList<Futbolista> alineacion;//los once jugadores que seran titulares en un determinado partido
	private ArrayList<Titulo> titulos;
	private float patrimonio;
	private String nombrePresidente;
	private String [] equipacion; // tres equipaciones. Ej: 1."Blanco" , 2. "Azul", 3. "BlanquiAzul"  

	private int puntos; // representa los puntos del equipo en una competicion
	private int partidosGanados=0;
	private int partidosPerdidos=0;
	private int partidosEmpatados=0;

	
	// implementar todos los metodos

	public Equipo(String nombre, ArrayList<Futbolista> aEquipo, ArrayList<Entrenador> entrenador, String localidad,
				  LocalDate fechFundacion, float patrimonio, String nombrePresidente, String[] equipacion, int puntos) {
		this.nombre = nombre;
		this.aEquipo = aEquipo;
		this.entrenadores = entrenador;
		this.localidad = localidad;
		this.fechFundacion = fechFundacion;
		this.patrimonio = patrimonio;
		this.nombrePresidente = nombrePresidente;
		this.equipacion = equipacion;
		this.puntos = puntos;
	}

	public  int calcValor() {//Capacidad de ganar un partido, es la media de sus jugadores alineados y su entrenador.
		int valorTotal = 0;
		for (int j = 0; j < aEquipo.size(); j++) {
			valorTotal = (int) aEquipo.get(j).calcValor()*22;
		}
		valorTotal+=entrenadores.get(0).calcValor();
		return valorTotal/aEquipo.size()+1; 
	} 
	

	@Override
	public int compareTo(Object equipoComparado) {

		int resultado=0;

		if( equipoComparado instanceof Equipo ) {


			float valorEquipoComparado=((Equipo)equipoComparado).getPuntos();


			if( this.getPuntos() >  valorEquipoComparado ) {
				resultado = 1; //valor positivo, yo soy mayor.
			}
			else if(this.getPuntos() <  valorEquipoComparado) {
				resultado = -1; // valor negativo, el objetoComparado es mayor
			}
			else {
				resultado=0; // valor cero indica igualdad
			}
			
		} 
		else {
			//si el objeto comparado no es de este tipo EstudianteComparable devolveremos 0 igualmente, podriamos hacer otras acciones.
			System.err.println("Error: comparando objeto equipo con otro tipo de objeto:");
			System.err.print(equipoComparado.getClass());
			
		}

		// Si queremos invertir el orden devuelto para que sea descendente
		resultado*= -1;
	
		return resultado;
	
	}
	public void anyadirPuntos(int puntos) {
		this.puntos+=puntos;
	}
	public void anyadirTitulo() {
		
	}
	public void actualizarPatrimonio (float dinero) {
		this.patrimonio = dinero;
	}
	public void anyadirFutbolista (Futbolista fichaje) {
		aEquipo.add(fichaje);
	}
	public void eliminarFutbolista (Futbolista despedido) {
		aEquipo.remove(despedido);
	}
	public void editarJugador(Futbolista futbolista, int index) {
		aEquipo.set(index,futbolista);
		
	}

	public void anyadirEntrenador (Entrenador contratar) {
		entrenadores.add(contratar);
	}

	public void borrarEntrenador(Entrenador entrenador){
		entrenadores.remove(entrenador);
	}



	public void editarEntrenador(int indice,Entrenador nuevo){
		entrenadores.set(indice,nuevo);

	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the aEquipo
	 */
	public ArrayList<Futbolista> getaEquipo() {
		return aEquipo;
	}
	/**
	 * @param aEquipo the aEquipo to set
	 */
	public void setaEquipo(ArrayList<Futbolista> aEquipo) {
		this.aEquipo = aEquipo;
	}
	
	/**
	 * @return the entrenador
	 */

	public ArrayList<Entrenador> getEntrenadores() {
		return entrenadores;
	}

	public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
		this.entrenadores = entrenadores;
	}

	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}
	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	/**
	 * @return the fechFundacion
	 */
	public LocalDate getFechFundacion() {
		return fechFundacion;
	}
	/**
	 * @param fechFundacion the fechFundacion to set
	 */
	public void setFechFundacion(LocalDate fechFundacion) {
		this.fechFundacion = fechFundacion;
	}
	/**
	 * @return the alineacion
	 */
	public ArrayList<Futbolista> getAlineacion() {
		return alineacion;
	}
	/**
	 * @param alineacion the alineacion to set
	 */
	public void setAlineacion(ArrayList<Futbolista> alineacion) {
		this.alineacion = alineacion;
	}
	/**
	 * @return the titulos
	 */
	public ArrayList<Titulo> getTitulos() {
		return titulos;
	}
	/**
	 * @param titulos the titulos to set
	 */
	public void setTitulos(ArrayList<Titulo> titulos) {
		this.titulos = titulos;
	}
	/**
	 * @return the patrimonio
	 */
	public float getPatrimonio() {
		return patrimonio;
	}
	/**
	 * @param patrimonio the patrimonio to set
	 */
	public void setPatrimonio(float patrimonio) {
		this.patrimonio = patrimonio;
	}
	/**
	 * @return the nombrePresidente
	 */
	public String getNombrePresidente() {
		return nombrePresidente;
	}
	/**
	 * @param nombrePresidente the nombrePresidente to set
	 */
	public void setNombrePresidente(String nombrePresidente) {
		this.nombrePresidente = nombrePresidente;
	}
	/**
	 * @return the equipacion
	 */
	public String[] getEquipacion() {
		return equipacion;
	}
	/**
	 * @param equipacion the equipacion to set
	 */
	public void setEquipacion(String[] equipacion) {
		this.equipacion = equipacion;
	}
	/**
	 * @return the puntos
	 */
	public int getPuntos() {
		return puntos;
	}
	/**
	 * @param puntos the puntos to set
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	/**
	 * @return the patidosGanados
	 */
	public int getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados += partidosGanados;
	}
	/**
	 * @return the partidosPerdidos
	 */
	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}
	/**
	 * @param partidosPerdidos the partidosPerdidos to set
	 */
	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos += partidosPerdidos;
	}
	/**
	 * @return the partidosEmpatados
	 */
	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}
	/**
	 * @param partidosEmpatados the partidosEmpatados to set
	 */
	public void setPartidosEmpatados(int partidosEmpatados) {
		this.partidosEmpatados += partidosEmpatados;
	}

	@Override
	public String toString() {
		return nombre + "\n .:Futbolistas:.\n" + aEquipo + ", \nlocalidad="
				+ localidad + ", \nfechFundacion=" + fechFundacion + ", \nalineacion=" + alineacion + ", \ntitulos=" + titulos
				+ ", \npatrimonio=" + patrimonio + ", \nPresidente=" + nombrePresidente + ", \nequipacion="
				+ Arrays.toString(equipacion) + ", \npuntos=" + puntos + ", \npartidosGanados=" + partidosGanados
				+ ", \npartidosPerdidos=" + partidosPerdidos + ", \npartidosEmpatados=" + partidosEmpatados + "]\n";
	}
	
	
}
