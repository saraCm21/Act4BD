package Clases;


public class Asistente {
    private int id;
    private String nombre;
    private String apellido;
    private String institucion;
    private String correo;
    private String numero;

    public Asistente() {}

    public Asistente(int id, String nombre, String apellido, String institucion, String correo, String numero) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.institucion = institucion;
        this.correo = correo;
        this.numero = numero;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String toScript() {
        return "Asistente [ID=" + id + ", Nombre=" + nombre + ", Apellido=" + apellido +
               ", Institucion=" + institucion + ", Correo=" + correo + ", Numero=" + numero + "]";
    }

}   


