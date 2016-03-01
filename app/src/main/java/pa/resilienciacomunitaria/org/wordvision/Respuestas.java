package pa.resilienciacomunitaria.org.wordvision;

/**
 * Created by LogicStudio on 1/3/16.
 */
public class Respuestas {
    String respuesta;
    Boolean esCorrecta;

    Respuestas( String respuesta, Boolean esCorrecta){
        this.respuesta=respuesta;
        this.esCorrecta=esCorrecta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Boolean getEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(Boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }
}
