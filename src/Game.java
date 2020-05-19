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
	JLabel titleNameLabel, hpLabel, hpLabelNumber, itemLabel, itemLabelName, itemLabelNumber;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int playerHP, monsterHP, silverRing;
	String item, position;

	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();

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

		choice1 = new JButton("Choice One");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);

		choice2 = new JButton("Choice Two");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);

		choice3 = new JButton("Choice Three");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);

		choice4 = new JButton("Choice Four");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);

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

		itemLabel = new JLabel();
		itemLabel.setFont(normalFont);
		itemLabel.setForeground(Color.white);
		playerPanel.add(itemLabel);

		itemLabelName = new JLabel("Item: ");
		itemLabelName.setFont(normalFont);
		itemLabelName.setForeground(Color.white);
		playerPanel.add(itemLabelName);

		playerSetup();

	}

	public void playerSetup() {
		playerHP = 15;
		monsterHP = 20;
		item = "Knife";
		itemLabelName.setText(item);
		hpLabelNumber.setText("" + playerHP);

		townGate();
	}

	public void townGate() {
		position = "townGate";
		mainTextArea.setText(
				"You are the Unicorn Stable. A Stable Guard is\n standing in front of you. \n What do you do?");
		choice1.setText("Talk to the Guard");
		choice2.setText("Attack the Guard");
		choice3.setText("Leave");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(false);
	}

	public void talkGuard() {
		position = "talkGuard";
		mainTextArea.setText(
				"Guard: Hello stranger. I have never seen your face\nbefore. I'm sorry, but I cannot let you into the Royal \nUnicorn Stable");
		choice1.setText(">>>");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}

	public void attackGuard() {
		position = "attackGuard";
		mainTextArea.setText("Guard: ''Hey!'' \nThe Guard fought back and hit you hard.\n(You recieve 3 damage)");
		playerHP = playerHP - 3;
		hpLabelNumber.setText("" + playerHP);
		choice1.setText(">>>");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}

	public void crossRoad() {
		position = "crossRoad";
		mainTextArea.setText("You are at a crossroad.\n If you go south, you will go back to the town.");
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
		choice1.setText("Go north");
		choice2.setText("Go east");
		choice3.setText("Go south");
		choice4.setText("Go west");
	}

	public void north() {
		position = "north";
		mainTextArea.setText("You find a magical ranbow stream.\nYou drink the water and rest at the riverbed."
				+ "\nYou wake up with a rainbow tounge.\n\n (Your HP is recovered by 2)");
		playerHP = playerHP + 2;
		hpLabelNumber.setText("" + playerHP);
		choice1.setText("Go south");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}

	public void east() {
		position = "east";
		mainTextArea.setText(
				"You walked into to a whimsical forest and found a \nLong Sword!\n\n" + "(You obtained a Long Sword)");
		item = "Long Sword";
		itemLabelName.setText("Long Sword");
		choice1.setText("Go West");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}

	public void west() {
		position = "west";
		mainTextArea.setText("You encounter a cute (but scary) bear!");
		choice1.setText("Fight");
		choice2.setText("RUN!!");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}

	public void fight() {
		position = "fight";
		mainTextArea.setText("Monster HP: " + monsterHP + "\n\nWhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}


	public void playerAttack() {
		position = "playerAttack";

		int playerDamage = 0;

		if (item.equals("Knife")) {
			playerDamage = new java.util.Random().nextInt(10);
		} else if (item.equals("Long Sword")) {
			playerDamage = new java.util.Random().nextInt(6);
		}

		mainTextArea.setText("You attack the monster for " + playerDamage + " damage");
		monsterHP = monsterHP - playerDamage;

		choice1.setText(">>>>");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}

	public void monsterAttack() {
		position = "monsterAttack";
		int monsterDamage = 0;

		monsterDamage = new java.util.Random().nextInt(4);
		mainTextArea.setText("The monster attacks you for " + monsterDamage + " damage");
		playerHP = playerHP - monsterDamage;
		hpLabelNumber.setText("" + playerHP);

		choice1.setText(">>>>");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}

	public void win() {
		position = "win";

		mainTextArea.setText("You defeated the monster!\n\nThe bear dropped a ring!\n (You recieve a Silver Ring)");
		silverRing = 1;

		choice1.setText("Go east");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}

	public void lose() {
		position = "lose";

		mainTextArea.setText("You die in battle.\n\n<GAME OVER>");

		choice1.setText("Play Again");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);

	}
	
	public void ending() {
		position = "ending";
		mainTextArea.setText("Guard: Oh, you killed the bear? Thank you!\n"
				+ "Please come pet a Unicorn.\n <THE END> ");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}

	public class TitleScreenHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			createGameScreen();

		}
	}

	public class ChoiceHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			String yourChoice = event.getActionCommand();

			switch (position) {
			case "townGate":
				switch (yourChoice) {
				case "c1":
					if(silverRing==1) {
						ending();
					}
					else {
					talkGuard();
					}
					break;
				case "c2":
					attackGuard();
					break;
				case "c3":
					crossRoad();
					break;
				}
				break;
			case "talkGuard":
				switch (yourChoice) {
				case "c1":
					townGate();
				}
				break;
			case "attackGuard":
				switch (yourChoice) {
				case "c1":
					townGate();
					break;
				}
				break;
			case "crossRoad":
				switch (yourChoice) {
				case "c1":
					north();
					break;
				case "c2":
					east();
					break;
				case "c3":
					townGate();
					break;
				case "c4":
					west();
					break;
				}
				break;
			case "north":
				switch (yourChoice) {
				case "c1":
					crossRoad();
					break;
				}
				break;
			case "east":
				switch (yourChoice) {
				case "c1":
					crossRoad();
					break;
				}
				break;
			case "west":
				switch (yourChoice) {
				case "c1":
					fight();
					break;
				case "c2":
					crossRoad();
					break;
				case "c3":
					lose();
					break;
				case "c4":
					break;
				}
				break;
			case "fight":
				switch (yourChoice) {
				case "c1":
					playerAttack();
					break;
				case "c2":
					crossRoad();
					break;
				}
				break;
			case "playerAttack":
				switch (yourChoice) {
				case "c1":
					if (monsterHP < 1) {
						win();
					} else {
						monsterAttack();
					}
					break;
				}
				break;
			case "monsterAttack":
				switch (yourChoice) {
				case "c1":
					if (playerHP < 1) {
						lose();
					} else {
						fight();
					}
					break;
				}
				break;
			case "win":
				switch (yourChoice) {
				case "c1":
					crossRoad();
					break;
				}
				break;
				case "lose":
					switch (yourChoice) {
					case "c1":
						playerSetup();
						break;
						
					}
			}
		}
	}
}
