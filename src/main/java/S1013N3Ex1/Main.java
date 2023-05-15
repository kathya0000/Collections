package S1013N3Ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Persona> personas = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        Scanner input = new Scanner(System.in);

        do {
            mostrarMenu();
            opcion = input.nextInt();
            input.nextLine(); // Consumir el salto de línea después de leer la opción

            switch (opcion) {
                case 1:
                    introducirPersona();
                    break;
                case 2:
                    mostrarPersonasOrdenadasPorNombreAZ();
                    break;
                case 3:
                    mostrarPersonasOrdenadasPorNombreZA();
                    break;
                case 4:
                    mostrarPersonasOrdenadasPorApellidoAZ();
                    break;
                case 5:
                    mostrarPersonasOrdenadasPorApellidoZA();
                    break;
                case 6:
                    mostrarPersonasOrdenadasPorDniAsc();
                    break;
                case 7:
                    mostrarPersonasOrdenadasPorDniDesc();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("1.- Introducir persona.");
        System.out.println("2.- Mostrar a las personas ordenadas por nombre (AZ).");
        System.out.println("3.- Mostrar a las personas ordenadas por nombre (ZA).");
        System.out.println("4.- Mostrar a las personas ordenadas por apellidos (AZ).");
        System.out.println("5.- Mostrar a las personas ordenadas por apellidos (ZA).");
        System.out.println("6.- Mostrar a las personas ordenadas por DNI (1-9).");
        System.out.println("7.- Mostrar a las personas ordenadas por DNI (9-1).");
        System.out.println("0.- Salir.");
        System.out.print("Selecciona una opción: ");
    }

    private static void introducirPersona() {
        Scanner input = new Scanner(System.in);

        System.out.print("Introduce el nombre: ");
        String nombre = input.nextLine();

        System.out.print("Introduce el apellido: ");
        String apellido = input.nextLine();

        System.out.print("Introduce el DNI: ");
        String dni = input.nextLine();

        Persona persona = new Persona(nombre, apellido, dni);
        personas.add(persona);

        System.out.println("Persona agregada correctamente.\n");
    }



    private static void mostrarPersonasOrdenadasPorNombreAZ() {
        Collections.sort(personas, Comparator.comparing(Persona::getNombre));
        mostrarPersonas();
    }

    private static void mostrarPersonasOrdenadasPorNombreZA() {
        Collections.sort(personas, Comparator.comparing(Persona::getNombre).reversed());
        mostrarPersonas();
    }

    private static void mostrarPersonasOrdenadasPorApellidoAZ() {
        Collections.sort(personas, Comparator.comparing(Persona::getApellido));
        mostrarPersonas();
    }

    private static void mostrarPersonasOrdenadasPorApellidoZA() {
        Collections.sort(personas, Comparator.comparing(Persona::getApellido).reversed());
        mostrarPersonas();
    }

    private static void mostrarPersonasOrdenadasPorDniAsc() {
        Collections.sort(personas, Comparator.comparing(Persona::getDni));
        mostrarPersonas();
    }

    private static void mostrarPersonasOrdenadasPorDniDesc() {
        Collections.sort(personas, Comparator.comparing(Persona::getDni).reversed());
        mostrarPersonas();
    }

    private static void mostrarPersonas() {
        System.out.println("\n___Nombre___ ____Apellidos___ __NIF__");

        for (Persona persona : personas) {
            System.out.println(persona.getNombre() + " " + persona.getApellido() + " " + persona.getDni());
        }

        System.out.println();
    }
}

