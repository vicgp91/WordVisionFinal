package pa.resilienciacomunitaria.org.wordvision;

/**
 * Created by LogicStudio on 25/2/16.
 */
public class AtencionesEmergencias {

    private int IdAuxilio;
    private int imagen;
    private String descripcion;

    public int getIdAuxilio() {
        return IdAuxilio;
    }

    public void setIdAuxilio(int idAuxilio) {
        IdAuxilio = idAuxilio;
    }

    AtencionesEmergencias(String descripcion, int imagen){
        this.descripcion=descripcion;
        this.imagen=imagen;
    }
}
