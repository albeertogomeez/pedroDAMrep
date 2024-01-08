package ejercicio1;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Principal {

	public static void main(String[] args) {

		List<Integer> numeros = List.of(1, 2, 3, 5, 7, 8, 11, 13, 17, 19, 23, 29, 45, 76, 89, 93, 100, 120);

        List<Integer> primos = numeros.stream()
                .filter(esPrimo())
                .sorted((a, b) -> b - a) // Ordenar de mayor a menor
                .collect(Collectors.toList());

        System.out.println("Los números primos que hay en la lista, ordenados de mayor a menor: " + primos);
    }

    private static Predicate<Integer> esPrimo() {
        return num -> {
            if (num < 2) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        };
    }
}
