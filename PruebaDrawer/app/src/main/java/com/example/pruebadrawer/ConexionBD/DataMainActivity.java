package com.example.pruebadrawer.ConexionBD;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.pruebadrawer.Adapter.UsuarioAdapter;
import com.example.pruebadrawer.Entidades.Usuario;

public class DataMainActivity  {

    public ListView listaUsuarios;
    public Context contexto;
    public TextView tv;

    public DataMainActivity() {


    }

    public DataMainActivity(ListView lv, Context ct) {
        listaUsuarios = lv;
        contexto = ct;

            }



    public boolean agregarUsuario(String nombre, String email, String password) {
        ExecutorService ejecutor = Executors.newSingleThreadExecutor();
        ejecutor.execute(() -> {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conex = DriverManager.getConnection(DataDB.URLMYSQL, DataDB.USER, DataDB.PASSWORD);
                String sql = "INSERT INTO usuarios (nombre, email, password) VALUES (?,?,?)";
                PreparedStatement ps = conex.prepareStatement(sql);
                ps.setString(1, nombre);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.executeUpdate();
                ps.close();
                conex.close();



            } catch (Exception e) {
                e.getMessage();

                Toast.makeText(contexto, e.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
        return true;

    }

    public void ListarUsuarios(){

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(()->{
            ArrayList<Usuario> ListaUsuarios = new ArrayList<>();
            Log.d(TAG, "ListarUsuarios: " + DataDB.URLMYSQL);
            Log.d(TAG, "ListarUsuarios: " + DataDB.USER);
            Log.d(TAG, "ListarUsuarios: " + DataDB.PASSWORD);
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conex = DriverManager.getConnection(DataDB.URLMYSQL, DataDB.USER, DataDB.PASSWORD);
                Statement st= conex.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM usuarios");

                while (rs.next()){

                    Usuario usuario = new Usuario(rs.getString("nombre"), rs.getString("email"), rs.getString("password"));
                    ListaUsuarios.add(usuario);

                }
                rs.close();
                st.close();
                conex.close();


            }
            catch (Exception e){

                new android.os.Handler(contexto.getMainLooper()).post(() -> {
                    Toast.makeText(contexto, e.getMessage(), Toast.LENGTH_LONG).show();
                    Log.d(TAG, e.getMessage() + " ");
                });
                Log.e("DatabaseError", "Error en la conexión: ", e);

                e.printStackTrace();
            }

            new android.os.Handler(contexto.getMainLooper()).post(()->{
                UsuarioAdapter adapter = new UsuarioAdapter(contexto, ListaUsuarios);
                listaUsuarios.setAdapter(adapter);

                });


        });





    }



}
