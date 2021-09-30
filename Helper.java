package crearConfigYSerializarClases;

public class Helper {

	public static int numeroAleatorioEntreRango(int inicio, int fin) {
		int numero;
		numero = (int) Math.floor(Math.random()*(fin-inicio)+inicio);
		return numero;
	}
}
