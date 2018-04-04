import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame feld = new JFrame(); // Frame erstellen

		GraphicsConfiguration config = feld.getGraphicsConfiguration(); // Framegr��e einstellen
		final int left = Toolkit.getDefaultToolkit().getScreenInsets(config).left;
		final int right = Toolkit.getDefaultToolkit().getScreenInsets(config).right;
		final int top = Toolkit.getDefaultToolkit().getScreenInsets(config).top;
		final int bottom = Toolkit.getDefaultToolkit().getScreenInsets(config).bottom;
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		Var.width = screensize.width - left - right;
		Var.height = screensize.height - top - bottom;
		feld.setSize(Var.width, Var.height);

		feld.setTitle("Curvefever"); // restliche Definitionen f�r das Frame
		feld.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		feld.setLocationRelativeTo(null);

		feld.setLayout(new GridBagLayout()); // LayoutManager auf GridBagLayout
		GridBagConstraints gbc = new GridBagConstraints(); // GridBagConstraints Instanz erzeugen

		JPanel scoreBoard = new JPanel(); // ScoreBoard erstellen
		scoreBoard.setLayout(new BoxLayout(scoreBoard, BoxLayout.Y_AXIS)); // LayoutManager auf BoxLayout
		scoreBoard.setBackground(Color.BLUE); // TestBackground f�r den Kontrast
		scoreBoard.setPreferredSize(new Dimension(Var.scoreBoardWidth, Var.height)); // scoreBoardWidth einfach willk�rlich gew�hlt

		ScorePlayer player1 = new ScorePlayer("Player1"); // Testweise 2 Spieler adden
		ScorePlayer player2 = new ScorePlayer("Player2");

		player1.color = Color.RED;
		player2.color = Color.BLUE;
		player1.playerX = 500;
		player1.playerY = 500;
		player2.playerX = 1000;
		player2.playerY = 1000;
		player1.winkel = 45;
		player2.winkel = -135;

		player2.setBackground(Color.GREEN); // TestBackground f�r den Kontrast
		scoreBoard.add(player1); // Spieler aufs ScoreBoard adden
		scoreBoard.add(player2);

		gbc.gridx = 0; // 1. Position horizontal
		gbc.gridy = 0; // beide auf gleicher vertikaler H�he
		// gbc.gridwidth = gbc.gridheight = 1;
		feld.add(scoreBoard, gbc); // ScoreBoard dem Frame hinzuf�gen

		// Erster Versuch einen Chat einzubauen... bis zum Ende nicht weitermachen!!!

		// JPanel chat = new JPanel();
		// gbc.gridy = 1;
		// chat.setBackground(Color.YELLOW); //TestBackground f�r den Kontrast
		// chat.setPreferredSize(new Dimension(Var.scoreBoardWidth, 300)); //Height
		// wieder auf screenHeight addieren
		// feld.add(chat, gbc);

		Game game = new Game(player1, player2); // Gameinstanz erstellen
		feld.addKeyListener(new KeyHandler(player1, player2));
		gbc.gridy = 0;
		gbc.gridx = 1; // x ist h�her damit es rechts von dem ScoreBoard ist
		game.setPreferredSize(new Dimension(Var.width - Var.scoreBoardWidth, Var.height)); // Size ist FrameSize ScoreBoardSize
		feld.add(game, gbc); // Gameinstanz auf dem Frame hinzuf�gen
		game.playGame(); // Game starten

		feld.pack(); // Die Panels auf dem Frame richtig arrangen
		feld.setVisible(true); // AM ENDE visible machen

	}

}
