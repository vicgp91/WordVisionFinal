package pa.resilienciacomunitaria.org.wordvision;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class PrimerosAuxiliosFragment extends Fragment {
    View rootView;
    private TextView titulo, contenido;
    ImageView imagen;

    public PrimerosAuxiliosFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_primeros_auxilios, container, false);
        titulo = (TextView) rootView.findViewById(R.id.titulo);
        contenido = (TextView) rootView.findViewById(R.id.contenido);
        imagen = (ImageView) rootView.findViewById(R.id.imgAuxilio);
        SharedPreferences prefs = rootView.getContext().getSharedPreferences("Auxilio", Context.MODE_PRIVATE);
        String t = prefs.getString("titulo", "");
        String con = prefs.getString("contenido", "");
        Integer img = Integer.parseInt(prefs.getString("imagen", ""));

        titulo.setText(t);
        contenido.setText(con);
        imagen.setImageResource(img);

        return rootView;
    }
}
