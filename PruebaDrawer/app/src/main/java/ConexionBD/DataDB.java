package ConexionBD;

public class DataDB {

    //Datos DB
    public static String HOST = "sql10.freesqldatabase.com";
    public static String DBNAME ="sql10734171";
    public static String USER = "sql10734171";
    public static String PASSWORD = "BCfA6SZij5";
    public static int PORT = 3306;

    //Informacion para la conexión

    public static String URLMYSQL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DBNAME;
    public static String Driver = "com.mysql.jdbc.Driver";

}
