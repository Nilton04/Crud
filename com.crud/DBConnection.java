
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    public static Connection getConexion() throws SQLException{
        String URL = "jdbc:mysql://localhost:3306/bdpersonas";  //URL de coneccion a MYSql
        String USER = "root";  //Usuario de la base de datos
        String PASSWORD = "042397";  //contraseña de la base de datos
    
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

