package pa.resilienciacomunitaria.org.wordvision;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ThreeFragment extends Fragment {
    View rootView;
    private TextView titulo, contenido;
    ImageView imagen;
    Button irUrl;


    public ThreeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_three, container, false);

        rootView = inflater.inflate(R.layout.fragment_three, container, false);
        titulo = (TextView) rootView.findViewById(R.id.titulo);
        contenido = (TextView) rootView.findViewById(R.id.contenido);
        imagen = (ImageView) rootView.findViewById(R.id.logo);

        rootView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        //irUrl = (Button) rootView.findViewById(R.id.url);

        /*titulo.setText("Compartir");
        contenido.setText("Compartir");
        imagen.setImageResource(R.drawable.primerosauxilios);*/

        rootView.findViewById(R.id.urloficial).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.resilienciacomunitaria.org/index.php/es/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        rootView.findViewById(R.id.urlfacebook).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.facebook.com/resilienciacomunitaria?ref=hl");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        rootView.findViewById(R.id.urltwitter).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("https://twitter.com/resilienciero");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });





        return rootView;
    }


}
