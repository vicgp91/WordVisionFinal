package pa.resilienciacomunitaria.org.wordvision;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class TwoFragment extends Fragment {

    private ArrayList<PrimerosAuxilios> primerosAuxilios;
    private ListView listEmergencias;
    private EmergenciaAdapter adapter;
    private TextView tvNombreaux, tvTelefonoaux;
    private ArrayList<AtencionesEmergencias> emergenciasArrayList;
    View rootView;


    public TwoFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_two, container, false);

        primerosAuxilios = new ArrayList<PrimerosAuxilios>();
        rellenarArrayList();
        tvNombreaux = (TextView) rootView.findViewById(R.id.tvTituloAux);

        rootView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        adapter = new EmergenciaAdapter(this.getContext(), primerosAuxilios);

        listEmergencias = (ListView) rootView.findViewById(R.id.listaNumerosAux);
        listEmergencias.setAdapter(adapter);

        listEmergencias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                // dialog(contactos.get(position).getTelefono());
                // MostrarNota(position);
                Intent i = new Intent(rootView.getContext(), VerInfoPrimerosAuxilios.class );
                i.putExtra("titulo", primerosAuxilios.get(position).getNombre());
                i.putExtra("imagen", primerosAuxilios.get(position).getImagen());
                i.putExtra("contenido", primerosAuxilios.get(position).getDescripcion());
                i.putExtra("atencionesEmergencias", new Gson().toJson(primerosAuxilios.get(position).getEmergenciasArrayList() ));


                //i.putExtra("atencionesEmergencias",primerosAuxilios.get(position).getEmergenciasArrayList() );
                startActivity(i);
            }
        });


        return rootView;
    }

    private void rellenarArrayList() {

        String contenidoFractura1="Es la ruptura parcial o total de un hueso lesiones causadas por factores externos o internos como enfermedades propias de los huesos." +
                "\nAgentes externos: Son provocados por trauma, fuerza desproporcionada, movimiento desmedido que ocasionan esgunces, fractura y luxaciones." +
                "\n" +
                "Agentes Internos: Enfermedades que afectan el sistema óseo, eje. Osteoporosis, leucemia y cáncer de huesos";
        String contenidoFractura2="\nSignos y Sintomas de Fracturas: " +
                "\nSignos:" +
                "\n-Deformidad. \n-Inflamación. \n-Incapacidad de movimiento. \n-Aumento o acortamiento del miembro. \n-Área lesionada  enturmecida y Fría. \n-La piel tiene un color Azul. ";



        ArrayList<Respuestas>  respuestaFractura = new ArrayList<Respuestas>();
        respuestaFractura.add(new Respuestas("Perdida de visión", false));
        respuestaFractura.add(new Respuestas("Dolor intenso en el área afectada", true));
        respuestaFractura.add(new Respuestas("Pérdida de audición", false));


        Preguntas preguntaFractura = new Preguntas("Síntomas de una fractura", respuestaFractura);

        ArrayList<AtencionesEmergencias>  fractura = new ArrayList<AtencionesEmergencias>();
        fractura.add(new AtencionesEmergencias(null, contenidoFractura1, "FRACTURAS", preguntaFractura));
        fractura.add(new AtencionesEmergencias(null, contenidoFractura2, null, preguntaFractura));


        String hemorragea1="Es la pérdida abundante de sangre al romperse un vaso sanguineo" +
                "\nTIPOS DE HEMORRAGIAS: " +
                "\n1. Hemorragia Arterial: Sangre de color rojo que sale de forma intermitente coincidiendo con los latidos del corazón." +
                "\n2. Hemorragias Venosas: Sangre de color oscuro y que sale de forma continua." +
                "\n3. Hemorragia Capilar: Sangrado de color  rojo que sale de forma lenta." +
                "\n" +
                "\nClasificación de las Hemorragias: " +
                "\n1. Hemorragia Externa: Se acompaña de una herida en la piel y se observa salida de sangre hacia afuera." +
                "\n2. Hemorragia Interna: El sangrado es interno. Este sangrado puede salir por los orificios naturales del cuerpo, convirtiendose en hemorragia  exteriorizada.";
        String hemorragia2="Haga  presión directa: Use guantes y ejerza presión sobre la herida." +
                "\nElevación: Elevar las extremidades afectadas (piernas o brazos), para aminorar la salida de sangre al sitio de la herida. Si no existen fracturas u objetos ensartados  se elevan las extremidades afectadas a un nivel más alto que el del corazón" +
                "\nPresión Indirecta: Usando la yema de los dedos, la palma de la mano, se apretará en el sitio afectado donde podamos prensar la arteria por donde sale la sangre contra el hueso, a fin de evitar el paso de la sangre.";

        ArrayList<AtencionesEmergencias>  hemorrageas = new ArrayList<AtencionesEmergencias>();
        hemorrageas.add(new AtencionesEmergencias(null, hemorragea1, "HEMORRAGIAS", null));
        hemorrageas.add(new AtencionesEmergencias(null, hemorragia2, "Primeros Auxilios para hemorragias", null));

        String herida1="Es la separación de los tejidos de la piel, que puede dejar al descubierto otras partes del cuerpo como los huesos y otros órganos del ser humano que se encuentrann internamente.";
        String herida2="\n1. Cortantes: Bordes rectilíneos (cuchillo, gillette, navaja)." +
                "\n2. Lacerantes: Bordes irregulares (latón, sierra, vidrio)." +
                "\n3. Punzantes: Orificio a veces con salida (punzón, clavos, agujas)" +
                "\n3. Contusas: Golpes fuertes (pedradas, martillazos)." +
                "\n4. Corto Punzante: Bordes rectilíneos  y orificio (verruguilla, navaja)." +
                "\n5. Avulsiva: Desgarre o pérdida de un miembro o parte del cuerpo.";

        ArrayList<AtencionesEmergencias>  heridas = new ArrayList<AtencionesEmergencias>();
        heridas.add(new AtencionesEmergencias(null, herida1, "HERIDAS", null));
        heridas.add(new AtencionesEmergencias(null, herida2, "LOS ELEMENTOS QUE PUEDEN PRODUCIR HERIDAS SON: ", null));

        ArrayList<AtencionesEmergencias>  inmobilizacion = new ArrayList<AtencionesEmergencias>();
        inmobilizacion.add(new AtencionesEmergencias(null, null, null, null));
        inmobilizacion.add(new AtencionesEmergencias(null, null, null, null));
        inmobilizacion.add(new AtencionesEmergencias(null, null, null, null));


        primerosAuxilios.add(new PrimerosAuxilios(null,"Fracturas", R.drawable.fracturalist, fractura));
        primerosAuxilios.add(new PrimerosAuxilios(null, "Hemorrageas", R.drawable.hemorragialist, hemorrageas));
        primerosAuxilios.add(new PrimerosAuxilios(null, "Heridas", R.drawable.primerosauxilios, heridas));
        primerosAuxilios.add(new PrimerosAuxilios(null, "Inmobilización ", R.drawable.primerosauxilios, inmobilizacion));
    }


}
