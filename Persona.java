package crearConfigYSerializarClases;

import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Serializable{
	
	private String nombre;// Modificador de acceso private ,  Nombre entrenador.
	private LocalDate fechaNacimiento;//Fecha de nacimineto.
	private float altura; 
	private float peso;
	private int experiencia;//Numero acumulativo.
	private float sueldo;//Sueldo.
	
	
	
	public Persona() {//constructor vac�o 
		this.nombre="";
		this.fechaNacimiento=null;
		this.altura=0;
		this.peso=0;
		this.experiencia=0;
		this.sueldo=0;
	}
	
	public Persona(Persona p) { // constructor copia
		this.nombre=p.getNombre();
		this.fechaNacimiento=p.getFechaNacimiento();
		this.altura=p.getAltura();
		this.peso=p.getPeso();
		this.experiencia=p.getExperiencia();
		this.sueldo=p.getSueldo();
	}
	
	
	
	public Persona(String nombre, LocalDate fechaNacimiento, float altura, float peso, int experiencia,
			float sueldo) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.altura = altura;
		this.peso = peso;
		this.experiencia = experiencia;
		this.sueldo = sueldo;
	}
	

	public Persona(String nombre) {
		this.nombre = nombre;
	}
	
	
	public void copiar(Persona p) {
		this.nombre=p.getNombre();
		this.fechaNacimiento=p.getFechaNacimiento();
		this.altura=p.getAltura();
		this.peso=p.getPeso();
		this.experiencia=p.getExperiencia();
		this.sueldo=p.getSueldo();
				
	}

//	@Override
//	public boolean equals(Object persona) {
//		boolean iguales=false;
//		if(persona != null) {
//			if( this.fechaNacimiento != null ) {
//				if( this.nombre.equals( ( (Persona)persona ).getNombre() ) && this.fechaNacimiento.equals( ((Persona)persona).getFechaNacimiento())  ) {
//					iguales=true;
//				}
//			}
//		}
//		
//		return iguales;
//	}
	
	
	public void modificarExperiencia(int exp) {
		this.experiencia += exp;
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
	 * @return the fechaNacimiento
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * @return the altura
	 */
	public float getAltura() {
		return altura;
	}
	/**
	 * @param altura the altura to set
	 */
	public void setAltura(float altura) {
		this.altura = altura;
	}
	/**
	 * @return the peso
	 */
	public float getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(float peso) {
		this.peso = peso;
	}
	/**
	 * @return the experiencia
	 */
	public int getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	/**
	 * @return the sueldo
	 */
	public float getSueldo() {
		return sueldo;
	}
	/**
	 * @param sueldo the sueldo to set
	 */
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", altura=" + altura + ", peso="
				+ peso + ", experiencia=" + experiencia +", sueldo=" + sueldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(altura);
		result = prime * result + experiencia;
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + Float.floatToIntBits(peso);
		result = prime * result + Float.floatToIntBits(sueldo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (Float.floatToIntBits(altura) != Float.floatToIntBits(other.altura))
			return false;
		if (experiencia != other.experiencia)
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Float.floatToIntBits(peso) != Float.floatToIntBits(other.peso))
			return false;
		if (Float.floatToIntBits(sueldo) != Float.floatToIntBits(other.sueldo))
			return false;
		return true;
	}
	
	

}
