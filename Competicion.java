package crearConfigYSerializarClases;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Competicion.
 */
public class Competicion {
	
	/** The sc. */
	Scanner sc = new Scanner(System.in);
	
	/** The equipos. */
	ArrayList<Equipo> equipos;
	
	/** The partidos. */
	ArrayList<Partido> partidos;
	
	/** The clasificacion. */
	ArrayList<Equipo> clasificacion;
	
	/** The entrenadores. */
	ArrayList<Entrenador> entrenadores;
	
	/** The equipo. */
	Equipo equipo;

	/** The titulo. */
	Titulo titulo;
	
	
	/**
	 * Instantiates a new competicion.
	 */
	public Competicion() {
		this.equipos = new ArrayList<>();
		this.partidos = new ArrayList<>();
		this.clasificacion = new ArrayList<>();
		this.titulo = null;
	}

	/**
	 * Instantiates a new competicion.
	 *
	 * @param equipos the equipos
	 * @param partidos the partidos
	 * @param clasificacion the clasificacion
	 * @param titulo the titulo
	 */
	public Competicion(ArrayList<Equipo> equipos, ArrayList<Partido> partidos, ArrayList<Equipo> clasificacion,
			Titulo titulo) {
		this.equipos = equipos;
		this.partidos = partidos;
		this.clasificacion = clasificacion;
		this.titulo = titulo;
	}


	/*MENU ENTRENADORES*/
	
	/**
	 * Crear entrenador.
	 */
	public void crearEntrenador()  {
		int opcion = 0;
		mostrarEquipos();
		do {
			System.out.println("Introduce el numero de equipo donde quieres insertar el nuevo entrenador");
			opcion = sc.nextInt();
			sc.nextLine();
		}while(opcion < 1 || opcion > equipos.size());//si opcion es menor de 1 o mayor de cantidad de equipos, vuelve a pedir un numero en el menu
		//si se elige uno dentro del rango(cantidad de equipos)eleccion correcta y continua la ejecucion
		ArrayList<Futbolista> equipo = equipos.get(opcion-1).getaEquipo();
		
		System.out.println("Introduce el nombre del entrenador");
		String nombre = sc.nextLine();
		System.out.println("Generando atributos de forma aleatoria");
		int num = 4;
		for (int i = num; i > 0; i--) {
			System.out.print("* ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\nEntrenador insertado correctamente");
		equipos.get(opcion-1).anyadirEntrenador(new Entrenador(nombre));
		
		
	}

	/**
	 * Eliminar entrenador.
	 */
	public void eliminarEntrenador() {
		int opcion = 0;
		mostrarEquipos();

		do {
			System.out.println("Introduce el numero de equipo para ver sus jugadores");
			opcion = sc.nextInt();
			sc.nextLine();//se limpia el buffer???

		}while(opcion < 0 || opcion > equipos.size());
		int opcionEntrenador;
		ArrayList<Entrenador> entrenadores = equipos.get(opcion-1).getEntrenadores();
		for(int i = 0; i< entrenadores.size();i++) {
			System.out.println("Jugador "+(i+1) + "-> "+entrenadores.get(i).getNombre());
		}
		System.out.println("Elige que entrenador quires eliminar");

		do {
			opcionEntrenador = sc.nextInt();
			sc.nextLine();
		}while (opcion<0 || opcion >= equipos.size());

		equipos.get(opcion-1).borrarEntrenador(entrenadores.get(opcionEntrenador-1));

	}


	/**
	 * Editar entrenador.
	 */
	public void editarEntrenador() {
		int opcion = 0;
		mostrarEquipos();

		do {
			System.out.println("Introduce el numero de equipo para ver sus jugadores");
			opcion = sc.nextInt();
			sc.nextLine();//se limpia el buffer???

		}while(opcion < 0 || opcion > equipos.size());
		int opcionEntrenador;
		ArrayList<Entrenador> entrenadores = equipos.get(opcion-1).getEntrenadores();
		for(int i = 0; i< entrenadores.size();i++) {
			System.out.println("Jugador "+(i+1) + "-> "+entrenadores.get(i).getNombre());
		}
		System.out.println("Elige que entrenador quires editar");

		do {
			opcionEntrenador = sc.nextInt();
			sc.nextLine();
		}while (opcion<0 || opcion >= equipos.size());


		System.out.println("Introduce el nuevo nombre del entrenador");
		String nombre = sc.nextLine();
		equipos.get(opcion-1).editarEntrenador(opcionEntrenador-1,new Entrenador(nombre));
	}


	/**
	 * Mostrar entrenadores.
	 */
	public void mostrarEntrenadores(){

		int opcion = 0;
		mostrarEquipos();

		do {
			System.out.println("Introduce el numero de equipo para ver sus jugadores");
			opcion = sc.nextInt();
			sc.nextLine();

		}while(opcion < 0 || opcion > equipos.size());

		ArrayList<Entrenador> entrenadores = equipos.get(opcion-1).getEntrenadores();

		for(int i = 0; i< entrenadores.size();i++) {
			System.out.println("Jugador "+(i+1) + "-> "+entrenadores.get(i).getNombre());
		}
	}
	
	/**
	 * Mostrar entrenador.
	 */
	public void mostrarEntrenador(){

		int opcion = 0;
		mostrarEquipos();

		do {
			System.out.println("Introduce el numero de equipo para ver sus jugadores");
			opcion = sc.nextInt();
			sc.nextLine();//se limpia el buffer???

		}while(opcion < 0 || opcion > equipos.size());
		int opcionEntrenador;
		ArrayList<Entrenador> entrenadores = equipos.get(opcion-1).getEntrenadores();
		for(int i = 0; i< entrenadores.size();i++) {
			System.out.println("Jugador "+(i+1) + "-> "+entrenadores.get(i).getNombre());
		}
		System.out.println("Elige que entrenador quires ver en detalle");

		do {
			opcionEntrenador = sc.nextInt();
			sc.nextLine();
		}while (opcion<0 || opcion >= equipos.size());

		System.out.println(entrenadores.get(opcionEntrenador).toString());

	}


	/*MENU COMPETICION*/

	/**
	 * Generar equipos.
	 *
	 * @return the array list
	 */
	public ArrayList<Equipo> generarEquipos(){

		for(int i = 0;i < 4; i++) {

			this.equipos.add(new Equipo("Equipo "+(i+1),generarJugadores(), generarEntrenador(),"Ciudad "+(i+1), LocalDate.of(1985, 12, 1), 2000000, "Presidente "+(i+1),null, 0));

		}
		return this.equipos;
	}

	/**
	 * Generar jugadores.
	 *
	 * @return the array list
	 */
	public ArrayList<Futbolista> generarJugadores() {

		/*Futbolista*/
		ArrayList<Futbolista> jugadores = new ArrayList<>();
		for(int j = 0;j < 2; j++) {
			int experiencia = Helper.numeroAleatorioEntreRango(0, 400);
			int dorsal = Helper.numeroAleatorioEntreRango(1, 100);
			jugadores.add(new Futbolista("FutbolistaPortero "+(j+1), "Portero", experiencia, dorsal));

		}

		for(int j = 0;j < 8; j++) {
			int experiencia = Helper.numeroAleatorioEntreRango(0, 400);
			int dorsal = Helper.numeroAleatorioEntreRango(1, 100);
			jugadores.add(new Futbolista("FutbolistaDefensa "+(j+1), "Defensa", experiencia, dorsal));
		}

		for(int j = 0;j < 8; j++) {
			int experiencia = Helper.numeroAleatorioEntreRango(0, 400);
			int dorsal = Helper.numeroAleatorioEntreRango(1, 100);
			jugadores.add(new Futbolista("FutbolistaCentrocampista "+(j+1), "Centrocampista", experiencia, dorsal));
		}

		for(int j = 0;j < 4; j++) {
			int experiencia = Helper.numeroAleatorioEntreRango(0, 400);
			int dorsal = Helper.numeroAleatorioEntreRango(1, 100);
			jugadores.add(new Futbolista("FutbolistaDelantero "+(j+1), "Delantero", experiencia, dorsal));
		}


		return jugadores;

	}

	/**
	 * Generar equipo.
	 *
	 * @return the array list
	 */
	public ArrayList<Equipo> generarEquipo(){

		System.out.println("Introduce el nombre del equipo");
		String nombre = sc.nextLine();
		System.out.println("Introduce el nombre de la localidad");
		String ciudad = sc.nextLine();
		System.out.println("Introduce el nombre del presidente");
		String presidente = sc.nextLine();
		equipo = new Equipo(nombre,generarJugadores(),generarEntrenador(),ciudad,LocalDate.of(1985, 12, 1), 2000000,presidente,null,0);

		equipos.add(equipo);
		System.out.println("EQUIPO CREADO");
		return equipos;
	}

	/**
	 * Generar entrenador.
	 *
	 * @return the array list
	 */
	public ArrayList<Entrenador> generarEntrenador(){
		/*Entrenador*/
		Entrenador entrenador;
		ArrayList<Entrenador> entrenadores = new ArrayList<>();

		for(int i = 0; i < 1; i++) {

			entrenador = new Entrenador("Entrenador "+i);
			//entrenador = new Entrenador ("Entrenador "+contador , LocalDate.of((int) (Math.random()*(1990-1980)+1980), 12, 1), 1.80f, 81f, (int) (Math.random()*(100-50)+1), (int) (Math.random()*(100-50)+1), (int) (Math.random()*(100-50)+1), (int) (Math.random()*(100-50)+1), (int) (Math.random()*(100-50)+1));
		entrenadores.add(entrenador);
		}


		return entrenadores;
	}

	/**
	 * Jugar liga.
	 */
	public void jugarLiga() {
		for (Partido partido : partidos) {
			partido.calcularGanador();
		}
	}

	/**
	 * Ordenar partidos competicion.
	 */
	public void ordenarPartidosCompeticion() {
		for(int i = 0; i < this.equipos.size();i++) {
			for (int j = 0; j < this.equipos.size(); j++) {
				if (i != j) {
					Partido partido = new Partido(equipos.get(i),equipos.get(j));
					partidos.add(partido);
				}
			}
		}
		jugarLiga();
	}

	/**
	 * Crear clasificacion.
	 */
	public void crearClasificacion() {

		for (Equipo equipo : equipos) {
			clasificacion.add(equipo);
		}
		Collections.sort(clasificacion);
	}

	/**
	 * Mostrar clasificacion.
	 */
	public void mostrarClasificacion() {
		System.out.println("Nombre------------------Puntos-----------------Ganados--------------Empatados--------------Perdidos");
		for (Equipo equipo : clasificacion) {
			System.out.println(equipo.getNombre()+"                   "+equipo.getPuntos()+"                      "+equipo.getPartidosGanados()+
					"                    "+equipo.getPartidosEmpatados()+"                      "+equipo.getPartidosPerdidos());
		}

	}

	/**
	 * Guardar clasificacion.
	 */
	public void guardarClasificacion() {
		File file =	new File("tablas_clasificatorias.txt");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String cabecera = "Nombre------------------Puntos-----------------Ganados--------------Empatados--------------Perdidos\n";

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){

			bw.write(cabecera);
			for (Equipo equipo: clasificacion) {
				bw.write(equipo.getNombre()+"                   "+equipo.getPuntos()+"                      "+equipo.getPartidosGanados()+
						"                    "+equipo.getPartidosEmpatados()+"                      "+equipo.getPartidosPerdidos()+"\n");
			}
			bw.write("\n");
		}catch (Exception e){
			System.out.println(e);
		}
	}

	/*MENU JUGADORES*/

	/**
	 * Mostrar jugador elegido.
	 */
	public void mostrarJugadorElegido() {
		int opcion = 0;
		mostrarEquipos();
		
		do {
			System.out.println("Elige el numero del equipo donde quieras mostrar el futbolista");
			opcion = sc.nextInt();
			sc.nextLine();
		}while(opcion < 1 || opcion > equipos.size());
		
		ArrayList<Futbolista> equipo = equipos.get(opcion-1).getaEquipo();
		for(int i = 0; i< equipo.size();i++) {
			System.out.println("Jugador "+ (i+1)+equipo.get(i).getNombre()+" ->Dorsal "+equipo.get(i).getDorsal());
		}
		int jugadorElegido = 0;
		do {
			System.out.println("Elige el jugador que quieres mostrar");
			jugadorElegido = sc.nextInt();
			sc.nextLine();
			
		}while(jugadorElegido < 1 || jugadorElegido > equipo.size());
		
		System.out.println(equipo.get(jugadorElegido-1).toString());
	}
	
	/**
	 * Mostrar jugadores.
	 */
	public void mostrarJugadores() {
		int opcion = 0;
		mostrarEquipos();
		
		do {
			System.out.println("Introduce el numero de equipo para ver sus jugadores");
			opcion = sc.nextInt();
			sc.nextLine();//se limpia el buffer???
			
		}while(opcion < 0 || opcion > equipos.size());
		
		ArrayList<Futbolista> equipo = equipos.get(opcion-1).getaEquipo();
		
		for(int i = 0; i< equipo.size();i++) {
			System.out.println("Jugador "+(i+1) + "-> "+equipo.get(i).getNombre());
		}
		
	}

	/**
	 * Editar futbolista.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	public void editarFutbolista() throws InterruptedException {
		int opcion = 0;
		mostrarEquipos();

		do {
			System.out.println("Introduce el numero de equipo de donde quieres editar un jugador");
			opcion = sc.nextInt();
			sc.nextLine();

		}while(opcion < 1 || opcion > equipos.size());

		ArrayList<Futbolista> equipo = equipos.get(opcion-1).getaEquipo();

		for(int i = 0; i< equipos.size();i++) {
			System.out.println("Jugador "+ (i+1)+equipo.get(i).getNombre()+" ->Dorsal "+ equipo.get(i).getDorsal());
		}
		int jugadorElegidoEditar = 0;

		do {
			System.out.println("Elige el jugador que quieres editar");
			jugadorElegidoEditar = sc.nextInt();
			sc.nextLine();

		}while(jugadorElegidoEditar < 1 || jugadorElegidoEditar > equipo.size());

		System.out.println("Introduce el nombre del jugador");
		String nombre = sc.nextLine();
		System.out.println("Introduce la posicion(Portero,Defensa,Centrocampista,Delantero)");
		String posicion = sc.nextLine();
		System.out.println("Generando atributos de forma aleatoria");
		int num = 4;
		for (int i = num; i > 0; i--) {
			System.out.print("* ");
			Thread.sleep(1000);
		}
		int experiencia = Helper.numeroAleatorioEntreRango(1, 400);
		int dorsal = Helper.numeroAleatorioEntreRango(1, 100);

		equipos.get(opcion-1).editarJugador(new Futbolista(nombre, posicion, experiencia, dorsal),jugadorElegidoEditar-1 );
		System.out.println("Jugador editado correctamente");

	}

	/**
	 * Eliminar futbolista.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	public void eliminarFutbolista() throws InterruptedException {
		int opcion = 0;
		mostrarEquipos();

		do {
			System.out.println("Introduce el numero de equipo de donde quieres eliminar un jugador");
			opcion = sc.nextInt();
			sc.nextLine();

		}while(opcion < 1 || opcion > equipos.size());
		ArrayList<Futbolista> equipo = equipos.get(opcion-1).getaEquipo();
		for(int i = 0; i< equipos.size();i++) {
			System.out.println("Jugador "+ (i+1)+equipo.get(i).getNombre()+" ->Dorsal "+ equipo.get(i).getDorsal());
		}
		int jugadorElegidoEliminar = 0;

		do {
			System.out.println("Elige el jugador que quieres eliminar");
			jugadorElegidoEliminar = sc.nextInt();
			sc.nextLine();

		}while(jugadorElegidoEliminar < 1 || jugadorElegidoEliminar > equipo.size());
		System.out.println("Eliminando jugador");
		int num = 4;
		for (int i = num; i > 0; i--) {
			System.out.print("* ");
			Thread.sleep(1000);
		}
		equipos.get(opcion-1).eliminarFutbolista(equipo.get(jugadorElegidoEliminar-1));
		System.out.println("\nJugador eliminado correctamente");

	}

	/**
	 * Crear futbolista.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	public void crearFutbolista() throws InterruptedException{

		int opcion = 0;
		mostrarEquipos();

		do {
			System.out.println("Introduce el numero de equipo donde quieres insertar el nuevo futbolista");
			opcion = sc.nextInt();
			sc.nextLine();
		}while(opcion < 1 || opcion > equipos.size());//si opcion es menor de 1 o mayor de cantidad de equipos, vuelve a pedir un numero en el menu
		//si se elige uno dentro del rango(cantidad de equipos)eleccion correcta y continua la ejecucion
		ArrayList<Futbolista> equipo = equipos.get(opcion-1).getaEquipo();

		System.out.println("Introduce el nombre del jugador");
		String nombre = sc.nextLine();
		System.out.println("Introduce la posicion(Portero,Defensa,Centrocampista,Delantero");
		String posicion = sc.nextLine();
		System.out.println("Generando atributos de forma aleatoria");
		int num = 4;
		for (int i = num; i > 0; i--) {
			System.out.print("* ");
			Thread.sleep(1000);
		}
		int experiencia = Helper.numeroAleatorioEntreRango(1, 400);
		int dorsal = Helper.numeroAleatorioEntreRango(1, 100);

		boolean dorsalRepetido = false;
		for(Futbolista futbolista: equipo){
			if(futbolista.getDorsal() == dorsal) {
				dorsalRepetido = true;
			}
		}

		if(dorsalRepetido) {
			System.out.println("\nNo se ha podido insertar el futbolista porque ya existe ese dorsal");
		}else {
			System.out.println("\nJugador insertado correctamente");
			equipos.get(opcion-1).anyadirFutbolista(new Futbolista(nombre, posicion, experiencia, dorsal));
		}

	}
	

	/*MENU EQUIPOS*/
	
	/**
	 * Mostrar equipos.
	 */
	public void mostrarEquipos() {
		for (int i = 0; i < equipos.size(); i++) {
			System.out.println("Equipo numero " + (i+1) +"->"+ equipos.get(i).getNombre());
		}
	}
	
	/**
	 * Mostrar equipo.
	 */
	public void mostrarEquipo(){
        mostrarEquipos();
        System.out.println("¿Que equipo quiere que muestre sus estadisticas?");
        int option = sc.nextInt();
        System.out.println(equipos.get(option-1).toString());
    }

	/**
	 * Eliminar equipo.
	 */
	public void eliminarEquipo() {
		mostrarEquipos();
		int opcion = 0;
		do {
			System.out.println("Elige el numero de equipo que quieres eliminar");
			opcion = sc.nextInt();
			sc.nextLine();

		}while(opcion < 1 || opcion > equipos.size());
		equipos.remove(opcion-1);
		System.out.println("Equipo eliminado");
	}

	/**
	 * Editar equipo.
	 */
	public void editarEquipo(){
		mostrarEquipos();
		int opcion = 0;

		do {
			System.out.println("Elige el numero de equipo que quieres editar");
			opcion = sc.nextInt();
			sc.nextLine();

		}while(opcion < 1 || opcion > equipos.size());
		equipos.remove(opcion-1);
		System.out.println("Equipo eliminado");
	}

	/**
	 * Importar.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void importar() throws IOException {
		equipos.clear();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("equipos.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (true) {
				try{
					Equipo equipo = (Equipo) ois.readObject();
					equipos.add(equipo);
					System.out.println(equipos.size());
				}catch (EOFException exc) {
					break;
				}
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (ClassNotFoundException classNotFoundException) {
			classNotFoundException.printStackTrace();
		} finally {
			if (fis != null)
				fis.close();
		}
	}

	/**
	 * Exportar equipos.
	 */
	public void exportarEquipos(){
		try{
			FileOutputStream f = new FileOutputStream(new File("equipos.dat"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			for (Equipo equipo: equipos) {
				o.writeObject(equipo);
			}
			o.close();
			f.close();
		}catch (Exception e){
			System.out.println(e);
		}
	}



}
