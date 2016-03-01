package pa.resilienciacomunitaria.org.wordvision;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class VerInfoPrimerosAuxilios extends AppCompatActivity {

    private TextView titulo, contenido;
    ImageView imagen;
    private ListView lvImagenes;
    private ViewGroup linearLayoutDetails;
    private CardViewAdapter cardViewAdapter;
    private ImageView imageViewExpand;
    private static final int DURATION = 250;
    private Toolbar toolbar;
    private RadioGroup rdgGrupo;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public TextView nombre, siguiente, anterior;
    public TextView visitas;
    private Toolbar toolbarCard;
    private ArrayList<AtencionesEmergencias> listEmergencia;

    private Integer posicionPagina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_cardview);

        //setContentView(R.layout.activity_ver_info_primeros_auxilios

        // toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ArrayList<AtencionesEmergencias> itemsPrimerosAuxilios = new ArrayList<AtencionesEmergencias>();


        // Obtener el Recycler
        // recycler = (RecyclerView) findViewById(R.id.reciclador);
        //recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        //lManager = new LinearLayoutManager(this);
        // recycler.setLayoutManager(lManager);


        String t = getIntent().getExtras().getString("titulo");
        String con = getIntent().getExtras().getString("contenido");
        Integer img = getIntent().getExtras().getInt("imagen");
        String gson = getIntent().getExtras().getString("atencionesEmergencias");

        listEmergencia = new ArrayList<AtencionesEmergencias>();

        Type listType = new TypeToken<ArrayList<AtencionesEmergencias>>() {
        }.getType();

        listEmergencia = new Gson().fromJson(gson, listType);

        // adapter = new CardViewAdapter(listEmergencia, t);
        // recycler.setAdapter(adapter);
        nombre = (TextView) findViewById(R.id.nombre);
        toolbarCard = (Toolbar) findViewById(R.id.toolbarCard);
        siguiente = (TextView) findViewById(R.id.siguiente);
        anterior = (TextView) findViewById(R.id.anterior);

        nombre.setText(listEmergencia.get(0).getDescripcion());
        toolbarCard.setTitle(listEmergencia.get(0).getTitulo());
        toolbarCard.setSubtitle("Parte 1/" + String.valueOf(listEmergencia.size()));
        posicionPagina = 1;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ver_info_primeros_auxilios, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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


    public void NextPage(View v) {

        final  Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.prueba);
        dialog.setTitle(listEmergencia.get(0).getPreguntas().getPregunta());
        dialog.setCancelable(true);

        final   RadioButton rd1 = (RadioButton) dialog.findViewById(R.id.rd_1);
        final   RadioButton rd2 = (RadioButton) dialog.findViewById(R.id.rd_2);
        final   RadioButton rd3 = (RadioButton) dialog.findViewById(R.id.rd_3);

        posicionPagina = posicionPagina + 1;

        if (posicionPagina <= listEmergencia.size()) {

            if (posicionPagina < listEmergencia.size()) {
                siguiente.setText("Siguiente");
            }

            if (posicionPagina == listEmergencia.size()) {
                siguiente.setText("Quiz!");
            }

            nombre.setText(listEmergencia.get(posicionPagina - 1).getDescripcion());
            toolbarCard.setTitle(listEmergencia.get(posicionPagina - 1).getTitulo());
            toolbarCard.setSubtitle("Parte " + String.valueOf(posicionPagina) + "/" + String.valueOf(listEmergencia.size()));

        }
        if(siguiente.getText().equals("Quiz!") && posicionPagina > listEmergencia.size()){
            rd1.setText(listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(0).respuesta);
            rd2.setText(listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(1).respuesta);
            rd3.setText(listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(2).respuesta);
            dialog.show();

            Button btnRespuesta = (Button) dialog.findViewById(R.id.btnValidaRespuesta);
            Button btnCancelar = (Button) dialog.findViewById(R.id.btnSalir);
            btnRespuesta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(rd1.isChecked()){
                        if(listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(0).esCorrecta){
                            MostrarMensaje("Muy Bien! Respuesta Correcta" ,true);
                        }
                        if(!listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(0).esCorrecta){
                            MostrarMensaje("Vuelve a intentarlo", false);
                        }

                    }else if(rd2.isChecked()){
                        if(listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(1).esCorrecta){
                            MostrarMensaje("Muy Bien! Respuesta Correcta", true);
                        }
                        if(!listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(1).esCorrecta){
                            MostrarMensaje("Vuelve a intentarlo", false);
                        }

                    }else{
                        if(listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(2).esCorrecta){
                            MostrarMensaje("Muy Bien! Respuesta Correcta", true);
                        }
                        if(!listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(2).esCorrecta){
                            MostrarMensaje("Vuelve a intentarlo", false);
                        }

                    }

                }
            });
            btnCancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close dialog
                    dialog.dismiss();
                }
            });


        }
    }

    public void ValidarRespuesta(View v){

        RadioButton rd1 = (RadioButton) findViewById(R.id.rd_1);
        RadioButton rd2 = (RadioButton) findViewById(R.id.rd_2);
        RadioButton rd3 = (RadioButton) findViewById(R.id.rd_3);

        if(rd1.isChecked()){
            if(listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(0).esCorrecta){
               MostrarMensaje("Muy Bien! Respuesta Correcta", null);
            }
            if(!listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(0).esCorrecta){
                MostrarMensaje("Vuelve a intentarlo", null);
            }

        }else if(rd2.isChecked()){
            if(listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(1).esCorrecta){
                MostrarMensaje("Muy Bien! Respuesta Correcta", null);
            }
            if(!listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(1).esCorrecta){
                MostrarMensaje("Vuelve a intentarlo", null);
            }

        }else{
            if(listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(2).esCorrecta){
                MostrarMensaje("Muy Bien! Respuesta Correcta", null);
            }
            if(!listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(2).esCorrecta){
                MostrarMensaje("Vuelve a intentarlo", null);
            }

        }

    }


    public void MostrarMensaje(String texto, Boolean esCorrcta){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_custom,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        TextView text = (TextView) layout.findViewById(R.id.text);
        ImageView img = (ImageView) layout.findViewById(R.id.img);
        text.setText(texto);
        if(esCorrcta){
            img.setImageResource(R.drawable.feliz);
        }else{
            img.setImageResource(R.drawable.carita_triste);
        }

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();


    }

    private void rotate(float angle) {
        Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(DURATION);
        imageViewExpand.startAnimation(animation);
    }

}

