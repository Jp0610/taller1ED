import java.util.Scanner;

public class menu {

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        vectores vector = new vectores(5); 
        int opcion = 0;

        do {
            System.out.println("\n=== Bienvenido al sistema de gestión de personas ===");
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Eliminar persona");
            System.out.println("4. Buscar persona");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: // Agregar persona
                    if (!vector.vectorLleno()) {
                        System.out.print("Ingrese el nombre: ");
                        String nombre = scanner.next();

                        System.out.print("Ingrese el apellido: ");
                        String apellido = scanner.next();

                        System.out.print("Ingrese el peso: ");
                        float peso = scanner.nextFloat();

                        System.out.print("Ingrese la altura: ");
                        float altura = scanner.nextFloat();

                        persona Persona = new persona(nombre, apellido, peso, altura);
                        vector.agregarPersona(Persona);
                    } else {
                        System.out.println(" El vector está lleno");
                    }
                    break;

                case 2: // Mostrar personas
                    vector.mostrarVector();
                    break;

                case 3: // Eliminar persona
                    if (!vector.vectorVacio()) {
                        System.out.print("Ingrese la posición a eliminar (0 a " + (vector.getIndice()) + "): ");
                        int posicion = scanner.nextInt();
                        vector.eliminarPersona(posicion);
                    } else {
                        System.out.println(" El vector está vacío");
                    }
                    break;

                case 4: // Buscar persona
                    if (!vector.vectorVacio()) {
                        System.out.print("Ingrese el nombre de la persona a buscar: ");
                        String nombreBusqueda = scanner.next();
                        vector.buscarPersona(nombreBusqueda);
                    } else {
                        System.out.println(" El vector está vacío");
                    }
                    break;

                case 5: // Salir
                    System.out.println(" Saliendo ");
                    break;

                default:
                    System.out.println(" Opción no válida");
            }

        } while (opcion != 5);

        scanner.close();
    }
}
