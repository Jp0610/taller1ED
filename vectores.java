public class vectores {
    private int max;
    private int indice = 0;
    private persona[] vectorPersona;

    public vectores(int max) {
        this.max = max;
        this.indice = 0;
        this.vectorPersona = new persona[max];
    }

    public int getMax() {
        return max;
    }

    public int getIndice() {
        return indice;
    }

    public persona[] getVectorPersona() {
        return vectorPersona;
    }

    public boolean vectorVacio() {
        return this.indice == 0;
    }

    public boolean vectorLleno() {
        return this.indice == this.max;
    }

    public void agregarPersona(persona p) {
        if (!vectorLleno()) {
            this.vectorPersona[this.indice] = p;
            this.indice++;
        } else {
            System.out.println("El vector esta lleno");
        }
    }

    public void mostrarVector() {
        if (!vectorVacio()) {
            for (int i = 0; i < this.indice; i++) {
                System.out.println("Nombre: " + this.vectorPersona[i].getNombre() +
                        ", Apellido: " + this.vectorPersona[i].getApellido() +
                        ", Peso: " + this.vectorPersona[i].getPeso() +
                        ", Altura: " + this.vectorPersona[i].getAltura());
            }
        } else {
            System.out.println("El vector esta vacio");
        }
    }

    public void eliminarPersona(String nombre) {
        if (!vectorVacio()) {
            int pos = -1;
            for (int i = 0; i < this.indice; i++) {
                if (this.vectorPersona[i].getNombre().equalsIgnoreCase(nombre)) {
                    pos = i;
                    break;
                }
            }

            if (pos != -1) {
                for (int i = pos; i < this.indice - 1; i++) {
                    this.vectorPersona[i] = this.vectorPersona[i + 1];
                }
                this.vectorPersona[this.indice - 1] = null;
                this.indice--;
                System.out.println("Persona eliminada exitosamente");
            } else {
                System.out.println("No se encontro una persona con ese nombre");
            }
        } else {
            System.out.println("El vector esta vacio");
        }
    }

    public int buscarPersona(String nombre) {
        if (!vectorVacio()) {
            for (int i = 0; i < this.indice; i++) {
                if (this.vectorPersona[i].getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println(this.vectorPersona[i]);
                    return i;
                }
            }
            System.out.println("No se encontro a la persona");
        } else {
            System.out.println("El vector esta vacio");
        }
        return -1;
    }
}