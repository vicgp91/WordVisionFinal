package pa.resilienciacomunitaria.org.worldvision;

public class Participante {

   private String ubicacion, nombre, genero, edad, telefono, email, interes1, interes2, interes3;

    Participante(String ubicacion,String nombre,String genero,String edad,String telefono,String email, String interes1, String interes2,String interes3){
        this.ubicacion=ubicacion;
        this.nombre=nombre;
        this.genero=genero;
        this.edad=edad;
        this.telefono=telefono;
        this.email=email;
        this.interes1=interes1;
        this.interes2=interes2;
        this.interes3=interes3;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInteres1() {
        return interes1;
    }

    public void setInteres1(String interes1) {
        this.interes1 = interes1;
    }

    public String getInteres2() {
        return interes2;
    }

    public void setInteres2(String interes2) {
        this.interes2 = interes2;
    }

    public String getInteres3() {
        return interes3;
    }

    public void setInteres3(String interes3) {
        this.interes3 = interes3;
    }
}
