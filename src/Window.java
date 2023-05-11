import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
public class Window extends JFrame {

    public Window(Connection oracle) throws HeadlessException
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        WindowService windowService = new WindowService(oracle);
        add(windowService);
        setResizable(false);
        setVisible(true);
    }
}
