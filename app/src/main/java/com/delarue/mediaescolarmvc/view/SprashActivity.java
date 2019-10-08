package com.delarue.mediaescolarmvc.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.delarue.mediaescolarmvc.R;
import com.delarue.mediaescolarmvc.controller.MediaEscolarController;
import com.delarue.mediaescolarmvc.model.MediaEscolar;
import java.util.List;

public class SprashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprash);

        apresentarTelaSplash();
    }

    private void apresentarTelaSplash(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                MediaEscolarController mediaEscolarController =
                        new MediaEscolarController(getBaseContext());

                List<MediaEscolar> objetos = mediaEscolarController.listar();

                for (MediaEscolar obj: objetos) {

                    Log.i("CRUD LISTAR","ID: "+obj.getId()+" - Materia: "+obj.getMateria()+ " - Situação "+obj.getSituacao());
                }

                Intent telaPrincipal
                        = new Intent(SprashActivity.this,MainActivity.class);
                startActivity(telaPrincipal);

                finish();

            }
        },SPLASH_TIME_OUT);
    }


}
