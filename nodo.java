public class nodo {
    public persona dato;
    public nodo siguiente;

    public nodo(){}

    public nodo(persona dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public nodo(persona dato, nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public persona getDato() {
        return dato;
    }

    public void setDato(persona dato) {
        this.dato = dato;
    }

    public nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodo siguiente) {
        this.siguiente = siguiente;
    }
}
