import java.util.Scanner;

public class vectores {
    private int tamaño;
    private int indiceActual;
    private persona[] vectorPersonas;

    public vectores(int tamaño, int indiceActual) {
        this.tamaño = tamaño;
        this.indiceActual = indiceActual;
        this.vectorPersonas = new persona[tamaño];
    }

    public boolean vectorVacio() {
        return indiceActual == -1;
    }

    public boolean vectorLleno() {
        return indiceActual == tamaño - 1;
    }

    public void ingresarPersonaSecuencial(persona p) {
        if (vectorVacio()) {
            indiceActual = 0;
            vectorPersonas[indiceActual] = p;
        } else if (!vectorLleno()) {
            indiceActual++;
            vectorPersonas[indiceActual] = p;
        } else {
            System.out.println("El vector está lleno");
        }
    }

    public void agregarPersonaPorPosicion(persona p, int posicion) {
        if (vectorLleno()) {
            System.out.println("El vector está lleno");
        } else if (posicion >= 0 && posicion < tamaño) {
            if (vectorPersonas[posicion] == null) {
                vectorPersonas[posicion] = p;
                if (posicion > indiceActual) indiceActual = posicion;
            } else {
                System.out.println("La posición ya está ocupada");
            }
        } else {
            System.out.println("Posición fuera de rango");
        }
    }

    public void mostrarVector() {
        if (vectorVacio()) {
            System.out.println("Vector vacío");
        } else {
            for (int i = 0; i <= indiceActual; i++) {
                if (vectorPersonas[i] != null) {
                    System.out.println("[" + i + "] " + vectorPersonas[i]);
                } else {
                    System.out.println("[" + i + "] [vacío]");
                }
            }
        }
    }

    public persona buscarPorNombre(String nombre) {
        if (vectorVacio()) return null;
        for (int i = 0; i <= indiceActual; i++) {
            if (vectorPersonas[i] != null && vectorPersonas[i].getNombre().equalsIgnoreCase(nombre)) {
                return vectorPersonas[i];
            }
        }
        return null;
    }

    public boolean eliminarPorNombre(String nombre) {
        if (vectorVacio()) return false;
        for (int i = 0; i <= indiceActual; i++) {
            if (vectorPersonas[i] != null && vectorPersonas[i].getNombre().equalsIgnoreCase(nombre)) {
                for (int j = i; j < indiceActual; j++) {
                    vectorPersonas[j] = vectorPersonas[j + 1];
                }
                vectorPersonas[indiceActual] = null;
                indiceActual--;
                return true;
            }
        }
        return false;
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
        if (vectorVacio()) return 0.0;
        double suma = 0;
        int contador = 0;
        for (int i = 0; i <= indiceActual; i++) {
            if (vectorPersonas[i] != null) {
                suma += vectorPersonas[i].getPeso();
                contador++;
            }
        }
        return contador > 0 ? suma / contador : 0.0;
    }

    public double calcularPromedioAltura() {
        if (vectorVacio()) return 0.0;
        double suma = 0;
        int contador = 0;
        for (int i = 0; i <= indiceActual; i++) {
            if (vectorPersonas[i] != null) {
                suma += vectorPersonas[i].getAltura();
                contador++;
            }
        }
        return contador > 0 ? suma / contador : 0.0;
    }
}
