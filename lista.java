import java.util.Scanner;

public class lista {
    public nodo p; 
    public nodo u; 
    public nodo q; 
    public nodo t; 

    public lista(nodo p, nodo u, nodo q, nodo t) {
        this.p = p;
        this.u = u;
        this.q = q;
        this.t = t;
    }

    public lista(persona person) {
        nodo nuevo = new nodo(person);
        this.p = nuevo;
        this.u = nuevo;
        this.q = null;
        this.t = null;
    }

    public lista() {
        this.p = null;
        this.u = null;
        this.q = null;
        this.t = null;
    }

    public nodo getP() { return p; }
    public void setP(nodo p) { this.p = p; }
    public nodo getU() { return u; }
    public void setU(nodo u) { this.u = u; }
    public nodo getQ() { return q; }
    public void setQ(nodo q) { this.q = q; }
    public nodo getT() { return t; }
    public void setT(nodo t) { this.t = t; }

    public boolean ListaVacia() {
        return this.p == null;
    }

    public void AgregarPersona(persona p) {
        nodo nuevo = new nodo(p);
        if (ListaVacia()) {
            this.p = nuevo;
            this.u = nuevo;
        } else {
            this.u.setSiguiente(nuevo);
            this.u = nuevo;
        }
    }

    public void mostrarLista() {
        if (!ListaVacia()) {
            this.q = this.p;
            while (this.q != null) {
                System.out.println(this.q.getDato().toString());
                this.q = this.q.getSiguiente();
            }
        } else {
            System.out.println("La lista esta vacia");
        }
    }

    public int contarNodos() {
        int contador = 0;
        this.q = this.p;
        while (this.q != null) {
            contador++;
            this.q = this.q.getSiguiente();
        }
        return contador;
    }

    public persona buscarPorNombre(String nombre) {
        if (ListaVacia()) return null;
        this.q = this.p;
        while (this.q != null) {
            if (this.q.getDato().getNombre().equalsIgnoreCase(nombre)) {
                return this.q.getDato();
            }
            this.q = this.q.getSiguiente();
        }
        return null;
    }

    public boolean eliminarPorNombre(String nombre) {
        if (ListaVacia()) return false;
        if (this.p.getDato().getNombre().equalsIgnoreCase(nombre)) {
            this.p = this.p.getSiguiente();
            if (this.p == null) this.u = null;
            return true;
        }
        this.q = this.p;
        while (this.q.getSiguiente() != null) {
            if (this.q.getSiguiente().getDato().getNombre().equalsIgnoreCase(nombre)) {
                this.q.setSiguiente(this.q.getSiguiente().getSiguiente());
                if (this.q.getSiguiente() == null) this.u = this.q;
                return true;
            }
            this.q = this.q.getSiguiente();
        }
        return false;
    }

    public boolean modificarPorNombre(String nombre, Scanner scanner) {
        this.q = this.p;
        while (this.q != null) {
            if (this.q.getDato().getNombre().equalsIgnoreCase(nombre)) {
                persona p = this.q.getDato();
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
            this.q = this.q.getSiguiente();
        }
        return false;
    }

    public double calcularPromedioPeso() {
        if (ListaVacia()) return 0.0;
        double suma = 0;
        int contador = 0;
        this.q = this.p;
        while (this.q != null) {
            suma += this.q.getDato().getPeso();
            contador++;
            this.q = this.q.getSiguiente();
        }
        return contador > 0 ? suma / contador : 0.0;
    }

    public double calcularPromedioAltura() {
        if (ListaVacia()) return 0.0;
        double suma = 0;
        int contador = 0;
        this.q = this.p;
        while (this.q != null) {
            suma += this.q.getDato().getAltura();
            contador++;
            this.q = this.q.getSiguiente();
        }
        return contador > 0 ? suma / contador : 0.0;
    }
}
