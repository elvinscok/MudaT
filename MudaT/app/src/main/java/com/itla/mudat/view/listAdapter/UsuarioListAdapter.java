package com.itla.mudat.view.listAdapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.R;

import java.util.List;

/**
 * Created by Usuario on 12/2/2017.
 */

public class UsuarioListAdapter extends BaseAdapter {

   private List<Usuario> usuarios;
   private Activity context;

    public UsuarioListAdapter(List<Usuario> usuarios, Activity context) {
        this.usuarios = usuarios;
        this.context = context;
    }


    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int i) {
        return usuarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater inflater = context.getLayoutInflater();
            view= inflater.inflate(R.layout.lista_usuario_row, null);
        }
        TextView listaUsuarioNombre = view.findViewById(R.id.listaUsuarioNombre);
        TextView listaUsuarioEmail = view.findViewById(R.id.listaUsuarioEmail);

        Usuario u = usuarios.get(i);

        listaUsuarioNombre.setText(u.getNombre());
        listaUsuarioEmail.setText(u.getEmail());

        return view;
    }


}

