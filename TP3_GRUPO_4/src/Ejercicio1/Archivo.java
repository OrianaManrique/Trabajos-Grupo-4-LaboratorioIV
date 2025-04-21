package Ejercicio1;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class Archivo {

	private String ruta;

	public boolean existe() {
		File archivo = new File(ruta);
		if (archivo.exists())
			return true;
		return false;
	}

	public boolean creaArchivo() {
		FileWriter escritura;
		try {
			escritura = new FileWriter(ruta, true);
			escritura.write("");
			escritura.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}
     
	
	public boolean borrarArchivo()
	{   
		File archivo = new File(ruta);
		if (archivo.delete()) {
			return true;
		} else {
			return false;
		}	
	}
	
	public void escribir_lineas(String frase) {
		try {
			FileWriter entrada = new FileWriter(ruta, true);
			BufferedWriter miBuffer = new BufferedWriter(entrada);
			miBuffer.write(frase);
			miBuffer.close();
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void leer_lineas() {
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);

			String linea = "";
			while (linea != null) {
				System.out.println(linea);
				linea = miBuffer.readLine();
			}

			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			System.out.println("No se encontró el archivo");
		}
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public static TreeSet<Persona> GuardarArchivoenTreeSet(TreeSet<Persona> ListaAuxiliar, String ruta)
			throws ArrayIndexOutOfBoundsException {

		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);

			String linea = "";
			while (linea != null) {
				linea = miBuffer.readLine();
				if (linea != null) {
					String[] partes = linea.split("-");
					if (partes.length == 3) {
						try {
							if (Persona.verificarDniInvalido(partes[2])) {
								String NombreAux = partes[0];
								String ApellidoAux = partes[1];
								String DniAux = partes[2];
								Persona auxPersona = new Persona(NombreAux, ApellidoAux, DniAux);
								ListaAuxiliar.add(auxPersona);
							}
						} catch (IOException e) {

						}
					}
				}
			}

			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			System.out.println("No se encontro el archivo");
		}

		return ListaAuxiliar;
	}
}
