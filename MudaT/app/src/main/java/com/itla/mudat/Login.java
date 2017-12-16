package com.itla.mudat;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.itla.mudat.dao.DbConnection;
import com.itla.mudat.dao.UsuarioDbo;
import com.itla.mudat.view.RegistroUsuario;

import java.sql.SQLDataException;

public class Login extends AppCompatActivity {

    TextView tvRegistrese;
    Button btnIngresar;
    UsuarioDbo usuarioDbo =new UsuarioDbo(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvRegistrese = findViewById(R.id.tvRegistrese);

        tvRegistrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtUsuEmail = findViewById(R.id.txtEmail);
                EditText txtClav = findViewById(R.id.txtClave);

                try {
                    Cursor cursor =  usuarioDbo.ConsultarUsuClav(txtUsuEmail.getText().toString(),txtClav.getText().toString());

                    if( cursor.getCount() > 0)
                    {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Usuario y/o Clave Incorrecto",
                                Toast.LENGTH_LONG).show();
                    }
                    txtUsuEmail.setText("");
                    txtClav.setText("");
                    txtUsuEmail.findFocus();
                } catch (SQLDataException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
