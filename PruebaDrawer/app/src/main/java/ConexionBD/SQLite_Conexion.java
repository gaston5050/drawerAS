package ConexionBD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite_Conexion  extends SQLiteOpenHelper {


    public SQLite_Conexion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query= "create table Usuarios(id integer primary key autoincrement, nombreUsuario text, emailUsuario text, passwordUsuario text);";

        db.execSQL(query);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }


    public void cerrarConexion(){
        this.close();
    }
}
