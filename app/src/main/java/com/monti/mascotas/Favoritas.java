package com.monti.mascotas;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.monti.mascotas.adapter.MascotaAdaptador;
import com.monti.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity {

    ArrayList<Mascota> misMascotas;
    private RecyclerView listaFavoritas;

    private Toolbar toolbar;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

//************
//      Toolbar miActionBar = (Toolbar) findViewById(R.id.otroActionBar);
//      setSupportActionBar(miActionBar);
/*
        ActionBar actionBar = getSupportActionBar();
        //  actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(R.drawable.huellaback);
        actionBar.setTitle("");
*/
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Favoritas");
        }


        listaFavoritas = (RecyclerView) findViewById(R.id.rvFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager glm = new GridLayoutManager(this,2);

        listaFavoritas.setLayoutManager(llm);

        misMascotas = new ArrayList<Mascota>();

        misMascotas.add(new Mascota("Pluto", R.drawable.plutito));
        misMascotas.add(new Mascota("Santa", R.drawable.santito));
        misMascotas.add(new Mascota("Scooby", R.drawable.scoobyto));
        misMascotas.add(new Mascota("Tom", R.drawable.tomito));
        misMascotas.add(new Mascota("Miss", R.drawable.gatito));
        darLike();

    //     Toast.makeText(Favoritas.this, "He creado todas las mascotas ", Toast.LENGTH_SHORT).show();
    //  Snackbar.make(nose, "Estooooy pasando........", Snackbar.LENGTH_SHORT);

        inicializaAdaptador();

    }

    private void inicializaAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(misMascotas);
        listaFavoritas.setAdapter(adaptador);
    }

    private void darLike() {
        for (Mascota m:misMascotas) {
            m.setTantos();m.setTantos();m.setTantos();m.setTantos();m.setTantos();
        }
    }
}

