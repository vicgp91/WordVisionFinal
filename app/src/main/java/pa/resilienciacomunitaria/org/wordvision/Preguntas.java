package pa.resilienciacomunitaria.org.wordvision;

import java.util.ArrayList;

/**
 * Created by LogicStudio on 1/3/16.
 */
public class Preguntas {

    String pregunta;
    private ArrayList<Respuestas> respuestasArrayList = new ArrayList<Respuestas>();



    Preguntas(String pregunta, ArrayList<Respuestas> respuestasArrayList ){
        this.pregunta=pregunta;
        this.respuestasArrayList=respuestasArrayList;
    }

    public ArrayList<Respuestas> getRespuestasArrayList() {
        return respuestasArrayList;
    }

    public void setRespuestasArrayList(ArrayList<Respuestas> respuestasArrayList) {
        this.respuestasArrayList = respuestasArrayList;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

}
