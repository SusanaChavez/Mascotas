package com.monti.mascotas;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;


public class ListaMascotas extends AppCompatActivity {
    ArrayList<Mascota> misMascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_mascotas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        ActionBar actionBar = getSupportActionBar();
      //  actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(R.drawable.huellaback);
        actionBar.setHomeAsUpIndicator(R.drawable.back);
        actionBar.setTitle("");
        //Add the following code to make the up arrow white:
        //final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        //upArrow.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        //getSupportActionBar().setHomeAsUpIndicator(upArrow);

        //Estoy probando
       // actionBar.setIcon(android.R.color.transparent);
       // actionBar.setDisplayUseLogoEnabled(false);

        /* para cambiar la barra
           getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);


        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
getSupportActionBar().setTitle("My new title"); // set the top title
String title = actionBar.getTitle().toString(); // get the title
actionBar.hide();
         */

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

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

}


    private void inicializaAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(misMascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void irFavoritas(){
        Intent intent = new Intent(this, Favoritas.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        // or call onBackPressed()
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     //   Toast.makeText(ListaMascotas.this, Integer.toString(item.getItemId()), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.vStart:
               irFavoritas();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
