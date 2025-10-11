public class Matriz {
    private int filas;
    private int columnas;
    private int indiceF;
    private int indiceC;
    private persona[][] matrizPersonas;

    public Matriz(int filas, int columnas, int indiceF, int indiceC) {
        this.filas = filas;
        this.columnas = columnas;
        this.indiceF = indiceF;
        this.indiceC = indiceC;
        this.matrizPersonas = new persona[filas][columnas];
    }

    public int getFilas() { return filas; }
    public void setFilas(int filas) { this.filas = filas; }
    public int getColumnas() { return columnas; }
    public void setColumnas(int columnas) { this.columnas = columnas; }
    public int getIndiceF() { return indiceF; }
    public void setIndiceF(int indiceF) { this.indiceF = indiceF; }
    public int getIndiceC() { return indiceC; }
    public void setIndiceC(int indiceC) { this.indiceC = indiceC; }
    public persona[][] getMatrizPersonas() { return matrizPersonas; }
    public void setMatrizPersonas(persona[][] matrizPersonas) { this.matrizPersonas = matrizPersonas; }

    public boolean matrizVacia() {
        return (indiceF == -1 && indiceC == -1);
    }

    public boolean matrizLlena() {
        return (indiceF == filas - 1 && indiceC == columnas - 1);
    }

    public void ingresarPersonaSecuencial(persona p) {
        if (matrizVacia()) {
            indiceF = 0;
            indiceC = 0;
            matrizPersonas[indiceF][indiceC] = p;
        } else if (!matrizLlena()) {
            if (indiceC < columnas - 1) {
                indiceC++;
            } else {
                indiceC = 0;
                indiceF++;
            }
            matrizPersonas[indiceF][indiceC] = p;
        } else {
            System.out.println("La matriz está llena");
        }
    }

    public void agregarPersonaPorPosicion(persona p, int fila, int columna) {
        if (matrizLlena()) {
            System.out.println("La matriz está llena");
        } else if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            if (matrizPersonas[fila][columna] == null) {
                matrizPersonas[fila][columna] = p;
            } else {
                System.out.println("La posición ya está ocupada");
            }
        } else {
            System.out.println("Posición fuera de rango");
        }
    }

    public void mostrarMatriz() {
        if (matrizVacia()) {
            System.out.println("Matriz vacía");
            return;
        }

        int anchoCelda = 25;

        for (int j = 0; j < columnas; j++) {
            System.out.print("+" + "-".repeat(anchoCelda));
        }
        System.out.println("+");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String contenido;
                if (matrizPersonas[i][j] != null) {
                    contenido = matrizPersonas[i][j].getNombre() + " " + matrizPersonas[i][j].getApellido();
                } else {
                    contenido = "[vacío]";
                }
                String celda = String.format("[%d][%d] %s", i, j, contenido);
                if (celda.length() > anchoCelda - 2) {
                    celda = celda.substring(0, anchoCelda - 5) + "...";
                }
                System.out.print("| " + String.format("%-" + (anchoCelda - 2) + "s", celda) + " ");
            }
            System.out.println("|");

            for (int j = 0; j < columnas; j++) {
                System.out.print("+" + "-".repeat(anchoCelda));
            }
            System.out.println("+");
        }
    }

    public persona buscarPorNombre(String nombre) {
        if (matrizVacia()) return null;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matrizPersonas[i][j] != null && 
                    matrizPersonas[i][j].getNombre().equalsIgnoreCase(nombre)) {
                    return matrizPersonas[i][j];
                }
            }
        }
        return null;
    }

    public boolean eliminarPorNombre(String nombre) {
        if (matrizVacia()) return false;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matrizPersonas[i][j] != null && 
                    matrizPersonas[i][j].getNombre().equalsIgnoreCase(nombre)) {
                    matrizPersonas[i][j] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean modificarPorNombre(String nombre, java.util.Scanner scanner) {
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

    public double calcularPromedioPesoPrincipal() {
        if (matrizVacia()) return 0.0;
        double suma = 0;
        int contador = 0;
        for (int i = 0; i < filas && i < columnas; i++) {
            if (matrizPersonas[i][i] != null) {
                suma += matrizPersonas[i][i].getPeso();
                contador++;
            }
        }
        return contador > 0 ? suma / contador : 0.0;
    }

    public double calcularPromedioAlturaPrincipal() {
        if (matrizVacia()) return 0.0;
        double suma = 0;
        int contador = 0;
        for (int i = 0; i < filas && i < columnas; i++) {
            if (matrizPersonas[i][i] != null) {
                suma += matrizPersonas[i][i].getAltura();
                contador++;
            }
        }
        return contador > 0 ? suma / contador : 0.0;
    }

    public double calcularPromedioPesoSecundaria() {
        if (matrizVacia()) return 0.0;
        double suma = 0;
        int contador = 0;
        for (int i = 0; i < filas; i++) {
            int j = columnas - 1 - i;
            if (j >= 0 && j < columnas && matrizPersonas[i][j] != null) {
                suma += matrizPersonas[i][j].getPeso();
                contador++;
            }
        }
        return contador > 0 ? suma / contador : 0.0;
    }

    public double calcularPromedioAlturaSecundaria() {
        if (matrizVacia()) return 0.0;
        double suma = 0;
        int contador = 0;
        for (int i = 0; i < filas; i++) {
            int j = columnas - 1 - i;
            if (j >= 0 && j < columnas && matrizPersonas[i][j] != null) {
                suma += matrizPersonas[i][j].getAltura();
                contador++;
            }
        }
        return contador > 0 ? suma / contador : 0.0;
    }

    public double calcularPromedioPesoAmbas() {
        if (matrizVacia()) return 0.0;
        double suma = 0;
        int contador = 0;

        for (int i = 0; i < filas && i < columnas; i++) {
            if (matrizPersonas[i][i] != null) {
                suma += matrizPersonas[i][i].getPeso();
                contador++;
            }
        }

        for (int i = 0; i < filas; i++) {
            int j = columnas - 1 - i;
            if (j >= 0 && j < columnas && matrizPersonas[i][j] != null) {
                if (filas == columnas && i == j) continue;
                suma += matrizPersonas[i][j].getPeso();
                contador++;
            }
        }

        return contador > 0 ? suma / contador : 0.0;
    }

    public double calcularPromedioAlturaAmbas() {
        if (matrizVacia()) return 0.0;
        double suma = 0;
        int contador = 0;

        for (int i = 0; i < filas && i < columnas; i++) {
            if (matrizPersonas[i][i] != null) {
                suma += matrizPersonas[i][i].getAltura();
                contador++;
            }
        }

        for (int i = 0; i < filas; i++) {
            int j = columnas - 1 - i;
            if (j >= 0 && j < columnas && matrizPersonas[i][j] != null) {
                if (filas == columnas && i == j) continue;
                suma += matrizPersonas[i][j].getAltura();
                contador++;
            }
        }

        return contador > 0 ? suma / contador : 0.0;
    }
}
