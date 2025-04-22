package Ejercicio1;

import java.util.Iterator;
import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) throws DniInvalido {

		Archivo archivoPersonas = new Archivo();
		archivoPersonas.setRuta("Personas.txt");

		Archivo archivoResultado = new Archivo();
		archivoResultado.setRuta("Resultado.txt");

		if (archivoPersonas.existe()) {
			TreeSet<Persona> listaPersonas = new TreeSet<Persona>();

			try {
				listaPersonas = Archivo.GuardarArchivoenTreeSet(listaPersonas, "Personas.txt");
				archivoResultado.creaArchivo();
				Archivo.sobreEscribir_lineas(listaPersonas, "Resultado.txt");

				Persona.Mostrar(listaPersonas);

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ERROR - NO SE PUDO GUARDAR EL ARRAYLIST");
			}

		} else {
			System.out.println("No existe el archivo");
			archivoPersonas.creaArchivo();
		}

	}

}