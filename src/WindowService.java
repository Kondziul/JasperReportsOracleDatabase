import net.sf.jasperreports.engine.JRException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;

public class WindowService extends JPanel {

    JButton repOneButton;

    JButton repTwoButton;

    JButton repThreeButton;

    JButton repFourButton;

    JTextArea firstCondition = new JTextArea("ARGUMENT 1");
    JTextArea secondCondition = new JTextArea("ARGUMENT 2");

    Connection oracle;

    public WindowService(Connection oracle)
    {
        this.oracle = oracle;
        ActionListener actionListener = new ActionListener();
        setBackground(Color.BLACK);

        GridLayout gridLayout = new GridLayout(3, 2, 50, 50);
        setLayout(gridLayout);

        Font f1 = new Font(Font.SANS_SERIF,  Font.ITALIC , 15);
        Color color = Color.red;

        repOneButton = new JButton("Wypożyczenia pogrupowane według miast");
        repOneButton.setFont(f1);
        repOneButton.setForeground(color);
        add(repOneButton);
        repOneButton.addActionListener(actionListener);

        repTwoButton = new JButton("HULAJNOGI ARGUMENTY(1:maksymalna waga, 2:maksymalna prędkość)");
        repTwoButton.setFont(f1);
        repTwoButton.setForeground(color);
        add(repTwoButton);
        repTwoButton.addActionListener(actionListener);

        repThreeButton = new JButton("WYKRES DOSTĘPNYCH HULAJNÓG");
        repThreeButton.setFont(f1);
        repThreeButton.setForeground(color);
        add(repThreeButton);
        repThreeButton.addActionListener(actionListener);


        repFourButton = new JButton("WYDRUK FAKTURY ARGUMENTY(1:numer faktury)");
        repFourButton.setFont(f1);
        repFourButton.setForeground(color);
        add(repFourButton);
        repFourButton.addActionListener(actionListener);

        add(firstCondition);
        add(secondCondition);
    }
    private class ActionListener implements java.awt.event.ActionListener{

        ReportsFromJasper jaspRepGen;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(repOneButton)){
                repOne();
            }
            else if (e.getSource().equals(repTwoButton)){
                repTwo();
            }
            else if (e.getSource().equals(repThreeButton)){
                repThree();
            }
            else if (e.getSource().equals(repFourButton)){
                repFour();
            }

        }
        private void repOne(){
            jaspRepGen = new ReportsFromJasper(oracle);
            try {
                jaspRepGen.generateRepOne();
            } catch (JRException e) {
                throw new RuntimeException();
            }

        }
        private void repTwo(){
            jaspRepGen = new ReportsFromJasper(oracle);
            String argOne = firstCondition.getText();
            String argTwo = secondCondition.getText();
            try {
                jaspRepGen.generateRepTwo(argOne, argTwo);
            } catch (JRException e) {
                throw new RuntimeException(e);
            }

        }
        private void repThree(){
            jaspRepGen = new ReportsFromJasper(oracle);
            try {
                jaspRepGen.generateRepThree();
            } catch (JRException e) {
                throw new RuntimeException();
            }

        }
        private void repFour(){
            jaspRepGen = new ReportsFromJasper(oracle);
            String argOne = firstCondition.getText();
            try {
                jaspRepGen.generateRepFour(argOne);
            } catch (JRException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
