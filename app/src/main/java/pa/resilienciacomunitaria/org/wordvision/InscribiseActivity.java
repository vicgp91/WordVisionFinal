package pa.resilienciacomunitaria.org.wordvision;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;


public class InscribiseActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Toolbar toolbarCard;
    private EditText txvNombre, txvEdad, txvTelefono, txvEmail;
    Spinner spinnerPais, spinnerGenero;
    private String ubicacion, genero;
    ProgressDialog dialog;

    private CheckBox checkBoxRescate, checkBoxDonacion, checkBoxOrganizacion;

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
        spinnerPais = (Spinner) findViewById(R.id.pais_spinner);
        spinnerGenero = (Spinner) findViewById(R.id.genero_spinner);
        txvEdad=(EditText)findViewById(R.id.edad);
        txvTelefono=(EditText)findViewById(R.id.telefono);
        txvTelefono=(EditText)findViewById(R.id.telefono);
        txvEmail=(EditText)findViewById(R.id.email);
        checkBoxDonacion=(CheckBox)findViewById(R.id.checkbox_donacion);
        checkBoxRescate=(CheckBox)findViewById(R.id.checkbox_rescate);
        checkBoxOrganizacion=(CheckBox)findViewById(R.id.checkbox_organizacion);
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

        ArrayAdapter<CharSequence> adapterGEnero = ArrayAdapter.createFromResource(this,
                R.array.genero_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGenero.setAdapter(adapterGEnero);

        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateName() || !validaEdad() || !validaTelefono() || !validaEmail() ) {

                    Toast.makeText(getApplicationContext(), "Complete todos los datos", Toast.LENGTH_SHORT).show();

                } else {

                    dialog = ProgressDialog.show(InscribiseActivity.this, "",
                            "Procesando Solicitud....", true);

                    new EnviarDatos(InscribiseActivity.this).execute();


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


    public Boolean registroUsuario(){
        try {
            String ubicacion, nombre, genero, edad, telefono, email, interes1="", interes2="", interes3="";


            ubicacion=spinnerPais.getSelectedItem().toString();
            nombre=txvNombre.getText().toString();
            genero=spinnerGenero.getSelectedItem().toString();
            edad=txvEdad.getText().toString();
            telefono=txvTelefono.getText().toString();
            email=txvEmail.getText().toString();
            if(checkBoxOrganizacion.isChecked()){
                interes1="Rescate";
            }
            if(checkBoxDonacion.isChecked()){
                interes2="Donaciones";
            }
            if(checkBoxOrganizacion.isChecked()){
                interes3="Organizacion";
            }

            URL url = new URL("https://docs.google.com/forms/d/17jL6w5SjeFcKlePNoV09u25IFBDVdV__LGbLpIjP7OY/formResponse");
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            conn.setDoInput(true);

            String urlParameters = "entry.432939312="+ubicacion+"&entry.525318752="+nombre+"&entry.1700987056="+genero+"&entry.2121113657="+edad+"&entry.1054429516="+telefono+"&entry.461351631="+email+"&entry.1452015913="+interes1+"&entry.1282439638="+interes2+"&entry.1535342956="+interes3+"";
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            int responseCode = conn.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            in.close();


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
                if(registroUsuario()){
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Datos enviados correctamente", Toast.LENGTH_SHORT).show();
                            txvNombre.setText("");
                            txvEdad.setText("");
                            txvEmail.setText("");
                            txvTelefono.setText("");
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
        } else {
            inputLayoutEdad.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validaTelefono() {
        if (txvTelefono.getText().toString().trim().isEmpty()) {
            txvTelefono.setError("Introduce un múmero teléfono");
            requestFocus(txvTelefono);
            return false;
        } else {
            inputLayoutTelefono.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validaEmail() {
        if (txvEmail.getText().toString().trim().isEmpty()) {
            txvEmail.setError("Introduce un email");
            requestFocus(txvEmail);
            return false;
        } else {
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








}
