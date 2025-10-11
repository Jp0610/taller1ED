import java.util.Stack;
import java.util.Scanner;

public class pilaPersonas {
    private Stack<persona> pilaPersonas;
    private int tope;

    public pilaPersonas(int capacidad) {
        this.pilaPersonas = new Stack<>();
        this.tope = -1;
    }

    public boolean pilaVacia() {
        return pilaPersonas.isEmpty();
    }

    public void apilar(persona p) {
        pilaPersonas.push(p);
        tope = pilaPersonas.size() - 1;
    }

    public persona desapilar() {
        if (pilaVacia()) {
            System.out.println("La pila está vacía");
            return null;
        } else {
            persona p = pilaPersonas.pop();
            tope = pilaPersonas.size() - 1;
            return p;
        }
    }

    public void mostrarPila() {
        if (pilaVacia()) {
            System.out.println("Pila vacía");
        } else {
            System.out.println("=== PILA (de fondo a tope) ===");
            Object[] copia = pilaPersonas.toArray();
            for (int i = 0; i < copia.length; i++) {
                persona p = (persona) copia[i];
                System.out.println("Pos " + i + ": " + p);
            }
        }
    }

    public persona buscarPorNombre(String nombre) {
        for (persona p : pilaPersonas) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public boolean eliminarPorNombre(String nombre) {
        Stack<persona> temporal = new Stack<>();
        boolean encontrado = false;
        while (!pilaPersonas.isEmpty()) {
            persona p = pilaPersonas.pop();
            if (!encontrado && p.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
            } else {
                temporal.push(p);
            }
        }
        while (!temporal.isEmpty()) {
            pilaPersonas.push(temporal.pop());
        }
        if (encontrado) {
            tope = pilaPersonas.size() - 1;
        }
        return encontrado;
    }

    public boolean modificarPorNombre(String nombre, Scanner scanner) {
        persona p = buscarPorNombre(nombre);
        if (p != null) {
            System.out.print("Nuevo nombre (actual: " + p.getNombre() + "): ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.trim().isEmpty()) p.setNombre(nuevoNombre);

            System.out.print("Nuevo apellido (actual: " + p.getApellido() + "): ");
            String nuevoApellido = scanner.nextLine();
            if (!nuevoApellido.trim().isEmpty()) p.setApellido(nuevoApellido);

            System.out.print("Nuevo peso (actual: " + p.getPeso() + "): ");
            String pesoStr = scanner.nextLine();
            if (!pesoStr.trim().isEmpty()) {
                try {
                    p.setPeso(Float.parseFloat(pesoStr));
                } catch (NumberFormatException e) {
                    System.out.println("Peso inválido, se mantiene el actual.");
                }
            }

            System.out.print("Nueva altura (actual: " + p.getAltura() + "): ");
            String alturaStr = scanner.nextLine();
            if (!alturaStr.trim().isEmpty()) {
                try {
                    p.setAltura(Float.parseFloat(alturaStr));
                } catch (NumberFormatException e) {
                    System.out.println("Altura inválida, se mantiene la actual.");
                }
            }
            return true;
        }
        return false;
    }

    public double calcularPromedioPeso() {
        if (pilaVacia()) return 0.0;
        double suma = 0;
        for (persona p : pilaPersonas) {
            suma += p.getPeso();
        }
        return suma / pilaPersonas.size();
    }

    public double calcularPromedioAltura() {
        if (pilaVacia()) return 0.0;
        double suma = 0;
        for (persona p : pilaPersonas) {
            suma += p.getAltura();
        }
        return suma / pilaPersonas.size();
    }
}
