import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    JPanel mainTextPanel;
    JTextArea mainTextArea1;
    JTextArea mainTextArea2;
    JTextField playerName;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font textFont = new Font("Times New Roman", Font.PLAIN, 30);

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
        startButton.addActionListener(tsHandler);


        con.add(titleNamePanel1);
        con.add(titleNamePanel2);
        con.add(titleNamePanel3);
        con.add(startButtonPanel);
        window.setVisible(true);

    }

    public void createGameScreen() {
        titleNamePanel1.setVisible(false);
        titleNamePanel2.setVisible(false);
        titleNamePanel3.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.blue);
        con.add(mainTextPanel);

//        playerName = new JTextField(20);
//        mainTextArea.setBounds(100, 300, 300, 250);
//        mainTextArea.setBackground(Color.BLACK);
//        mainTextArea.setForeground(Color.white);
//        mainTextPanel.add(playerName);

        mainTextArea1 = new JTextArea("Enter Hero Name: ");
        mainTextArea1.setBounds(100, 100, 600, 250);
        mainTextArea1.setBackground(Color.BLACK);
        mainTextArea1.setForeground(Color.white);
        mainTextArea1.setEditable(false);
        mainTextArea1.setFont(textFont);
        mainTextArea1.setLineWrap(true);
        mainTextPanel.add(mainTextArea1);

        mainTextArea2 = new JTextArea("Select starting HP: ");
        mainTextArea2.setBounds(100, 200, 600, 250);
        mainTextArea2.setBackground(Color.BLACK);
        mainTextArea2.setForeground(Color.white);
        mainTextArea2.setEditable(false);
        mainTextArea2.setFont(textFont);
        mainTextArea2.setLineWrap(true);
        mainTextPanel.add(mainTextArea2);



    }

    public class TitleScreenHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            createGameScreen();
        }
    }


    public static void main(String[] args) {
        new Game();
    }

}
