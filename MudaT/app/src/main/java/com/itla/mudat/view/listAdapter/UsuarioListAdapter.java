package com.itla.mudat.view.listAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.R;

import java.util.List;

/**
 * Created by elvinsalazar on 08/12/17.
 */

public class UsuarioListAdapter extends BaseAdapter{

   private List<Usuario> usuarios;
   private Activity context;

   public UsuarioListAdapter( List<Usuario> usuarios, Activity context)
   {
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
        if(view == null)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.activity_lista_usuario_row,null);
        }

        TextView listaUsuariosNombres = view.findViewById(R.id.luNombre);
        TextView listaUusariosEmails = view.findViewById(R.id.luEmail);

        Usuario u = usuarios.get(i);

        listaUsuariosNombres.setText(u.getNombre());
        listaUusariosEmails.setText(u.getEmail());

        return view;
    }
}
