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

		GraphicsConfiguration config = feld.getGraphicsConfiguration(); // Framegröße einstellen
		final int left = Toolkit.getDefaultToolkit().getScreenInsets(config).left;
		final int right = Toolkit.getDefaultToolkit().getScreenInsets(config).right;
		final int top = Toolkit.getDefaultToolkit().getScreenInsets(config).top;
		final int bottom = Toolkit.getDefaultToolkit().getScreenInsets(config).bottom;
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		Var.width = screensize.width - left - right;
		Var.height = screensize.height - top - bottom;
		feld.setSize(Var.width, Var.height);

		feld.setTitle("Curvefever"); // restliche Definitionen für das Frame
		feld.addKeyListener(new KeyHandler());
		feld.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		feld.setLocationRelativeTo(null);

		feld.setLayout(new GridBagLayout()); // LayoutManager auf GridBagLayout
		GridBagConstraints gbc = new GridBagConstraints(); // GridBagConstraints Instanz erzeugen

		JPanel scoreBoard = new JPanel(); // ScoreBoard erstellen
		scoreBoard.setLayout(new BoxLayout(scoreBoard, BoxLayout.Y_AXIS)); // LayoutManager auf BoxLayout
		scoreBoard.setBackground(Color.BLUE); // TestBackground für den Kontrast
		scoreBoard.setPreferredSize(new Dimension(Var.scoreBoardWidth, Var.height)); // scoreBoardWidth einfach willkürlich gewählt

		ScorePlayer player1 = new ScorePlayer(); // Testweise 2 Spieler adden
		ScorePlayer player2 = new ScorePlayer();
		player2.setBackground(Color.GREEN); // TestBackground für den Kontrast
		scoreBoard.add(player1); // Spieler aufs ScoreBoard adden
		scoreBoard.add(player2);

		gbc.gridx = 0; // 1. Position horizontal
		gbc.gridy = 0; // beide auf gleicher vertikaler Höhe
		gbc.gridwidth = gbc.gridheight = 1;
		feld.add(scoreBoard, gbc); // ScoreBoard dem Frame hinzufügen

		// Erster Versuch einen Chat einzubauen... bis zum Ende nicht weitermachen!!!

		// JPanel chat = new JPanel();
		// gbc.gridy = 1;
		// chat.setBackground(Color.YELLOW); //TestBackground für den Kontrast
		// chat.setPreferredSize(new Dimension(Var.scoreBoardWidth, 300)); //Height
		// wieder auf screenHeight addieren
		// feld.add(chat, gbc);

		Pos position = new Pos(); // Okjektinstanz position erstellen und mit Startpunkt initialisieren
		position.linksX = Var.player1x + 5;
		position.linksY = Var.player1y + 10;
		position.mitteX = Var.player1x;
		position.mitteY = Var.player1y + 5;
		position.rechtsX = Var.player1x + 5;
		position.rechtsY = Var.player1y;

		Game game = new Game(position); // Gameinstanz erstellen
		gbc.gridy = 0;
		gbc.gridx = 1; // x ist höher damit es rechts von dem ScoreBoard ist
		game.setPreferredSize(new Dimension(Var.width - Var.scoreBoardWidth, Var.height)); // Size ist FrameSize ScoreBoardSize
		feld.add(game, gbc); // Gameinstanz auf dem Frame hinzufügen
		game.playGame(); // Game starten

		feld.pack(); // Die Panels auf dem Frame richtig arrangen
		feld.setVisible(true); // AM ENDE visible machen

	}

}
