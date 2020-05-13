import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class Game {

	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, playerPanel, choiceButtonPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, weaponLabelNumber;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	JButton startButton, choiceOne, choiceTwo, choiceThree, choiceFour;
	JTextArea mainTextArea;
	int playerHP;
	String weapon;

	TitleScreenHandler tsHandler = new TitleScreenHandler();

	public static void main(String[] args) {
		new Game();
	}


	public Game() {
		window = new JFrame();
	
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		con = window.getContentPane();

		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("UNICORN ADVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);

		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);

		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);

		con.add(titleNamePanel);
		con.add(startButtonPanel);

		window.setVisible(true);

	}

	public void createGameScreen() {

		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);

		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);

		mainTextArea = new JTextArea("This is the main text area");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4, 1));
		con.add(choiceButtonPanel);

		choiceOne = new JButton("Choice One");
		choiceOne.setBackground(Color.black);
		choiceOne.setForeground(Color.white);
		choiceOne.setFont(normalFont);
		choiceOne.setFocusPainted(false);
		choiceButtonPanel.add(choiceOne);

		choiceTwo = new JButton("Choice Two");
		choiceTwo.setBackground(Color.black);
		choiceTwo.setForeground(Color.white);
		choiceTwo.setFont(normalFont);
		choiceTwo.setFocusPainted(false);
		choiceButtonPanel.add(choiceTwo);

		choiceThree = new JButton("Choice Three");
		choiceThree.setBackground(Color.black);
		choiceThree.setForeground(Color.white);
		choiceThree.setFont(normalFont);
		choiceThree.setFocusPainted(false);
		choiceButtonPanel.add(choiceThree);

		choiceFour = new JButton("Choice Four");
		choiceFour.setBackground(Color.black);
		choiceFour.setForeground(Color.white);
		choiceFour.setFont(normalFont);
		choiceFour.setFocusPainted(false);
		choiceButtonPanel.add(choiceFour);

		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1, 4));
		con.add(playerPanel);

		hpLabel = new JLabel();
		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);

		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);

		weaponLabel = new JLabel();
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);

		weaponLabelName = new JLabel("Weapon: ");
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);

		playerSetup();

	}

	public void playerSetup() {
		playerHP = 15;
		weapon = "Hairbrush";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + playerHP);

	}

	public class TitleScreenHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			createGameScreen();

		}
	}
}
