package com.monti.mascotas.fragment;


import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.monti.mascotas.R;
import com.monti.mascotas.adapter.MascotaAdaptador;
import com.monti.mascotas.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {
    ArrayList<Mascota> misMascotas;
    private RecyclerView listaMascotas;


    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);

        listaMascotas.setLayoutManager(llm);

        misMascotas = new ArrayList<Mascota>();
        misMascotas.add(new Mascota("Garfield", R.drawable.gardfielito));
        misMascotas.add(new Mascota("Miss", R.drawable.gatito));
        misMascotas.add(new Mascota("Pluto", R.drawable.plutito));
        misMascotas.add(new Mascota("Santa", R.drawable.santito));
        misMascotas.add(new Mascota("Scooby", R.drawable.scoobyto));
        misMascotas.add(new Mascota("Tom", R.drawable.tomito));

        //     Toast.makeText(ListaMascotas.this, "He creado todas las mascotas ", Toast.LENGTH_SHORT).show();
        //  Snackbar.make(nose, "Estooooy pasando........", Snackbar.LENGTH_SHORT);

        inicializaAdaptador();

        return v;
    }

    private void inicializaAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(misMascotas);
        listaMascotas.setAdapter(adaptador);
    }
}
