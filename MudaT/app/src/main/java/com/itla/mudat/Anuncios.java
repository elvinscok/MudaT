package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Anuncios extends AppCompatActivity {

    private Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios);

        btnAgregar = findViewById(R.id.btnAgregarAnuncios);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anuncio = new Intent(Anuncios.this,RegistraAnuncio.class);
                startActivity(anuncio);
            }
        });
    }
}
