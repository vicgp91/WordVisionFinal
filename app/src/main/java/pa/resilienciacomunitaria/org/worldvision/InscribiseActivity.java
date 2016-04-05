package pa.resilienciacomunitaria.org.worldvision;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;

import fr.ganfra.materialspinner.MaterialSpinner;


public class InscribiseActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Toolbar toolbarCard;
    private EditText txvNombre, txvEdad, txvTelefono, txvEmail;
    MaterialSpinner spinnerPais, spinnerGenero;
    private String ubicacion, genero;
    ProgressDialog dialog;
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private CheckBox checkbox_taller, checkbox_instructor, checkbox_donaciones, checkbox_aprender;

    private TextInputLayout inputLayoutName, inputLayoutEdad, inputLayoutTelefono, inputLayoutEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscribise);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarCard = (Toolbar) findViewById(R.id.toolbarCard);
        toolbarCard.setTitle("Inscribite como voluntario");
        toolbarCard.setSubtitle("Completa los siguientes datos: ");

        txvNombre=(EditText)findViewById(R.id.nombre);
        spinnerPais = (MaterialSpinner) findViewById(R.id.pais_spinner);
        spinnerGenero = (MaterialSpinner) findViewById(R.id.genero_spinner);
        txvEdad=(EditText)findViewById(R.id.edad);
        txvTelefono=(EditText)findViewById(R.id.telefono);
        txvTelefono=(EditText)findViewById(R.id.telefono);
        txvEmail=(EditText)findViewById(R.id.email);

        checkbox_taller=(CheckBox)findViewById(R.id.checkbox_taller);
        checkbox_instructor=(CheckBox)findViewById(R.id.checkbox_instructor);
        checkbox_donaciones=(CheckBox)findViewById(R.id.checkbox_donaciones);
        checkbox_aprender=(CheckBox)findViewById(R.id.checkbox_aprender);
        Button insertar = (Button) findViewById(R.id.registro);

        inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_name);
        inputLayoutEdad = (TextInputLayout) findViewById(R.id.input_layout_edad);
        inputLayoutTelefono=(TextInputLayout) findViewById(R.id.input_layout_telefono);
        inputLayoutEmail=(TextInputLayout) findViewById(R.id.input_layout_email);

        txvNombre.addTextChangedListener(new MyTextWatcher(txvNombre));
        txvEdad.addTextChangedListener(new MyTextWatcher(txvEdad));
        txvTelefono.addTextChangedListener(new MyTextWatcher(txvTelefono));
        txvEmail.addTextChangedListener(new MyTextWatcher(txvEmail));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pais_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPais.setAdapter(adapter);
        spinnerPais.setHint("Escoja un País");
        spinnerPais.setSelection(14);


        ArrayAdapter<CharSequence> adapterGEnero = ArrayAdapter.createFromResource(this,
                R.array.genero_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGenero.setAdapter(adapterGEnero);
        spinnerGenero.setHint("Selecciona Género");

        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateName() || !validaEdad() || !validaTelefono() || !validaEmail() || !validaPais() || !validaGenero()) {

                } else {

                    if(!isOnline(InscribiseActivity.this)){
                        dialog(null);
                    }
                    else{
                        dialog = ProgressDialog.show(InscribiseActivity.this, "",
                                "Procesando Solicitud....", true);
                        new EnviarDatos(InscribiseActivity.this).execute();
                    }

                }


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inscribise, menu);
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


    public String CargarPreferencia(){
        SharedPreferences prefs = getSharedPreferences("Inscribciones", Context.MODE_PRIVATE);
        String jsonObject = prefs.getString("lista", "");
        return jsonObject;
    }


    public Boolean registroUsuario(Boolean tieneRed){
        try {
            String ubicacion, nombre, genero, edad, telefono, email, interes1="", interes2="", interes3="";
            ubicacion=spinnerPais.getSelectedItem().toString();
            nombre=txvNombre.getText().toString();
            genero=spinnerGenero.getSelectedItem().toString();
            edad=txvEdad.getText().toString();
            telefono=txvTelefono.getText().toString();
            email=txvEmail.getText().toString();

            String intereses="";

            if(checkbox_taller.isChecked()){
                intereses=intereses+" Talleres Comunitarios,";
            }
            if(checkbox_instructor.isChecked()){
                intereses=intereses+" Instructor voluntario,";
            }
            if(checkbox_donaciones.isChecked()){
                intereses=intereses+" Donaciones,";
            }

            if(checkbox_aprender.isChecked()){
                intereses=intereses+" Aprender sobre evaluaciones de daño.";
            }


            if(tieneRed) {
                URL url = new URL("https://docs.google.com/forms/d/17jL6w5SjeFcKlePNoV09u25IFBDVdV__LGbLpIjP7OY/formResponse");
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                conn.setDoInput(true);
                String urlParameters = "entry.432939312=" + ubicacion + "&entry.525318752=" + nombre + "&entry.1700987056=" + genero + "&entry.2121113657=" + edad + "&entry.1054429516=" + telefono + "&entry.461351631=" + email + "&entry.1452015913=" + intereses + "&entry.1282439638=" + interes2 + "&entry.1535342956=" + interes3 + "";
                conn.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
                wr.writeBytes(urlParameters);
                wr.flush();
                wr.close();
                int responseCode = conn.getResponseCode();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));

                in.close();
            }
            else{

                ArrayList<Participante> participanteList = new ArrayList<Participante>();

                String gson = CargarPreferencia();
                Type listType = new TypeToken<ArrayList<Participante>>() {
                }.getType();

                if(!gson.equalsIgnoreCase("")){
                    participanteList = new Gson().fromJson(gson, listType);
                }


                participanteList.add(new Participante(ubicacion, nombre, genero, edad, telefono, email, intereses, interes2, interes3));

                SharedPreferences prefs = getSharedPreferences("Inscribciones",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("lista", new Gson().toJson(participanteList));
                editor.commit();

                txvNombre.setText("");
                txvEdad.setText("");
                txvEmail.setText("");
                txvTelefono.setText("");



            }




            return true;
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    class EnviarDatos extends AsyncTask<String,String,String> {
        private Activity context;
        EnviarDatos(Activity contex){
            this.context=contex;
        }

        @Override
        protected  String doInBackground(String... params){
                if(registroUsuario(true)){
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Datos enviados correctamente", Toast.LENGTH_SHORT).show();
                            txvNombre.setText("");
                            txvEdad.setText("");
                            txvEmail.setText("");
                            txvTelefono.setText("");
                            checkbox_taller.setChecked(false);
                            checkbox_instructor.setChecked(false);
                            checkbox_donaciones.setChecked(false);
                            checkbox_aprender.setChecked(false);
                            dialog.cancel();

                        }
                    });
                }
                else{
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Datos no enviados", Toast.LENGTH_SHORT).show();

                        }
                    });
                }



            return null;
        }

    }

    private boolean validateName() {
        if (txvNombre.getText().toString().trim().isEmpty()) {
            txvNombre.setError("Introduce tu nombre");
            requestFocus(txvNombre);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validaEdad() {
        if (txvEdad.getText().toString().trim().isEmpty()) {
            txvEdad.setError("Introduce edad");
            requestFocus(txvEdad);
            return false;
        }
        else if(Integer.parseInt(txvEdad.getText().toString().trim())<=0){
            txvEdad.setError("Edad  Inválida");
            requestFocus(txvEdad);
            return false;
        }

        else {
            inputLayoutEdad.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validaTelefono() {
        if (txvTelefono.getText().toString().trim().isEmpty()) {
            txvTelefono.setError("Introduce un número teléfono");
            requestFocus(txvTelefono);
            return false;
        } else {
            inputLayoutTelefono.setErrorEnabled(false);
        }

        return true;
    }

    public boolean validaPais(){
        if(spinnerPais.getSelectedItem().toString().equalsIgnoreCase("Escoja un País")){
            spinnerPais.setError("Escoja un País");
            return false;
        }
        return true;
    }

    public boolean validaGenero(){
        if(spinnerGenero.getSelectedItem().toString().equalsIgnoreCase("Selecciona Género")){
            spinnerGenero.setError("Selecciona Género");
            return false;
        }
        return true;
    }

    private boolean validaEmail() {
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(txvEmail.getText().toString().trim());
        if (txvEmail.getText().toString().trim().isEmpty()) {
            txvEmail.setError("Introduce un email");
            requestFocus(txvEmail);
            return false;
        } else if(!matcher.matches()){
            txvEmail.setError("Dirección de email inválido");
            requestFocus(txvEmail);
            return false;
        }

        else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.nombre:
                   // validateName();
                    break;
                case R.id.email:
                  // validaEmail();
                    break;
                case R.id.edad:
                   // validaEdad();

                case R.id.telefono:
                    //validaTelefono();
                    break;
            }
        }
    }

    private boolean isOnline(Context context) {
        boolean isInternetAvailable = false;
        try
        {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if(networkInfo != null && (networkInfo.isConnected()))
            {
                isInternetAvailable  = true;
            }
        }
        catch(Exception exception)
        {

        }

        return isInternetAvailable;
    }

    public  void dialog(String jsonObject)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                InscribiseActivity.this);
        alertDialogBuilder.setTitle("Sin Conexión a internet");
        alertDialogBuilder.setMessage("¿Deseas guardar la información en tu dispositivo para que luego los datos se envién cuando" +
                " tengas acceso a internet?").setCancelable(false).
                setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                //String phoneNumber = n;
                //Intent callintent = new Intent(Intent.ACTION_CALL);
                //callintent.setData(Uri.parse("tel:" + phoneNumber));
               // startActivity(callintent);
                registroUsuario(false);

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    };

}
