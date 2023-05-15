package S103N1Ex1;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        List<Month> monthList = new ArrayList<>();

        // Creación de los objetos Month
        Month january = new Month("Enero");
        Month february = new Month("Febrero");
        Month march = new Month("Marzo");
        Month april = new Month("Abril");
        Month may = new Month("Mayo");
        Month june = new Month("Junio");
        Month july = new Month("Julio");
        Month september = new Month("Septiembre");
        Month october = new Month("Octubre");
        Month november = new Month("Noviembre");
        Month december = new Month("Diciembre");

        // Agregamos los objetos Month al List
        monthList.add(january);
        monthList.add(february);
        monthList.add(march);
        monthList.add(april);
        monthList.add(may);
        monthList.add(june);
        monthList.add(july);
        monthList.add(september);
        monthList.add(october);
        monthList.add(november);
        monthList.add(december);

        // Insertamos el objeto "Agosto" en la posición 7 (índice 6)
        monthList.add(6, new Month("Agosto"));

        // Imprimimos el contenido del List para verificar el orden
        System.out.println("Contenido del List:");
        for (Month month : monthList) {
            System.out.println(month.getName());
        }

        // Convertimos el List en un HashSet
        HashSet<Month> monthSet = new HashSet<>(monthList);

        // Verificamos que no se permitan duplicados en el HashSet
        System.out.println("\nContenido del HashSet:");
        for (Month month : monthSet) {
            System.out.println(month.getName());
        }

        // Recorremos el HashSet utilizando un iterador
        System.out.println("\nRecorrido del HashSet con un iterador:");
        Iterator<Month> iterator = monthSet.iterator();
        while (iterator.hasNext()) {
            Month month = iterator.next();
            System.out.println(month.getName());
        }
    }
}