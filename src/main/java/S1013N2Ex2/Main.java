package S1013N2Ex2;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Restaurante> restaurantes = new TreeSet<>(Comparator
                .comparing(Restaurante::getNombre)
                .thenComparingInt(Restaurante::getPuntuacion));

        Restaurante restaurante1 = new Restaurante("Restaurante A", 4);
        Restaurante restaurante2 = new Restaurante("Restaurante B", 3);
        Restaurante restaurante3 = new Restaurante("Restaurante A", 5);

        restaurantes.add(restaurante1);
        restaurantes.add(restaurante2);
        restaurantes.add(restaurante3);

        for (Restaurante restaurante : restaurantes) {
            System.out.println(restaurante);
        }
    }
}