package pa.resilienciacomunitaria.org.wordvision;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class TwoFragment extends Fragment {

    private ArrayList<PrimerosAuxilios> emergencia;
    private ListView listEmergencias;
    private EmergenciaAdapter adapter;
    private TextView tvNombreaux, tvTelefonoaux;
    View rootView;


    public TwoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_two, container, false);

        emergencia = new ArrayList<PrimerosAuxilios>();
        rellenarArrayList();
        tvNombreaux = (TextView) rootView.findViewById(R.id.tvTituloAux);

        adapter = new EmergenciaAdapter(this.getContext(), emergencia);

        listEmergencias = (ListView) rootView.findViewById(R.id.listaNumerosAux);
        listEmergencias.setAdapter(adapter);

        listEmergencias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                // dialog(contactos.get(position).getTelefono());
                // MostrarNota(position);
                Intent i = new Intent(rootView.getContext(), VerPrimerosAuxilios.class );
                i.putExtra("titulo", emergencia.get(position).getNombre());
                i.putExtra("imagen", emergencia.get(position).getImagen());
                i.putExtra("contenido", emergencia.get(position).getDescripcion());
                startActivity(i);
            }
        });


        return rootView;
    }

    private void rellenarArrayList() {
        String contenido="La resiliencia es la capacidad de los seres vivos para sobreponerse a períodos de dolor emocional y situaciones adversas. " +
                "\n Cuando un sujeto o grupo es capaz de hacerlo, se dice que tiene una resiliencia adecuada, y puede sobreponerse a contratiempos o incluso resultar fortalecido por estos. " +
                "\n Actualmente, la resiliencia se aborda desde la psicología positiva, la cual se centra en las capacidades, valores y atributos positivos de los seres humanos, y no en sus debilidades y patologías, como lo hace la psicología tradicional.";
        emergencia.add(new PrimerosAuxilios(contenido, "Prácticas Resilientes ", R.drawable.primerosauxilios));
        emergencia.add(new PrimerosAuxilios(contenido, "Sistema de Comando de Incidente", R.drawable.primerosauxilios));
        emergencia.add(new PrimerosAuxilios(contenido, "Primeros Auxilios Psicológicos", R.drawable.primerosauxilios));
        emergencia.add(new PrimerosAuxilios(contenido, "Camillaje ", R.drawable.primerosauxilios));
        emergencia.add(new PrimerosAuxilios(contenido, "Primeros auxilios psicologicos", R.drawable.primerosauxilios));
        emergencia.add(new PrimerosAuxilios(contenido, "Seguridad Acuática", R.drawable.primerosauxilios));
        emergencia.add(new PrimerosAuxilios(contenido, "Medicina en Emergencia", R.drawable.primerosauxilios));

    }


}
