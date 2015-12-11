package pa.resilienciacomunitaria.org.wordvision;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OneFragment extends Fragment {

    private ArrayList<ContactoEmergencias> contactos;
    private ListView listContacto;
    private ContactoAdapter adapter;
    private TextView tvNombre, tvNumCelda, tvTelefono;

    View rootView;
    public OneFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_one, container, false);
        rootView = inflater.inflate(R.layout.fragment_one, container, false);

        contactos = new ArrayList<ContactoEmergencias>();
        rellenarArrayList();
        tvNombre = (TextView) rootView.findViewById(R.id.tvTitulo);
        tvNumCelda = (TextView) rootView.findViewById(R.id.tvContenido);
        tvTelefono = (TextView) rootView.findViewById(R.id.tvTelefono);

        adapter = new ContactoAdapter(this.getContext(), contactos);

        listContacto = (ListView) rootView.findViewById(R.id.listaNumeros);
        listContacto.setAdapter(adapter);

        listContacto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dialog(contactos.get(position).getTelefono());
                // MostrarNota(position);
            }
        });


        return rootView;
    }

    private void rellenarArrayList() {
        contactos.add(new ContactoEmergencias("Sistema Nacional de Protección Civíl", "SINAPROC", R.drawable.sinaproc, "*335"));
        contactos.add(new ContactoEmergencias("Proteger y Servir", "POLICÍA NACIONAL DE PANAMÁ", R.drawable.policia, "104"));
        contactos.add(new ContactoEmergencias("Benemérito Cuerpo de Bomberos de la República de Panamá", "BOMBEROS", R.drawable.bomberos, "103"));
        contactos.add(new ContactoEmergencias("Sistema Único de Manejo de Emergencias de la República de Panamá", "EMERGENCIAS SUME 911", R.drawable.sume, "911"));
        contactos.add(new ContactoEmergencias("Organización humanitaria.", "CRUZ ROJA PANAMEÑA", R.drawable.cruz, "*455"));

    }


    public  void dialog(final String n)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this.getContext());
        alertDialogBuilder.setTitle("Confirmar llamada");
        alertDialogBuilder.setMessage(n.toString()).setCancelable(false).
                setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).setPositiveButton("Llamar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
               // new EliminarNota(Notas.this).execute();

                String phoneNumber = n;
                Intent callintent = new Intent(Intent.ACTION_CALL);
                callintent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(callintent);

            }
        });



        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    };

}
