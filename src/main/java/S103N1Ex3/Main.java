package S103N1Ex3;
import java.io.IOException;
import java.util.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        // Leer el archivo y guardar los datos en un HashMap
        Map<String, String> paisesCapitales = leerArchivo();

        // Pedir el nombre del usuario
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombreUsuario = input.nextLine();

        // Juego de adivinar las capitales
        int puntuacion = 0;
        for (int i = 0; i < 10; i++) {
            String paisAleatorio = obtenerPaisAleatorio(paisesCapitales);
            String capital = paisesCapitales.get(paisAleatorio);

            System.out.println("Adivina la capital del país: " + paisAleatorio);
            String respuestaUsuario = input.nextLine();

            if (respuestaUsuario.equalsIgnoreCase(capital)) {
                System.out.println("¡Respuesta correcta!");
                puntuacion++;
            } else {
                System.out.println("Respuesta incorrecta. La capital es: " + capital);
            }
        }

        // Guardar el nombre del usuario y su puntuación en un archivo
        guardarPuntuacion(nombreUsuario, puntuacion);

        System.out.println("Juego terminado. Puntuación: " + puntuacion);
    }
    private static Map<String, String> leerArchivo() {
        Map<String, String> paisesCapitales = new HashMap<>();

        try {
            List<String> lineas = Files.readAllLines(Paths.get("src/main/resources/" + "countries.txt"));
            for (String linea : lineas) {
                if (!linea.isEmpty()) {
                    String[] datos = linea.split(",");
                    if (datos.length >= 2) {
                        String pais = datos[0].trim();
                        String capital = datos[1].trim();
                        paisesCapitales.put(pais, capital);
                    } else {
                        System.out.println("Error: línea inválida en el archivo: " + linea);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return paisesCapitales;
    }
         // Función para obtener un país aleatorio del HashMap
    private static String obtenerPaisAleatorio(Map<String, String> paisesCapitales) {
        List<String> paises = new ArrayList<>(paisesCapitales.keySet());

        if (paises.isEmpty()) {
            System.out.println("Error: No se encontraron países en el archivo.");
            System.exit(0); // Salir del programa
        }

        Random random = new Random();
        int indice = random.nextInt(paises.size());
        return paises.get(indice);
    }

    // Función para guardar la puntuación en un archivo
    private static void guardarPuntuacion(String nombreUsuario, int puntuacion) {
        try {
            String contenido = nombreUsuario + "," + puntuacion + System.lineSeparator();
            Files.write(Paths.get("clasificacion.txt"), contenido.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
