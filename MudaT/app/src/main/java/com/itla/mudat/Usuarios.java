package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.dao.UsuarioDbo;
import com.itla.mudat.view.RegistroUsuario;
import com.itla.mudat.view.listAdapter.UsuarioListAdapter;

import java.util.List;

public class Usuarios extends AppCompatActivity {

    private Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        btnAgregar = (Button) findViewById(R.id.buttonAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent registroUsuario =new Intent(Usuarios.this,RegistroUsuario.class);

                startActivity(registroUsuario);
            }
        });

        UsuarioDbo usuarioDbo =new UsuarioDbo(this);

        List<Usuario> usuarios= usuarioDbo.buscar();
        Log.i("Usuarios", "Cantidad de usuarios:" + usuarios.size());

        ListView listView = findViewById(R.id.listaUsuario);
        listView.setAdapter(new UsuarioListAdapter(usuarios, this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent rUsuario= new Intent(Usuarios.this, RegistroUsuario.class );
                Usuario u = (Usuario) adapterView.getItemAtPosition(i);

                rUsuario.putExtra("usuario", u);
                startActivity(rUsuario);
            }
        });


    }

}
