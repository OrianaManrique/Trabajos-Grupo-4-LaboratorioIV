package Ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) {
		
		TreeSet<Persona> listaPersonas = new TreeSet<Persona>();
		
		Archivo archivo = new Archivo();
		
		archivo.setRuta("Personas.txt");
		
		if(!archivo.existe()) {
			System.out.println("El archivo no existe.");
			return;
		}
		
		try {
			FileReader entrada = new FileReader("Personas.txt");
			BufferedReader miBuffer = new BufferedReader(entrada);

			String linea = miBuffer.readLine();
			while (linea != null) {
				String[] parte = linea.split("-");
				if (parte.length >= 3) {
					if(validarDNI(parte[2])) {
						listaPersonas.add(new Persona(parte[0], parte[1], parte[2]));
					}
		        }
				linea = miBuffer.readLine();
			}
			miBuffer.close();
			entrada.close();
		} catch (IOException e) {
			System.out.println("No se encontró el archivo");
		}
		
		for (Persona persona : listaPersonas) {
			System.out.println(persona.toString());
		}
	}
	
	public static boolean validarDNI(String dni) {
		try {
			DniInvalido.verificarDniInvalido(dni);
			return true;
		} catch (InvalidDniException e) {
			return false;			
		}
	}
	
}
