import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel {
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
    JPanel nextButtonPanel;
    JPanel heroTextPanel1;
    JPanel heroTextPanel2;
    JPanel heroTextPanel3;
    JLabel heroTextLabel;
    JTextArea heroTextArea1;
    JTextArea heroTextArea2;
    JTextField playerName;
    JButton nextButton;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font textFont = new Font("Times New Roman", Font.PLAIN, 30);
    Image backgroundImg = Toolkit.getDefaultToolkit().getImage("/img/titleImage.jpg");

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImg, 0, 0, null);
    }


    public Game() {
        window = new JFrame();
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

    public void createHeroScreen() {
        titleNamePanel1.setVisible(false);
        titleNamePanel2.setVisible(false);
        titleNamePanel3.setVisible(false);
        startButtonPanel.setVisible(false);



        heroTextPanel1 = new JPanel();
        heroTextPanel1.setBounds(100, 50, 600, 100);
        heroTextPanel1.setBackground(Color.black);

        heroTextPanel2 = new JPanel();
        heroTextPanel2.setBounds(100, 250, 600, 50);
        heroTextPanel2.setBackground(Color.black);

        heroTextPanel3 = new JPanel();
        heroTextPanel3.setBounds(100, 320, 600, 50);
        heroTextPanel3.setBackground(Color.black);

        nextButtonPanel = new JPanel();
        nextButtonPanel.setBounds(300, 450, 200, 100);
        nextButtonPanel.setBackground(Color.black);



        heroTextLabel = new JLabel("Your Hero");
        heroTextLabel.setBackground(Color.black);
        heroTextLabel.setForeground(Color.white);
        heroTextLabel.setFont(titleFont);
        heroTextPanel1.add(heroTextLabel);

        heroTextArea1 = new JTextArea("Enter Hero Name: ");
        heroTextArea1.setBounds(100, 450, 400, 250);
        heroTextArea1.setBackground(Color.black);
        heroTextArea1.setForeground(Color.white);
        heroTextArea1.setEditable(false);
        heroTextArea1.setFont(textFont);
        heroTextArea1.setLineWrap(true);
        heroTextPanel2.add(heroTextArea1);

        heroTextArea2 = new JTextArea("Select starting HP: ");
        heroTextArea2.setBounds(100, 650, 400, 250);
        heroTextArea2.setBackground(Color.black);
        heroTextArea2.setForeground(Color.white);
        heroTextArea2.setEditable(false);
        heroTextArea2.setFont(textFont);
        heroTextArea2.setLineWrap(true);
        heroTextPanel3.add(heroTextArea2);

        nextButton = new JButton("Continue");
        nextButton.setBackground(Color.black);
        nextButton.setForeground(Color.white);
        nextButton.setOpaque(true);
        nextButton.setBorderPainted(false);
        nextButton.setFont(buttonFont);
        nextButtonPanel.add(nextButton);
        nextButton.addActionListener(tsHandler);

        con.add(heroTextPanel1);
        con.add(heroTextPanel2);
        con.add(heroTextPanel3);
        con.add(nextButtonPanel);
        window.setVisible(true);
    }

    public class TitleScreenHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            createHeroScreen();
        }
    }


    public static void main(String[] args) {
        new Game();
    }

}
