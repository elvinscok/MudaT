package com.itla.mudat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.Login;
import com.itla.mudat.MainActivity;
import com.itla.mudat.R;
import com.itla.mudat.dao.UsuarioDbo;
import com.itla.mudat.view.listAdapter.UsuarioListAdapter;

import java.util.List;

public class RegistroUsuario extends AppCompatActivity {


    private static final String LOG_T = "RegistroUsuario";
    private EditText txNombre;
    private EditText txTipoUsuario;
    private EditText txIdentificacion;
    private EditText txEmail;
    private EditText txTelefono;
    private EditText txClave;
    private EditText txEstatus;
    private Button btGuardar;
    private Button btListar;

    private UsuarioDbo usuarioDbo;
      Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

         usuario = new Usuario();

        txNombre = (EditText) findViewById(R.id.editTextNombre);
        txTipoUsuario = (EditText) findViewById(R.id.editTextTipoUsuario);
        txIdentificacion = (EditText) findViewById(R.id.editTextIdentificacion);
        txEmail = (EditText) findViewById(R.id.editTextEmail);
        txTelefono = (EditText) findViewById(R.id.editTextTelefono);
        txClave = (EditText) findViewById(R.id.editTextClave);
        btGuardar = (Button) findViewById(R.id.buttonGuardar);
        btListar = (Button) findViewById(R.id.buttonListar);


        editarUsuario();
        usuarioDbo = new UsuarioDbo(this);




        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                        usuario.setNombre(txNombre.getText().toString());
                        usuario.setIdentificacion(txIdentificacion.getText().toString());
                        usuario.setClave(txClave.getText().toString());
                        usuario.setEstatus(true);
                        usuario.setTelefono(txTelefono.getText().toString());
                        usuario.setEmail(txEmail.getText().toString());

                        Log.i(LOG_T, "Registrando Usuario:" + usuario.toString());

                        if (usuario.getId() <=0) {
                            usuarioDbo.crear(usuario);

                            Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                            startActivity(intent);

                        }else{
                            usuarioDbo.actualizar(usuario);
                            Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }


                } catch (Exception e) {
                    Toast.makeText(RegistroUsuario.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usuarioDbo = new UsuarioDbo(getApplicationContext());
                List<Usuario> listaUsuario = usuarioDbo.buscar();
                for (Usuario usu : listaUsuario) {
                    Toast.makeText(RegistroUsuario.this, usuario.toString(), Toast.LENGTH_LONG).show();



                }


            }
        });



    }


    private void editarUsuario() {
        Bundle parametros = getIntent().getExtras();

        if (parametros != null && parametros.getSerializable("usuario") != null) {
            usuario = (Usuario) parametros.getSerializable("usuario");

            txNombre.setText(usuario.getNombre());
            txIdentificacion.setText(usuario.getIdentificacion());
            txEmail.setText(usuario.getEmail());
            txTelefono.setText(usuario.getTelefono());
            txClave.setText(usuario.getClave());


        }
    }

}

