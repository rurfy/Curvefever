import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage img; // Image erstellen
	private Graphics2D g2d; // Graphics2D Okjekt erstellen
	boolean gameEnde = false;
	ScorePlayer player1 = new ScorePlayer("Player1");
	ScorePlayer player2 = new ScorePlayer("Player2");

	public Game(ScorePlayer player1, ScorePlayer player2) { // Constructor konfigurieren
		img = new BufferedImage(Var.width, Var.height, BufferedImage.TYPE_INT_RGB); // Image auf Framegröße mit dem RGB Typ definieren
		g2d = (Graphics2D) img.getGraphics(); // Graphics2D das Image übergeben
		this.player1 = player1;
		this.player2 = player2;
	}

	public void initDraw() { // beim Initialisieren Hintergrund festlegen
		g2d.setColor(Var.hintergrund);
		g2d.fillRect(0, 0, Var.width - Var.scoreBoardWidth, Var.height);
	}

	public void playGame() { // Das gesamte Game
		initDraw(); // Feld initialisieren
		gameUpdate(); // Timer ablaufen lassen

	}

	public void paintComponent(Graphics g) { // Bild zeichnen lassen
		g.drawImage(img, 0, 0, null);
	}

	public void drawCircle(Color color, ScorePlayer player) {
		g2d.setColor(color); // Color wird nur zur Sicherheit immer auf RED gesetzt
		g2d.fillOval(player.playerX, player.playerY, player.ballSize, player.ballSize); // Pixel bei den Player1 Koordinaten rot färben
	}

	public void gameUpdate() { // updaten durch Timer
		Timer bew;
		bew = new Timer();
		bew.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {

				move(player1);
				move(player2);
				repaint();
				if (!player1.alive && !player2.alive) {
					resetBoard();
				}
				win(player1);
				win(player2);
			}

		}, 0, 30); // Zeitabstand zwischen den Runs
	}

	public void move(ScorePlayer player) {
		if (player.alive) {
			if (player.left) {
				player.rotateLeft(); // Siehe ScorePlayer.java
			}

			else if (player.right) {
				player.rotateRight(); // Siehe ScorePlayer.java
			} else {
				player.moveStrait(); // Siehe ScorePlayer.java
			}

			player.playerX += player.x / Var.slowDown;
			player.playerY += player.y / Var.slowDown;

			player.kollision(img); // Siehe ScorePlayer.java
			drawCircle(player.color, player); // In DrawCirlce ausgelagert in Vorarbeit für den Multiplayer
		}
	}

	public void resetBoard() {
		player1.playerX = 500;
		player1.playerY = 500;
		player2.playerX = 1000;
		player2.playerY = 1000;
		player1.winkel = 45;
		player2.winkel = -135;
		player1.alive = true;
		player2.alive = true;
		Var.count = 0;
		initDraw();
	}

	public void win(ScorePlayer player) {
		if (gameEnde) {
			player.spielStand = 0;
			resetBoard();
			gameEnde = false;
		} else {
			if (player.spielStand >= Var.maxCount) {
				if (JOptionPane.showConfirmDialog(this, player.playerName + " hat mit " + player.spielStand + " Punkten gewonnen!", "Revance?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					player.spielStand = 0;
					gameEnde = true;
					resetBoard();

				} else {
					System.exit(0);
				}
			}
		}

	}
}
