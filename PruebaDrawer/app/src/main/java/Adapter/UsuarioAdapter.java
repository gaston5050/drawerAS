package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pruebadrawer.R;

import java.util.List;

import Entidades.Usuario;

public class UsuarioAdapter extends ArrayAdapter<Usuario> {


    public UsuarioAdapter(@NonNull Context contexto, @NonNull List<Usuario> objetos) {
        super(contexto, R.layout.activity_listado_usuarios, objetos);
    }


    @Override
    public View getView(int posicion, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.activity_listado_usuarios, null);

        TextView txtNombreUsuario = item.findViewById(R.id.txtNombreUsuario);
        TextView txtEmailUsuario = item.findViewById(R.id.txtEmailUsuario);
        TextView txtPasswordUsuario = item.findViewById(R.id.txtPasswordUsuario);
        txtNombreUsuario.setText(getItem(posicion).getNombreUsuario());
        txtEmailUsuario.setText(getItem(posicion).getEmailUsuario());
        txtPasswordUsuario.setText(getItem(posicion).getPasswordUsuario());


        return item;
    }
}
