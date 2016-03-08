package pa.resilienciacomunitaria.org.worldvision;

/**
 * Created by LogicStudio on 25/2/16.
 */
public class AtencionesEmergencias {

    private Integer imagen;
    private String descripcion;
    private String titulo;
    private Preguntas preguntas;


    AtencionesEmergencias(Integer imagen, String descripcion, String titulo, Preguntas preguntas) {
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.titulo=titulo;
        this.preguntas=preguntas;

    }
    public Preguntas getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Preguntas preguntas) {
        this.preguntas = preguntas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getImagen() {

        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

