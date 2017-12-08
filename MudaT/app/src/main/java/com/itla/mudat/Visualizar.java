package com.itla.mudat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Visualizar extends AppCompatActivity {

    private TextView txtVerTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        txtVerTexto = (TextView) findViewById(R.id.TeViVerTexto);

        Bundle VisualizarData = new Bundle();
        VisualizarData = getIntent().getExtras();
        txtVerTexto.setText(VisualizarData.getString("Nombre").toString());

    }
}
