package ejercicio5;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Principal {

	public static void main(String[] args) {

        // Crear una lista grande de números enteros
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                                             11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        // Especificar el número de partes en las que se dividirá la lista
        int numPartes = 4;

        // Calcular el tamaño de cada parte
        int tamañoParte = numeros.size() / numPartes;

        // Utilizar ForkJoinPool para realizar el cálculo en paralelo
        ForkJoinPool forkJoinPool = new ForkJoinPool(numPartes);

        // Dividir la lista en partes
        List<List<Integer>> partes = splitList(numeros, tamañoParte);

        // Calcular la suma de cada parte en paralelo
        List<Integer> resultadosParciales = forkJoinPool.submit(() ->
                partes.parallelStream()
                        .map(part -> part.stream().mapToInt(Integer::intValue).sum())
                        .collect(Collectors.toList())
        ).join();

        // Mostrar los resultados parciales
        System.out.println("Resultados parciales: " + resultadosParciales);

        // Calcular la suma total de los resultados parciales
        int sumaTotal = resultadosParciales.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Suma total de los resultados parciales: " + sumaTotal);
    }

    // Método para dividir una lista en partes
    private static List<List<Integer>> splitList(List<Integer> lista, int tamañoParte) {
        return IntStream.range(0, (lista.size() + tamañoParte - 1) / tamañoParte)
                .mapToObj(i -> lista.subList(i * tamañoParte, Math.min((i + 1) * tamañoParte, lista.size())))
                .collect(Collectors.toList());
    }
}
