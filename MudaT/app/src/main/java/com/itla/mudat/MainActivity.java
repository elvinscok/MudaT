package com.itla.mudat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.text.TextUtils;

import com.itla.mudat.view.RegistroUsuario;

public class MainActivity extends AppCompatActivity {


    private  Button btnUsuarios;
    private Button btnAnuncios;
    private Button btnCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUsuarios = findViewById(R.id.btnUsuarios);
        btnAnuncios = findViewById(R.id.btnAnuncios);
        btnCategorias = findViewById(R.id.btnCategorias);


        btnUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent usuario = new Intent(MainActivity.this, Usuarios.class);
                startActivity(usuario);


            }

        });

        btnAnuncios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anuncio = new Intent(MainActivity.this,Anuncios.class);
                startActivity(anuncio);
            }
        });

       /* btnRegistroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Toast.makeText(MainActivity.this,"HOLA: ".concat(txtnombre.getText().toString()), Toast.LENGTH_LONG).show();

                Intent registroUsuario =new Intent(MainActivity.this,RegistroUsuario.class);

                startActivity(registroUsuario);


            }

        });*/
    }
}
