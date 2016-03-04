package pa.resilienciacomunitaria.org.wordvision;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class participa_fragment extends Fragment {
    View rootView;
    private TextView titulo, contenido;
    ImageView imagen1, imagen2;

    private Toolbar toolbar;

    public participa_fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_participa_fragment, container, false);

        titulo = (TextView) rootView.findViewById(R.id.titulo);
        contenido = (TextView) rootView.findViewById(R.id.contenido);
        imagen1 = (ImageView) rootView.findViewById(R.id.imagen1);
        imagen2 = (ImageView) rootView.findViewById(R.id.imagen2);


        imagen1.setImageResource(R.drawable.wv_logo);
        imagen2.setImageResource(R.drawable.logo_nino);
        titulo.setText("Bienvenido, Bienvenida!");
        contenido.setText("Aquí aprenderas de las guias técnicas de rescate, completalas todas :)" +
                "\nDirectorio con teléfonos de emergencia." +
                "\nInscribete como voluntario como ciudadano resilente.");

        rootView.setBackgroundColor(Color.parseColor("#FFFFFF"));


        Button inscribisrse = (Button) rootView.findViewById(R.id.btninscribirse);
        inscribisrse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(rootView.getContext(), InscribiseActivity.class);
                startActivity(i);

            }
        });






        return rootView;
    }

}
