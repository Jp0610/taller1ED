public class ListaDoble {

    private NodoDoble inicio;
    private NodoDoble fin;
    private int size;

    public ListaDoble() {
        inicio = null;
        fin = null;
        size = 0;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public int getSize() {
        return size;
    }

    public void insertarInicio(persona dato) {
        NodoDoble nuevo = new NodoDoble(dato);

        if (isEmpty()) {
            inicio = fin = nuevo;
        } else {
            nuevo.siguiente = inicio;
            inicio.anterior = nuevo;
            inicio = nuevo;
        }
        size++;
    }

    public void insertarFinal(persona dato) {
        NodoDoble nuevo = new NodoDoble(dato);

        if (isEmpty()) {
            inicio = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            nuevo.anterior = fin;
            fin = nuevo;
        }
        size++;
    }

    public void insertarEn(int pos, persona dato) {
        if (pos < 0 || pos > size) {
            System.out.println("Posición fuera de rango");
            return;
        }

        if (pos == 0) {
            insertarInicio(dato);
            return;
        }

        if (pos == size) {
            insertarFinal(dato);
            return;
        }

        NodoDoble nuevo = new NodoDoble(dato);
        NodoDoble aux = inicio;

        for (int i = 0; i < pos - 1; i++) {
            aux = aux.siguiente;
        }

        nuevo.siguiente = aux.siguiente;
        nuevo.anterior = aux;
        aux.siguiente.anterior = nuevo;
        aux.siguiente = nuevo;

        size++;
    }

    public void eliminarInicio() {
        if (isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }

        if (inicio == fin) {
            inicio = fin = null;
        } else {
            inicio = inicio.siguiente;
            inicio.anterior = null;
        }
        size--;
    }

    public void eliminarFinal() {
        if (isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }

        if (inicio == fin) {
            inicio = fin = null;
        } else {
            fin = fin.anterior;
            fin.siguiente = null;
        }
        size--;
    }

    public void eliminarEn(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Posición inválida");
            return;
        }

        if (pos == 0) {
            eliminarInicio();
            return;
        }

        if (pos == size - 1) {
            eliminarFinal();
            return;
        }

        NodoDoble aux = inicio;

        for (int i = 0; i < pos; i++) {
            aux = aux.siguiente;
        }

        aux.anterior.siguiente = aux.siguiente;
        aux.siguiente.anterior = aux.anterior;
        size--;
    }

    public persona buscar(String nombre) {
        NodoDoble aux = inicio;

        while (aux != null) {
            if (aux.dato.nombre.equals(nombre)) {
                return aux.dato;
            }
            aux = aux.siguiente;
        }

        return null;
    }

    public void mostrarAdelante() {
        NodoDoble aux = inicio;
        while (aux != null) {
            System.out.println(aux.dato.nombre + " " + aux.dato.apellido);
            aux = aux.siguiente;
        }
    }

    public void mostrarAtras() {
        NodoDoble aux = fin;
        while (aux != null) {
            System.out.println(aux.dato.nombre + " " + aux.dato.apellido);
            aux = aux.anterior;
        }
    }
}
