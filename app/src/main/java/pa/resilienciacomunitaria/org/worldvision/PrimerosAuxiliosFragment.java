package pa.resilienciacomunitaria.org.worldvision;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;


public class PrimerosAuxiliosFragment extends Fragment {
    View rootView;
    private TextView titulo, contenido;
    ImageView imagen;
    private ViewGroup linearLayoutDetails;
    private ImageView imageViewExpand;
    private static final int DURATION = 250;

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

        linearLayoutDetails = (ViewGroup)  rootView.findViewById(R.id.linearLayoutDetails);
        imageViewExpand = (ImageView)  rootView.findViewById(R.id.imageViewExpand);

        titulo.setText(t);
        contenido.setText(con);
        imagen.setImageResource(img);

        return rootView;
    }


    public void toggleDetails(View view) {
        if (linearLayoutDetails.getVisibility() == View.GONE) {
            ExpandAndCollapseViewUtil.expand(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.more);
            rotate(-180.0f);
        } else {
            ExpandAndCollapseViewUtil.collapse(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.less);
            rotate(180.0f);
        }
    }

    private void rotate(float angle) {
        Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(DURATION);
        imageViewExpand.startAnimation(animation);
    }


}
