import java.util.Scanner;

public class ListasArreglos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Crear Vector de Personas");
            System.out.println("2. Crear Matriz de Personas");
            System.out.println("3. Crear Lista de Personas");
            System.out.println("4. Crear Pila de Personas");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    gestionarVector(scanner);
                    break;
                case 2:
                    gestionarMatriz(scanner);
                    break;
                case 3:
                    gestionarLista(scanner);
                    break;
                case 4:
                    gestionarPila(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void gestionarVector(Scanner scanner) {
        System.out.print("Tamaño del vector: ");
        int tamaño = scanner.nextInt();
        scanner.nextLine();
        vectores vector = new vectores(tamaño, -1);

        while (true) {
            System.out.println("\n--- Vector ---");
            System.out.println("1. Ingresar secuencial");
            System.out.println("2. Agregar por posición");
            System.out.println("3. Mostrar");
            System.out.println("4. Buscar por nombre");
            System.out.println("5. Eliminar por nombre");
            System.out.println("6. Modificar por nombre");
            System.out.println("7. Promedio de peso");
            System.out.println("8. Promedio de altura");
            System.out.println("9. Volver");
            System.out.print("Opción: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    vector.ingresarPersonaSecuencial(crearPersona(scanner));
                    break;
                case 2:
                    System.out.print("Posición: ");
                    int pos = scanner.nextInt();
                    scanner.nextLine();
                    vector.agregarPersonaPorPosicion(crearPersona(scanner), pos);
                    break;
                case 3:
                    vector.mostrarVector();
                    break;
                case 4:
                    System.out.print("Nombre a buscar: ");
                    String nombre = scanner.nextLine();
                    persona p = vector.buscarPorNombre(nombre);
                    if (p != null) {
                        System.out.println("Encontrado: " + p);
                    } else {
                        System.out.println("No encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Nombre a eliminar: ");
                    nombre = scanner.nextLine();
                    if (vector.eliminarPorNombre(nombre)) {
                        System.out.println("Persona eliminada.");
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;
                case 6:
                    System.out.print("Nombre a modificar: ");
                    nombre = scanner.nextLine();
                    if (vector.modificarPorNombre(nombre, scanner)) {
                        System.out.println("Persona modificada.");
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;
                case 7:
                    System.out.printf("Promedio de peso: %.2f kg%n", vector.calcularPromedioPeso());
                    break;
                case 8:
                    System.out.printf("Promedio de altura: %.2f m%n", vector.calcularPromedioAltura());
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void gestionarMatriz(Scanner scanner) {
        System.out.print("Filas: ");
        int filas = scanner.nextInt();
        System.out.print("Columnas: ");
        int columnas = scanner.nextInt();
        scanner.nextLine();
        Matriz matriz = new Matriz(filas, columnas, -1, -1);

        while (true) {
            System.out.println("\n--- Matriz ---");
            System.out.println("1. Ingresar secuencial");
            System.out.println("2. Agregar por posición");
            System.out.println("3. Mostrar");
            System.out.println("4. Buscar por nombre");
            System.out.println("5. Eliminar por nombre");
            System.out.println("6. Modificar por nombre");
            System.out.println("7. Promedio de peso");
            System.out.println("8. Promedio de altura");
            System.out.println("9. Volver");
            System.out.print("Opción: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    matriz.ingresarPersonaSecuencial(crearPersona(scanner));
                    break;
                case 2:
                    System.out.print("Fila: ");
                    int f = scanner.nextInt();
                    System.out.print("Columna: ");
                    int c = scanner.nextInt();
                    scanner.nextLine();
                    matriz.agregarPersonaPorPosicion(crearPersona(scanner), f, c);
                    break;
                case 3:
                    matriz.mostrarMatriz();
                    break;
                case 4:
                    System.out.print("Nombre a buscar: ");
                    String nombre = scanner.nextLine();
                    persona p = matriz.buscarPorNombre(nombre);
                    if (p != null) {
                        System.out.println("Encontrado: " + p);
                    } else {
                        System.out.println("No encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Nombre a eliminar: ");
                    nombre = scanner.nextLine();
                    if (matriz.eliminarPorNombre(nombre)) {
                        System.out.println("Persona eliminada.");
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;
                case 6:
                    System.out.print("Nombre a modificar: ");
                    nombre = scanner.nextLine();
                    if (matriz.modificarPorNombre(nombre, scanner)) {
                        System.out.println("Persona modificada.");
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;
                case 7:
                    System.out.println("\n--- Tipo de diagonal ---");
                    System.out.println("1. Principal");
                    System.out.println("2. Secundaria");
                    System.out.println("3. Ambas");
                    System.out.print("Opción: ");
                    int tipoPeso = scanner.nextInt();
                    scanner.nextLine();
                    double promPeso = 0.0;
                    switch (tipoPeso) {
                        case 1:
                            promPeso = matriz.calcularPromedioPesoPrincipal();
                            break;
                        case 2:
                            promPeso = matriz.calcularPromedioPesoSecundaria();
                            break;
                        case 3:
                            promPeso = matriz.calcularPromedioPesoAmbas();
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            continue;
                    }
                    System.out.printf("Promedio de peso: %.2f kg%n", promPeso);
                    break;

                case 8:
                    System.out.println("\n--- Tipo de diagonal ---");
                    System.out.println("1. Principal");
                    System.out.println("2. Secundaria");
                    System.out.println("3. Ambas");
                    System.out.print("Opción: ");
                    int tipoAltura = scanner.nextInt();
                    scanner.nextLine();
                    double promAltura = 0.0;
                    switch (tipoAltura) {
                        case 1:
                            promAltura = matriz.calcularPromedioAlturaPrincipal();
                            break;
                        case 2:
                            promAltura = matriz.calcularPromedioAlturaSecundaria();
                            break;
                        case 3:
                            promAltura = matriz.calcularPromedioAlturaAmbas();
                            break;
                    }
                    System.out.printf("Promedio de altura: %.2f m%n", promAltura);
                    break;
                case 9:
                    return; // Esto sale del método y vuelve al menú principal
                default:
                    System.out.println("Opción inválida.");
            }

        }
    }

    private static void gestionarLista(Scanner scanner) {
        lista miLista = new lista();

        while (true) {
            System.out.println("\n--- Lista ---");
            System.out.println("1. Ingresar secuencial");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar por nombre");
            System.out.println("4. Eliminar por nombre");
            System.out.println("5. Modificar por nombre");
            System.out.println("6. Promedio de peso");
            System.out.println("7. Promedio de altura");
            System.out.println("8. Volver");
            System.out.print("Opción: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    miLista.AgregarPersona(crearPersona(scanner));
                    break;
                case 2:
                    miLista.mostrarLista();
                    break;
                case 3:
                    System.out.print("Nombre a buscar: ");
                    String nombre = scanner.nextLine();
                    persona p = miLista.buscarPorNombre(nombre);
                    if (p != null) {
                        System.out.println("Encontrado: " + p);
                    } else {
                        System.out.println("No encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nombre a eliminar: ");
                    nombre = scanner.nextLine();
                    if (miLista.eliminarPorNombre(nombre)) {
                        System.out.println("Persona eliminada.");
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;
                case 5:
                    System.out.print("Nombre a modificar: ");
                    nombre = scanner.nextLine();
                    if (miLista.modificarPorNombre(nombre, scanner)) {
                        System.out.println("Persona modificada.");
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;
                case 6:
                    System.out.printf("Promedio de peso: %.2f kg%n", miLista.calcularPromedioPeso());
                    break;
                case 7:
                    System.out.printf("Promedio de altura: %.2f m%n", miLista.calcularPromedioAltura());
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void gestionarPila(Scanner scanner) {
        System.out.print("Capacidad inicial: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();
        pilaPersonas pila = new pilaPersonas(capacidad);

        while (true) {
            System.out.println("\n--- Pila ---");
            System.out.println("1. Apilar");
            System.out.println("2. Desapilar");
            System.out.println("3. Mostrar");
            System.out.println("4. Buscar por nombre");
            System.out.println("5. Eliminar por nombre");
            System.out.println("6. Modificar por nombre");
            System.out.println("7. Promedio de peso");
            System.out.println("8. Promedio de altura");
            System.out.println("9. Volver");
            System.out.print("Opción: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    pila.apilar(crearPersona(scanner));
                    break;
                case 2:
                    persona desapilada = pila.desapilar();
                    if (desapilada != null) {
                        System.out.println("Desapilado: " + desapilada);
                    }
                    break;
                case 3:
                    pila.mostrarPila();
                    break;
                case 4:
                    System.out.print("Nombre a buscar: ");
                    String nombre = scanner.nextLine();
                    persona p = pila.buscarPorNombre(nombre);
                    if (p != null) {
                        System.out.println("Encontrado: " + p);
                    } else {
                        System.out.println("No encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Nombre a eliminar: ");
                    nombre = scanner.nextLine();
                    if (pila.eliminarPorNombre(nombre)) {
                        System.out.println("Persona eliminada.");
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;
                case 6:
                    System.out.print("Nombre a modificar: ");
                    nombre = scanner.nextLine();
                    if (pila.modificarPorNombre(nombre, scanner)) {
                        System.out.println("Persona modificada.");
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;
                case 7:
                    System.out.printf("Promedio de peso: %.2f kg%n", pila.calcularPromedioPeso());
                    break;
                case 8:
                    System.out.printf("Promedio de altura: %.2f m%n", pila.calcularPromedioAltura());
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static persona crearPersona(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Peso (kg): ");
        float peso = scanner.nextFloat();
        System.out.print("Altura (cm): ");
        float altura = scanner.nextFloat();
        scanner.nextLine();
        return new persona(nombre, apellido, peso, altura);
    }
}
