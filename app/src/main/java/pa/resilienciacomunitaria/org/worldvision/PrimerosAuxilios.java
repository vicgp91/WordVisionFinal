package pa.resilienciacomunitaria.org.worldvision;

import java.util.ArrayList;

public class PrimerosAuxilios {


    private Integer imagen;
    private String descripcion;
    private String nombre;
    private ArrayList<AtencionesEmergencias> emergenciasArrayList = new ArrayList<AtencionesEmergencias>();

    PrimerosAuxilios(String descripcion, String nombre, Integer imagen, ArrayList<AtencionesEmergencias> emergenciasArrayList){
        this.descripcion=descripcion;
        this.nombre=nombre;
        this.imagen=imagen;
        this.emergenciasArrayList=emergenciasArrayList;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<AtencionesEmergencias> getEmergenciasArrayList() {
        return emergenciasArrayList;
    }

    public void setEmergenciasArrayList(ArrayList<AtencionesEmergencias> emergenciasArrayList) {
        this.emergenciasArrayList = emergenciasArrayList;
    }
}
