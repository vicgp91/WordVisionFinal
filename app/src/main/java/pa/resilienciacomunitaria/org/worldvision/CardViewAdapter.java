package pa.resilienciacomunitaria.org.worldvision;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {


    private ArrayList<AtencionesEmergencias> items;
    private String titulo;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public ImageView imagen;
        public TextView nombre;
        public TextView visitas;
        private Toolbar toolbarCard;


        public ViewHolder(View  v) {
            super(v);
           // imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
             toolbarCard = (Toolbar) v.findViewById(R.id.toolbarCard);
           // visitas = (TextView) v.findViewById(R.id.visitas);
        }
    }



    public CardViewAdapter(ArrayList<AtencionesEmergencias> items, String titulo) {
        this.items = items;
        this.titulo=titulo;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_cardview, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.imagen.setImageResource(items.get(position).getImagen());
        holder.nombre.setText(items.get(position).getDescripcion());
        holder.toolbarCard.setTitle(items.get(position).getTitulo());
    }



}
