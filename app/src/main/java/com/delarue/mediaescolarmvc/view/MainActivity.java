package com.delarue.mediaescolarmvc.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.delarue.mediaescolarmvc.R;
import com.delarue.mediaescolarmvc.fragments.BimestreAFragment;
import com.delarue.mediaescolarmvc.fragments.BimestreBFragment;
import com.delarue.mediaescolarmvc.fragments.BimestreCFragment;
import com.delarue.mediaescolarmvc.fragments.BimestreDFragment;
import com.delarue.mediaescolarmvc.fragments.ModeloFragment;
import com.delarue.mediaescolarmvc.fragments.ResultadoFinalFragment;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Botão flutuante

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


        // Segundo Passo
        fragmentManager = getSupportFragmentManager();

        // Quarto passo
        fragmentManager.beginTransaction().replace(R.id.content_fragment, new ModeloFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sair) {

            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_bimestre_a) {
            setTitle("Notas 1º Bimestre");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new BimestreAFragment()).commit();
        }else if (id == R.id.nav_bimestre_b) {
            setTitle("Notas 2º Bimestre");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new BimestreBFragment()).commit();
        }else if(id ==R.id.nav_bimestre_c){
            setTitle("Notas 3º Bimestre");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new BimestreCFragment()).commit();
        } else if(id==R.id.nav_bimestre_d){
            setTitle("Notas 4º Bimestre");
           fragmentManager.beginTransaction().replace(R.id.content_fragment,new BimestreDFragment()).commit();
        }else if(id==R.id.nav_resultado_final){
            setTitle("Resultado Final");
           fragmentManager.beginTransaction().replace(R.id.content_fragment,new ResultadoFinalFragment()).commit();
        }else if(id==R.id.nav_share){
        }

        DrawerLayout drawer=findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
        }

    public static String formatarValorDecimal(Double valor) {

        DecimalFormat df = new DecimalFormat("#,###,##0.00");

        return df.format(valor);
    }


        }
