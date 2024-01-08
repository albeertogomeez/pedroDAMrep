package ejercicio2;

import java.util.Arrays;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

        List<String> nombres = Arrays.asList("Juan", "Maria", "Pedro", "Ana", "Carlos", "Alberto", "Ramon", "Mario");

        // Mapear cada nombre a su longitud
        List<Integer> longitudes = nombres.stream()
                .map(nombre -> nombre.length())
                .toList();

        System.out.println("Lista de longitudes: " + longitudes);

        // Calcular la suma de todas las longitudes
        int sumaLongitudes = longitudes.stream()
                .reduce(0, Integer::sum);

        System.out.println("Suma de longitudes: " + sumaLongitudes);
    }
}