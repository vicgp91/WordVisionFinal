package pa.resilienciacomunitaria.org.worldvision;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactoAdapter extends ArrayAdapter<ContactoEmergencias> {
    private Context context;
    private ArrayList<ContactoEmergencias> datos;


    public ContactoAdapter(Context context, ArrayList<ContactoEmergencias> datos) {
        super(context, R.layout.items_view, datos);
        this.context = context;
        this.datos = datos;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = LayoutInflater.from(context).inflate(
                R.layout.items_view, null);
        ImageView imagen = (ImageView) item.findViewById(R.id.imgInstitucion);
        imagen.setImageResource(datos.get(position).getImagen());

        TextView nombre = (TextView) item.findViewById(R.id.tvTitulo);
        nombre.setText(datos.get(position).getNombre());

        TextView numCelda = (TextView) item.findViewById(R.id.tvContenido);
        numCelda.setText(datos.get(position).getDescripcion());

        TextView telefono = (TextView) item.findViewById(R.id.tvTelefono);
        telefono.setText(datos.get(position).getTelefono());

        return item;
    }



}
