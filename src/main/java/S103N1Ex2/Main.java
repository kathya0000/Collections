package S103N1Ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        // Crear y rellenar el primer List<Integer> utilizando Arrays.asList()
        List<Integer> primeraLista = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Crear el segundo List<Integer>
        List<Integer> segundaLista = new ArrayList<>();

        // Utilizar ListIterator para leer los elementos de la primera lista e insertarlos en la segunda en orden inverso
        ListIterator<Integer> iterador = primeraLista.listIterator(primeraLista.size());
        while (iterador.hasPrevious()) {
            int elemento = iterador.previous();
            segundaLista.add(elemento);
        }

        // Imprimir el contenido de la segunda lista
        System.out.println("Contenido de la segunda lista:");
        for (int elemento : segundaLista) {
            System.out.println(elemento);
        }
    }
}
