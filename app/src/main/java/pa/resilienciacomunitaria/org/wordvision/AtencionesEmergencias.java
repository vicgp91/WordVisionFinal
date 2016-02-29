package pa.resilienciacomunitaria.org.wordvision;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by LogicStudio on 25/2/16.
 */
public class AtencionesEmergencias {

    private Integer imagen;
    private String descripcion;
    private String titulo;

    AtencionesEmergencias(Integer imagen, String descripcion, String titulo) {
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.titulo=titulo;
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

