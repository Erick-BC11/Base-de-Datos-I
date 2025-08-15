import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ManejoArchivos {
    public static void main(String[] args) {
        String archivoCSV = "C:\\Users\\buscr\\Downloads\\codigos_postales_hmo.csv";
        String linea;
        String separador = ","; // Es por si se llegó a usar otro separador en el CSV, como ";"

        // Usamos la estructura de datos de "TreeMap" para ordenar los códigos postales de menor a mayor como lo pide el ejercicio
        Map<Integer, Integer> contadorCodigos = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(separador);
                if (datos.length < 2) continue; // Para evitar errores

                // Convertir el código postal a número
                int codigoPostal = Integer.parseInt(datos[0].trim());

                // Incrementar el contador
                contadorCodigos.put(codigoPostal, contadorCodigos.getOrDefault(codigoPostal, 0) + 1);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Imprime los resultados en orden, tal y como lo pide el ejercicio
        for (Map.Entry<Integer, Integer> entry : contadorCodigos.entrySet()) {
            System.out.println("Código postal: " + entry.getKey() + " - Número de asentamientos: " + entry.getValue());
        }
    }
}