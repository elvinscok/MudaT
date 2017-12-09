package com.itla.mudat.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.R;
import com.itla.mudat.dao.UsuarioDbo;

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
    private Usuario usuario;
    private Button btListar;

    private UsuarioDbo usuarioDbo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);


        txNombre = (EditText) findViewById(R.id.editTextNombre);
        txTipoUsuario = (EditText) findViewById(R.id.editTextTipoUsuario);
        txIdentificacion = (EditText) findViewById(R.id.editTextIdentificacion);
        txEmail = (EditText) findViewById(R.id.editTextEmail);
        txTelefono = (EditText) findViewById(R.id.editTextTelefono);
        txClave = (EditText) findViewById(R.id.editTextClave);
        txEstatus = (EditText) findViewById(R.id.editTextEstatus);
        btGuardar = (Button) findViewById(R.id.buttonGuardar);
        btListar = (Button) findViewById(R.id.buttonListar);

        usuario = new Usuario();
        editarUsuarios();

        usuarioDbo = new UsuarioDbo(getApplicationContext());


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

                    if (usuario.getId() <= 0) {
                        usuarioDbo.crear(usuario);
                    }
                    else
                    {
                        usuarioDbo.Editar(usuario);
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
                List<Usuario>listaUsuario = usuarioDbo.buscar();
                for(Usuario u : listaUsuario)
                {
                    Toast.makeText(RegistroUsuario.this,usuario.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });


    }


    private void editarUsuarios()
    {
        Bundle parametros = getIntent().getExtras();

        if(parametros != null && parametros.getSerializable("usuarios") != null)
        {
            usuario = (Usuario) parametros.getSerializable("usuario");
            txNombre.setText(usuario.getNombre());
            txTelefono.setText(usuario.getTelefono());
            txEmail.setText(usuario.getEmail());
            txIdentificacion.setText(usuario.getIdentificacion());
            txClave.setText(usuario.getClave());
        }
    }


}
