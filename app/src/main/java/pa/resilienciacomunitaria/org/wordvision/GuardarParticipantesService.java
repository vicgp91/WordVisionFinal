package pa.resilienciacomunitaria.org.wordvision;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
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

import javax.net.ssl.HttpsURLConnection;


public class GuardarParticipantesService extends Service {

    ArrayList<Participante> participanteList;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        participanteList = new ArrayList<Participante>();

        String gson = CargarPreferencia();
        Type listType = new TypeToken<ArrayList<Participante>>() {
        }.getType();

        if(!gson.equalsIgnoreCase("")){
            participanteList = new Gson().fromJson(gson, listType);

            SharedPreferences prefs = getSharedPreferences("Inscribciones",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("lista", "");
            editor.commit();

            new EnviarDatos().execute();

        }

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {

        super.onDestroy();

    }

    public Boolean registroUsuario(Participante participantes){
        try {
            String ubicacion=participantes.getUbicacion(),
                    nombre=participantes.getNombre(),
                    genero=participantes.getGenero(),
                    edad=participantes.getEdad(),
                    telefono=participantes.getTelefono(),
                    email=participantes.getEmail(),
                    interes1=participantes.getInteres1(),
                    interes2=participantes.getInteres2(),
                    interes3=participantes.getInteres3();

            URL url = new URL("https://docs.google.com/forms/d/17jL6w5SjeFcKlePNoV09u25IFBDVdV__LGbLpIjP7OY/formResponse");
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            conn.setDoInput(true);
            String urlParameters = "entry.432939312=" + ubicacion + "&entry.525318752=" + nombre + "&entry.1700987056=" + genero + "&entry.2121113657=" + edad + "&entry.1054429516=" + telefono + "&entry.461351631=" + email + "&entry.1452015913=" + interes1 + "&entry.1282439638=" + interes2 + "&entry.1535342956=" + interes3 + "";
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

    public String CargarPreferencia(){
        SharedPreferences prefs = getSharedPreferences("Inscribciones", Context.MODE_PRIVATE);
        String jsonObject = prefs.getString("lista", "");
        return jsonObject;
    }

    class EnviarDatos extends AsyncTask<String,String,String> {
        @Override
        protected  String doInBackground(String... params){
            for(Participante part : participanteList){
                if(registroUsuario(part)){
                }
            }
            return null;
        }

    }

}
