package crearConfigYSerializarClases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class SerializarClase {

	static ArrayList<Futbolista> futbolistas = new ArrayList<>();
	static ArrayList<Equipo> equipos = new ArrayList<>();
	static ArrayList<Entrenador> entrenadores = new ArrayList<>();
	
	public static void main(String[] args) {
		ArrayList<Futbolista>futbolistasLeidos;
		ArrayList<Equipo>equiposLeidos;
		ArrayList<Entrenador>entrenadoresLeidos;
		String opcion = "Entrenador";

		generarFutbolistas();
		generarEquipos();
		generarEntrenador();
		
		CrearConfig.crearConfig(opcion);
			
		String config = CrearConfig.leerConfig();

		switch(config) {
		case "Futbolista":
			outputSerializar(futbolistas);
		break;
		case "Equipo":
			outputSerializar(equipos);
		break;
		case "Entrenador":
			outputSerializar(entrenadores);
		break;
		}
		
		System.out.println("Datos guardados correctamente");
		
		switch(config) {
		case "Futbolista":
			futbolistasLeidos = (ArrayList<Futbolista>)inputSerializar();
			for (Futbolista futbolista : futbolistasLeidos) {
				System.out.println(futbolista.toString());
			}
		break;
		case "Equipo":
			equiposLeidos = (ArrayList<Equipo>)inputSerializar();
			for (Equipo equipo : equiposLeidos) {
				System.out.println(equipo.toString());
			}
		break;
		case "Entrenador":
			entrenadoresLeidos = (ArrayList<Entrenador>)inputSerializar();
			for (Entrenador entrenador : entrenadoresLeidos) {
				System.out.println(entrenador.toString());
			}
		break;
		}
	}

	public static Object inputSerializar() {
		
		FileInputStream fichero = null;
		ObjectInputStream serializador = null;
		Object objeto = null;
		
		try {
			fichero = new FileInputStream("futbol.ddr");
			serializador = new ObjectInputStream(fichero);
			
			objeto = serializador.readObject();
		
		} catch (FileNotFoundException fnfe) {
			System.out.println("No se encuentra el fichero especificado");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Tipo de objeto no conocido");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (serializador != null) 
				try {
					serializador.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
		}
		return objeto;
	}
	
	public static void outputSerializar(Object objeto) {
		
		FileOutputStream fichero = null;
		ObjectOutputStream serializador = null;
		try {
			fichero = new FileOutputStream("futbol.ddr");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			serializador = new ObjectOutputStream(fichero);
            serializador.writeObject(objeto);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (serializador != null) {
				try {
					serializador.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}
	
	public static ArrayList<Futbolista> generarFutbolistas(){
		
		//Creamos futbolistas y los metemos en un arraylist
		
		String[] posicion = {"Portero","Defensa","Centro","Delantero"};
				
		for (int i = 0; i < 12; i++) {

			int aleatorio = Helper.numeroAleatorioEntreRango(0, 3);
			int experiencia = Helper.numeroAleatorioEntreRango(1, 100);
			int dorsal = Helper.numeroAleatorioEntreRango(1, 100);
					
			Futbolista f = new Futbolista("Futbolista " + (i+1), posicion[aleatorio], experiencia, dorsal);
			futbolistas.add(f);
		}
		return futbolistas;
	}
	public static ArrayList<Equipo> generarEquipos(){
		//creamos equipos
		
		for (int i = 0; i < 2; i++) {
			Equipo equipo = new Equipo("Equipo "+(i+1),generarFutbolistas(),generarEntrenador(),"Ciudad "+(i+1),LocalDate.of(1985, 12, 1), 2000000,"Presidente "+(i+1),null,0);
			equipos.add(equipo);
		}
		
		return equipos;
	}
	
	public static ArrayList<Entrenador> generarEntrenador(){
		
		for (int i = 0; i < 2; i++) {
			Entrenador entrenador = new Entrenador("Entrenador "+(i+1));
			entrenadores.add(entrenador);
		}
		return entrenadores;
	}
}






















