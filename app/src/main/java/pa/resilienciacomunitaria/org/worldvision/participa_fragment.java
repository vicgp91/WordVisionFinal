package pa.resilienciacomunitaria.org.worldvision;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class participa_fragment extends Fragment {
    View rootView;
    private TextView titulo, contenido, apoyo;
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
        apoyo = (TextView) rootView.findViewById(R.id.apoyo);
        //imagen2 = (ImageView) rootView.findViewById(R.id.imagen2);


        imagen1.setImageResource(R.drawable.causes_world_vision);
       // imagen2.setImageResource(R.drawable.rescate);
        titulo.setText("Bienvenido, Bienvenida!");
        contenido.setText("Aquí aprenderás de las guías técnicas de rescate, complétalas  todas.\n" +
                "\nInscríbete para ser un voluntario resilente.");

        rootView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        apoyo.setText(Html.fromHtml("Con el apoyo de " +
                "<a href=\"http://www.logicstudio.net\">www.logicstudio.net</a> " + "expertos en  fundraising."));
        apoyo.setMovementMethod(LinkMovementMethod.getInstance());

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
