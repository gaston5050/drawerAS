package com.example.pruebadrawer.ConexionBD;

public class DataDB {

    //Datos DB
    public static String HOST = "sql10.freesqldatabase.com";
    public static String DBNAME ="sql10735242";
    public static String USER = "sql10735242";
    public static String PASSWORD = "FQAUVIsQj2";
    public static int PORT = 3306;

    //Informacion para la conexión

    public static String URLMYSQL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DBNAME+"?useSSL=false&allowPublicKeyRetrieval=true";

    public static String Driver = "com.mysql.jdbc.Driver";

}
