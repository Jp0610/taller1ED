public class NodoDoble {
    public persona dato;
    public NodoDoble siguiente;
    public NodoDoble anterior;

    public NodoDoble(persona dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public persona getDato() {
        return dato;
    }

    public void setDato(persona dato) {
        this.dato = dato;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

}
