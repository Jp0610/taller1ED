public class persona {
    protected String nombre;
    protected String apellido;
    protected float peso;
    protected float altura;

    public persona(String nombre, String apellido, float peso, float altura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.peso = peso;
        this.altura = altura;
    }

    public persona() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido +
                " | Peso: " + peso + "kg" +
                " | Altura: " + altura + "m";
    }
}
