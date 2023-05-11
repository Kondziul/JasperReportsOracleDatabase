import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {

            Connection oracle = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","wypozyczalnia", "******");
            new Window(oracle);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
}