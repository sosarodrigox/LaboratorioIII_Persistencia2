import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class CadenaDeCaracteres {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String txtEntrada = "D:\\OneDrive - frp.utn.edu.ar\\JAVA_workspace\\LaboratorioIII_Persistencia2\\src\\Entrada.txt";
		String txtSalida = "D:\\OneDrive - frp.utn.edu.ar\\JAVA_workspace\\LaboratorioIII_Persistencia2\\src\\Salida.txt";

		String[] linea; // Array de String que guarda la linea.
		HashSet<String> hs1 = new HashSet<String>(); // Guarda la colección de datos. Puede ser cualquier colección
														// (List, Map, etc.)
		File archivo = new File(txtEntrada);

		// Si el archivo no existe es creado:
		if (!archivo.exists()) {
			JOptionPane.showMessageDialog(null, "El archivo no existe");
		} else {
			metodoRLinea(hs1, txtEntrada); // readLine()
			metodoWLinea(hs1, txtSalida); // writer
		}
	}

	private static void metodoRLinea(HashSet<String> hs1, String nombreTxtEntrada) {
		// TODO Auto-generated method stub
		int numReg = 0; // Número de registro.

		try {
			FileReader entrada = new FileReader(nombreTxtEntrada);
			BufferedReader bufferLectura = new BufferedReader(entrada); // Creo el buffer de lectura
			String salida = "";
			String linea = "";
			while (linea != null) {
				linea = bufferLectura.readLine(); // Leo una linea
				if (linea != null) {
					salida += numReg + "- Linea leída que representa: " + linea + "\n";
					hs1.add(linea + "\n");
					++numReg;
				}
			}
			JOptionPane.showMessageDialog(null, salida);
			entrada.close(); // close the stream
			bufferLectura.close(); // close the buffer
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private static void metodoWLinea(HashSet<String> hs1, String nombreSalida) {
		// TODO Auto-generated method stub
		try {
			File archivo = new File(nombreSalida);

			// Si el archivo no existe es creado:
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			FileWriter salida = new FileWriter(nombreSalida);
			BufferedWriter bufferEscritura = new BufferedWriter(salida);
			for (Iterator<String> it = hs1.iterator(); it.hasNext();) {
				String txt = (String) it.next();
				bufferEscritura.write(txt);// Escribe una linea.
				bufferEscritura.newLine();// Busca una nueva linea.
				bufferEscritura.flush();// Vacia el buffer.
			}
			bufferEscritura.close(); // Cierra la conexión con el buffer.
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
