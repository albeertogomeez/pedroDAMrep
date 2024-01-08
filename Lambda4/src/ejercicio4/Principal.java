package ejercicio4;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        try {
            // Ruta al archivo CSV
            String archivoCSV = "productos.csv";

            // Utilizar Apache Commons CSV para leer el archivo CSV con encabezados personalizados
            Reader lector = new FileReader(archivoCSV);
            CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(lector);

            // Obtener los registros del CSV y calcular el precio medio utilizando una función lambda
            double precioMedio = csvParser.getRecords().stream()
                    .mapToDouble(record -> Double.parseDouble(record.get("precio")))
                    .average()
                    .orElse(0);

            // Mostrar el resultado en la consola
            System.out.println("Precio medio de los productos: " + precioMedio);

            // Cerrar el lector
            lector.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
