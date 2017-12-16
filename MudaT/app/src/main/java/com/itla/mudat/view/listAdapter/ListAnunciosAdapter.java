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
 * Created by elvinsalazar on 09/12/17.
 */

public class ListAnunciosAdapter extends BaseAdapter {

    private List<Anuncio> anuncios;
    private Activity context;

    public ListAnunciosAdapter(List<Anuncio> anuncios, Activity context)
    {
        this.anuncios = anuncios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return  anuncios.size();
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
        if(view == null)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.lista_anuncios_row,null);
        }

        TextView listaAnunciosTitulo = view.findViewById(R.id.txtTitulo);
        TextView listaAnunciosDetalles = view.findViewById(R.id.txtDetalle);

        Anuncio A = anuncios.get(i);

        listaAnunciosTitulo.setText(A.getTitulo());
        listaAnunciosDetalles.setText(A.getDetalle());

        return view;
    }
}
