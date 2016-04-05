package pa.resilienciacomunitaria.org.worldvision;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
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

public class VerInfoPrimerosAuxilios extends AppCompatActivity {

    private TextView titulo, contenido;
    private ImageView imagen;
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

    public TextView nombre; //siguiente, anterior;

    Button siguiente, anterior;
    public TextView visitas;
    private Toolbar toolbarCard;
    private ArrayList<AtencionesEmergencias> listEmergencia;

    private Integer posicionPagina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_cardview);
        //setContentView(R.layout.activity_ver_info_primeros_auxilios
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
       // siguiente = (TextView) findViewById(R.id.siguiente);
       // anterior = (TextView) findViewById(R.id.anterior);
        siguiente=(Button) findViewById(R.id.siguiente);
        anterior = (Button) findViewById(R.id.anterior);

        imagen=(ImageView)findViewById(R.id.imagen);


        nombre.setText(Html.fromHtml(listEmergencia.get(0).getDescripcion()));
        nombre.setMovementMethod(LinkMovementMethod.getInstance());
        toolbarCard.setTitle(listEmergencia.get(0).getTitulo());
        imagen.setImageResource(listEmergencia.get(0).getImagen());
        toolbarCard.setSubtitle("Parte 1/" + String.valueOf(listEmergencia.size()));
        anterior.setVisibility(View.INVISIBLE);
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

            if (posicionPagina>1){
                anterior.setVisibility(v.VISIBLE);
            }

            if (posicionPagina == listEmergencia.size()) {
                siguiente.setText("Quiz!");
            }

            //nombre.setText(listEmergencia.get(posicionPagina - 1).getDescripcion());

            nombre.setText(Html.fromHtml(listEmergencia.get(posicionPagina - 1).getDescripcion()));
            nombre.setMovementMethod(LinkMovementMethod.getInstance());

            imagen.setImageResource(listEmergencia.get(posicionPagina - 1).getImagen());
            toolbarCard.setTitle(listEmergencia.get(posicionPagina - 1).getTitulo());
            toolbarCard.setSubtitle("Parte " + String.valueOf(posicionPagina) + "/" + String.valueOf(listEmergencia.size()));

        }
        if(siguiente.getText().equals("Quiz!") && posicionPagina > listEmergencia.size()){
            posicionPagina = posicionPagina -1;
            rd1.setText(listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(0).respuesta);
            rd2.setText(listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(1).respuesta);
            rd3.setText(listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(2).respuesta);
            dialog.show();

            Button btnRespuesta = (Button) dialog.findViewById(R.id.btnValidaRespuesta);
            Button btnCancelar = (Button) dialog.findViewById(R.id.btnSalir);
            btnRespuesta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (rd1.isChecked()) {
                        if (listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(0).esCorrecta) {
                            MostrarMensaje("Muy bien, vamos al siguiente tema", true);
                        }
                        if (!listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(0).esCorrecta) {
                            MostrarMensaje("Inténtalo una vez más, tu puedes!\n", false);
                        }

                    } else if (rd2.isChecked()) {
                        if (listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(1).esCorrecta) {
                            MostrarMensaje("Muy bien, vamos al siguiente tema", true);
                        }
                        if (!listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(1).esCorrecta) {
                            MostrarMensaje("Inténtalo una vez más, tu puedes!\n", false);
                        }

                    } else if (rd3.isChecked()) {
                        if (listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(2).esCorrecta) {
                            MostrarMensaje("Muy bien, vamos al siguiente tema", true);
                        }
                        if (!listEmergencia.get(0).getPreguntas().getRespuestasArrayList().get(2).esCorrecta) {
                            MostrarMensaje("Inténtalo una vez más, tu puedes!\n", false);
                        }

                    } else {
                        MostrarMensaje("Selecciona una opción", null);
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


    public void BackPage(View view){


        if (posicionPagina > 0) {

            posicionPagina = posicionPagina - 1;

            if (posicionPagina < listEmergencia.size()) {
                siguiente.setText("Siguiente");
            }

            if (posicionPagina>0){
                //nombre.setText(listEmergencia.get(posicionPagina - 1).getDescripcion());
                nombre.setText(Html.fromHtml(listEmergencia.get(posicionPagina - 1).getDescripcion()));
                nombre.setMovementMethod(LinkMovementMethod.getInstance());
                imagen.setImageResource(listEmergencia.get(posicionPagina - 1).getImagen());
                toolbarCard.setTitle(listEmergencia.get(posicionPagina - 1).getTitulo());
                toolbarCard.setSubtitle("Parte " + String.valueOf(posicionPagina) + "/" + String.valueOf(listEmergencia.size()));
            }
            if (posicionPagina==1){
                anterior.setVisibility(view.INVISIBLE);
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
        if(esCorrcta!=null){
            if(esCorrcta){
                img.setImageResource(R.drawable.correcta);
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
                /*Intent intent = new Intent(this, TwoFragment.class);
                startActivity(intent);*/


            }else{
                img.setImageResource(R.drawable.incorrecto);
            }
        }
       else{

        }

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
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

