package crearConfigYSerializarClases;

import java.time.LocalDate;
import java.util.ArrayList;

/*
 * Opcional: Hacer seguimiento de los jugadores sancionados y/o lesionados. Dicha informacion se pasara a los equipos/competicion tras cada partido.
 * 
 */

public class Partido {
	
	Equipo local;
	Equipo visitante;
	int [] resultado;
	String localidad;
	Futbolista mvp;
	ArrayList<Futbolista> goleadores;
	//Futbolista [] sancionados;
	//Futbolista [] lesionados;
	//Tarjeta [] listaSanciones; // �como hacerlo?
	
	LocalDate fecha;
	
	public Partido(Equipo local, Equipo visitante) {
		this.local = local;
		this.visitante = visitante;
	}



	public Partido(Equipo local, Equipo visitante, int[] resultado, String localidad, Futbolista mvp,
			ArrayList<Futbolista> goleadores, LocalDate fecha) {
		this.local = local;
		this.visitante = visitante;
		this.resultado = resultado;
		this.localidad = localidad;
		this.mvp = mvp;
		this.goleadores = goleadores;
		this.fecha = fecha;
	}

	

	/*
	 * Hara los calculos estadisticos pertinentes para calcular el resultado. En base a el valor()
	 */
	public void calcularGanador() {
		
		float vLocal = this.local.calcValor()*valorAleatorio();
		float vVisitante = this.visitante.calcValor()*valorAleatorio();
		int aleatorioEmpate = (int) Math.random();
		if(vLocal-vVisitante < 2 ) {
			this.local.anyadirPuntos(1);
			this.visitante.anyadirPuntos(1);
			this.local.setPartidosEmpatados(1);
			this.visitante.setPartidosEmpatados(1);
			
		}else if(vLocal > vVisitante && vLocal > 2) {
			this.local.anyadirPuntos(2);
			this.visitante.anyadirPuntos(0);
			this.local.setPartidosGanados(1);
			this.visitante.setPartidosPerdidos(1);
			
		}else if(vLocal < vVisitante && vVisitante > 2) {
			this.local.anyadirPuntos(0);
			this.visitante.anyadirPuntos(2);
			this.visitante.setPartidosGanados(1);
			this.local.setPartidosPerdidos(1);
		}
		/*
		 * Modificamos +-10% aleatoriamente el valor de cada equipo que juega el partido. El ganador del partido ser� el que tenga mayor valor una vez modificado el 10% aleatorio.
		 * El empate se produce cuando la diferencia de puntos es menor a diez.
		 * return local; // o visitante
		 */
	}
	
	public float valorAleatorio() {
		int aleatorio = (int) (Math.random());
		switch(aleatorio) {
		case 0:
			return 0.90f;
		case 1:
			return 1.10f;
		}
		return 1;
	}
	
	public void calcularMVP() {
		/*En caso de empate a cero se le asigna a suerte a un portero
		 * si hay un m�ximo goleador a �l 
		 * si hay m�s de uno se sortea a partes iguales.
		 */
		
	}
/*	
	public Equipo getGanador() {//En caso de empate resultado null.
			
	}
	
	public Equipo getPerdedor() {//En caso de empate resultado null.
		
	}
	
	private Futbolista[] getGoleadores() {//Obtenemos del calculo quienes son los goleadores.
		
	}
	
	
*/	
	public void calcularGoleadores() {//Calcula quienes son los goleadores.
		/*Para la asignacion del gol el porcentaje seg�n posici�n es:
		 * Delantero 70%, Centro 20%, Defensa 9% y portero 1%.
		 * Y despu�s dividiremos entre los jugadores que hayan en esa categor�a.
		 */
		
	}
	
	/*
	 * Ganador: 3puntos
	 * Empate: 1 punto cada equipo.
	 * Perdedor: 0 puntos.
	 * 
	 *  
	 */
	public void asignarPuntos () {
		// �D�nde se apuntan los puntos?
	    //Dentro de cada equipo aqu�
		
		
	}
	
//	public int getGolesLocal(){}
//	public int getGolesVisitante(){}
//	
//	public int getGoles(Equipo equipo) {}
	
	

	public Equipo getLocal() {
		return local;
	}



	public void setLocal(Equipo local) {
		this.local = local;
	}



	public Equipo getVisitante() {
		return visitante;
	}



	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}



	public int[] getResultado() {
		return resultado;
	}



	public void setResultado(int[] resultado) {
		this.resultado = resultado;
	}



	public String getLocalidad() {
		return localidad;
	}



	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}



	public Futbolista getMvp() {
		return mvp;
	}



	public void setMvp(Futbolista mvp) {
		this.mvp = mvp;
	}



	public ArrayList<Futbolista> getGoleadores() {
		return goleadores;
	}



	public void setGoleadores(ArrayList<Futbolista> goleadores) {
		this.goleadores = goleadores;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	
	
	
}