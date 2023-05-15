package S103N2Ex1;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Restaurante> restaurantes = new HashSet<>();

        // Agregar objetos Restaurante al HashSet
        Restaurante restaurante1 = new Restaurante("Restaurante A", 4);
        Restaurante restaurante2 = new Restaurante("Restaurante B", 3);
        Restaurante restaurante3 = new Restaurante("Restaurante A", 5);

        restaurantes.add(restaurante1);
        restaurantes.add(restaurante2);
        restaurantes.add(restaurante3);

        // Imprimir los restaurantes en el HashSet
        for (Restaurante restaurante : restaurantes) {
            System.out.println("Restaurante: " + restaurante.getNombre() + ", Puntuación: " + restaurante.getPuntuacion());
        }
    }
}

