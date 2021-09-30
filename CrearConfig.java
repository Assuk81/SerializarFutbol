package crearConfigYSerializarClases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CrearConfig {
	
	
	public CrearConfig(String config) {
		
	}

	static void crearConfig(String seleccion) {
		
		Properties configuracion = new Properties();
		
		configuracion.setProperty("Serializar", seleccion);
		try  {
			
			configuracion.store(new FileOutputStream("configuracion.props"),"Fichero de config");
			
		} catch (FileNotFoundException fnfe ) { 
		  fnfe.printStackTrace(); 
		} catch (IOException ioe) { 
		  ioe.printStackTrace();
		}

		
	}
	
	
	static String leerConfig() {
		Properties configuracion = new Properties();
		String serializar="";
		  
		
		try {
		  configuracion.load(new FileInputStream("configuracion.props"));
		  
		  serializar = configuracion.getProperty("Serializar");
		  
		} catch (FileNotFoundException fnfe ) { 
		  fnfe.printStackTrace();
		} catch (IOException ioe) { 
		  ioe.printStackTrace();
		}
		return serializar;
	}
}
