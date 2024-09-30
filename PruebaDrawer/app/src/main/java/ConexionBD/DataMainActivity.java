package ConexionBD;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Entidades.Usuario;

public class DataMainActivity  {

    public ListView listaUsuarios;
    public Context contexto;

    public DataMainActivity(ListView lv, Context ct) {
        listaUsuarios = lv;
        contexto = ct;
            }

    public void ListarUsuarios(){

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(()->{
            ArrayList<Usuario> ListaUsuarios = new ArrayList<>();

            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection(DataDB.URLMYSQL, DataDB.USER, DataDB.PASSWORD);
                Statement st= conexion.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM Usuarios");

                while (rs.next()){

                    Usuario usuario = new Usuario(rs.getString("nombreUsuario"), rs.getString("emailUsuario"), rs.getString("passwordUsuario"));
                    ListaUsuarios.add(usuario);

                }
                rs.close();
                st.close();
                conexion.close();


            }
            catch (Exception e){
                e.printStackTrace();
            }

            new android.os.Handler(contexto.getMainLooper()).post(()->{
                UsuarioAdapter adapter = new UsuarioAdapter(contexto, ListaUsuarios);
                listaUsuarios.setAdapter(adapter);

                });


        });





    }



}
