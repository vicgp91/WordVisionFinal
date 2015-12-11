package pa.resilienciacomunitaria.org.wordvision;


public class ContactoEmergencias {
    private int imagen;
    private String descripcion;
    private String nombre;
    private String telefono;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    ContactoEmergencias(String descripcion, String nombre, int imagen, String telefono){
        this.imagen=imagen;
        this.descripcion=descripcion;
        this.nombre=nombre;
        this.telefono=telefono;


    }


    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
