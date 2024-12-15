package Clases;

public class Autor {
    private int id;
    private String rol;
    private int asistenteId;

    // Constructor
    public Autor(String rol, int asistenteId) {
        this.rol = rol;
        this.asistenteId = asistenteId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getAsistenteId() {
        return asistenteId;
    }

    public void setAsistenteId(int asistenteId) {
        this.asistenteId = asistenteId;
    }

    public String toScript() {
        return "Autor ID: " + id + ", Rol: " + rol + ", Asistente ID: " + asistenteId;
    }
}
