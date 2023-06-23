package com.example.dogprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button bt_ver_perfil;
    private Button bt_ver_informacoes;

    private Button bt_ver_latidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IniciarComponentes();


        bt_ver_latidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Intent intent = new Intent(MainActivity.this, SoundDogs.class);
                startActivity(intent);
            }
        });


        bt_ver_informacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Intent intent = new Intent(MainActivity.this, ListInformation.class);
                startActivity(intent);
            }
        });

        bt_ver_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TelaPrincipal.class);
                startActivity(intent);
            }
        });

    }


//    private void TelaPrincipal() {
//        Intent intent = new Intent(MainActivity.this, TelaPrincipal.class);
//        startActivity(intent);
//    }


    private void IniciarComponentes() {
        bt_ver_perfil = findViewById(R.id.bt_ver_perfil);
        bt_ver_informacoes = findViewById(R.id.bt_ver_informacoes);
        bt_ver_latidos = findViewById(R.id.bt_ver_latidos);
    }
}