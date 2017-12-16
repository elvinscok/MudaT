package com.itla.mudat.view.listAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.R;

import java.util.List;

/**
 * Created by Usuario on 12/7/2017.
 */

public class AnuncioListAdapter extends BaseAdapter {

    private List<Anuncio> anuncios;
    private Activity context;

    public AnuncioListAdapter(List<Anuncio> anuncios, Activity context) {
        this.anuncios = anuncios;
        this.context = context;
    }


    @Override
    public int getCount() {
        return anuncios.size();
    }

    @Override
    public Object getItem(int i) {
        return anuncios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater inflater = context.getLayoutInflater();
            view= inflater.inflate(R.layout.lista_anuncio_row, null);
        }
        TextView listaAnuncioTitulo = view.findViewById(R.id.listaAnuncioTitulo);
        TextView listaAnuncioDetalle = view.findViewById(R.id.listaAnuncioDetalle);
        TextView listaAnuncioPrecio = view.findViewById(R.id.listaAnuncioPrecio);
        TextView listaAnuncioUbicacion = view.findViewById(R.id.listaAnuncioUbicacion);

        Anuncio a = anuncios.get(i);

        listaAnuncioTitulo.setText(a.getTitulo());
        listaAnuncioDetalle.setText(a.getDetalle());
        listaAnuncioPrecio.setText(a.getPrecio());
        listaAnuncioUbicacion.setText(a.getUbicacion());

        return view;
    }


}
