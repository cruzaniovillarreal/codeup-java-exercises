import javax.swing.*;
import java.awt.*;

public class Game {
    JFrame window;
    Container con;
    JPanel titleNamePanel1;
    JPanel titleNamePanel2;
    JPanel titleNamePanel3;
    JLabel titleNameLabel1;
    JLabel titleNameLabel2;
    JLabel titleNameLabel3;
    JPanel startButtonPanel;
    JButton startButton;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 40);

    public Game() {
        window = new JFrame("Spell-Lunker");
        window.setSize(800, 600);
        window.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        titleNamePanel1 = new JPanel();
        titleNamePanel1.setBounds(100,75,600,100);
        titleNamePanel1.setBackground(Color.black);

        titleNameLabel1 = new JLabel("WELCOME");
        titleNameLabel1.setForeground(Color.white);
        titleNameLabel1.setFont(titleFont);
        titleNamePanel1.add(titleNameLabel1);

        titleNamePanel2 = new JPanel();
        titleNamePanel2.setBounds(100,160,600,100);
        titleNamePanel2.setBackground(Color.black);

        titleNameLabel2 = new JLabel("TO");
        titleNameLabel2.setForeground(Color.white);
        titleNameLabel2.setFont(titleFont);
        titleNamePanel2.add(titleNameLabel2);

        titleNamePanel3 = new JPanel();
        titleNamePanel3.setBounds(100,245,600,100);
        titleNamePanel3.setBackground(Color.black);

        titleNameLabel3 = new JLabel("SPELL-LUNKER!");
        titleNameLabel3.setForeground(Color.blue);
        titleNameLabel3.setFont(titleFont);
        titleNamePanel3.add(titleNameLabel3);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setOpaque(true);
        startButton.setBorderPainted(false);
        startButton.setFont(buttonFont);
        startButtonPanel.add(startButton);


        con.add(titleNamePanel1);
        con.add(titleNamePanel2);
        con.add(titleNamePanel3);
        con.add(startButtonPanel);
        window.setVisible(true);

    }

    public static void main(String[] args) {
        new Game();
    }

}
