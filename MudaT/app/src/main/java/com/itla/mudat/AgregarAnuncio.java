package com.itla.mudat;

import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.Entity.Categoria;
import com.itla.mudat.dao.AnuncioDbo;
import com.itla.mudat.dao.CategoriaDbo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgregarAnuncio extends AppCompatActivity {


    private static final String LOG_T = "AgregarAnuncio";
    //  private EditText txCategoria;
    //  private EditText txUsuario;
    //  private EditText txFecha;
    private EditText txCondicion;
    private EditText txPrecio;
    private EditText txTitulo;
    private EditText txUbicacion;
    private EditText txDetalle;
    private Button btnGuardar;
    private Categoria categoria;
    private CategoriaDbo categoriaDbo;
    private AnuncioDbo anuncioDbo;
    private Spinner spinnercategoria;
    Anuncio anuncio;
    public Map elegido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_anuncio);

        try {

            anuncio = new Anuncio();
            ;
            // txCategoria = (EditText) findViewById(R.id.editTextCategoria);
            // txUsuario = (EditText) findViewById(R.id.editTextUsuario);
            //  txFecha = (EditText) findViewById(R.id.editTextFecha);
            txCondicion = (EditText) findViewById(R.id.editTextCondicion);
            txPrecio = (EditText) findViewById(R.id.editTextPrecio);
            txTitulo = (EditText) findViewById(R.id.editTextTitulo);
            txUbicacion = (EditText) findViewById(R.id.editTextUbicacion);
            txDetalle = (EditText) findViewById(R.id.editTextDetalle);
            btnGuardar = (Button) findViewById(R.id.buttonGuardarAnuncio);
            spinnercategoria = (Spinner) findViewById(R.id.idspinnercategoria);
            llenarspinnercategoria();
            anuncioDbo = new AnuncioDbo(this);

            btnGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {

                        if (elegido != null)
                            anuncio.setCategoria((Integer) elegido.get("id"));

                        else
                            anuncio.setCategoria(1);

                        anuncio.setUsuario(1);
                        Date date = new Date();
                        anuncio.setFecha(date);
                        anuncio.setCondicion(txCondicion.getText().toString());
                        anuncio.setPrecio(txPrecio.getText().toString());
                        anuncio.setTitulo(txTitulo.getText().toString());
                        anuncio.setUbicacion(txUbicacion.getText().toString());
                        anuncio.setDetalle(txDetalle.getText().toString());
                        anuncioDbo.crear(anuncio);
                        Log.i(LOG_T, "Agregando Anuncio" + anuncio.toString());
                    } catch (Exception e) {
                        Toast.makeText(AgregarAnuncio.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            spinnercategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    try {
                        elegido = (Map) parent.getItemAtPosition(position);
                        if (elegido != null) {
                        }

                    } catch (Exception e) {

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } catch (
                Exception e)

        {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }



    private void llenarspinnercategoria() {
        try {
            categoriaDbo = new CategoriaDbo(getApplicationContext());

            List<Map<String, String>> listacategorias = new ArrayList<Map<String, String>>();
            listacategorias = categoriaDbo.Llenarspinner();
            if (listacategorias.size() > 0) {

                SimpleAdapter adapter = new SimpleAdapter(AgregarAnuncio.this, listacategorias, R.layout.lista_spinner_categoria, new String[]{"id", "descripcion"}, new int[]{R.id.txvIDcategria, R.id.txvdetalle});
                spinnercategoria.setAdapter(adapter);
            } else {
                Toast.makeText(getApplicationContext(), "No hay Categorias Registradas.", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void SeleccionarSpinner(List<Map<String,String>> spinner, String codigo) {

        try {

            Integer valor ;
            String cod;
            for ( valor = 0; valor<spinner.size();valor++) {
                Map<String, String> mapeo = spinner.get(valor);
                cod = mapeo.get("id");

                if(cod.equals(codigo)) {

                    spinnercategoria.setSelection(valor);
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }



    }


    private void editarAnuncio() {
        Bundle parametros = getIntent().getExtras();

        if (parametros != null && parametros.getSerializable("anuncio") != null) {
            anuncio = (Anuncio) parametros.getSerializable("anuncio");

            txTitulo.setText(anuncio.getCategoria());
            txDetalle.setText(anuncio.getDetalle());
            txCondicion.setText(anuncio.getCondicion());
            txPrecio.setText(anuncio.getPrecio());
            txUbicacion.setText(anuncio.getUbicacion());


        }
    }
}

