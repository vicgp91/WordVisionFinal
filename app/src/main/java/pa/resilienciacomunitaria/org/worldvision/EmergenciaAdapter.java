package pa.resilienciacomunitaria.org.worldvision;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EmergenciaAdapter extends ArrayAdapter<PrimerosAuxilios> {
    private Context context;
    private ArrayList<PrimerosAuxilios> datos;


    public EmergenciaAdapter(Context context, ArrayList<PrimerosAuxilios> datos) {
        super(context, R.layout.items_auxilio, datos);
        this.context = context;
        this.datos = datos;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = LayoutInflater.from(context).inflate(
                R.layout.items_auxilio, null);
				
        ImageView imagen = (ImageView) item.findViewById(R.id.imgAux);

        imagen.setImageResource(datos.get(position).getImagen());

        TextView nombre = (TextView) item.findViewById(R.id.tvTituloAux);
        nombre.setText(datos.get(position).getNombre());

        TextView contenido = (TextView) item.findViewById(R.id.tvdescripcion);
        contenido.setText(datos.get(position).getDescripcion());
        return item;
    }



}
