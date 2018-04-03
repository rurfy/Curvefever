import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class Game extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage img; // Image erstellen
	private Graphics2D g2d; // Graphics2D Okjekt erstellen
	ScorePlayer position = new ScorePlayer();

	public Game() { // Constructor konfigurieren
		img = new BufferedImage(Var.width, Var.height, BufferedImage.TYPE_INT_RGB); // Image auf Framegröße mit dem RGB Typ definieren
		g2d = (Graphics2D) img.getGraphics(); // Graphics2D das Image übergeben
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

	public void drawCircle(Color color) {
		g2d.setColor(Color.RED); // Color wird nur zur Sicherheit immer auf RED gesetzt
		g2d.fillOval(Var.player1x, Var.player1y, Var.ballSize, Var.ballSize); // Pixel bei den Player1 Koordinaten rot färben
	}

	public void gameUpdate() { // updaten durch Timer
		Timer bew;
		bew = new Timer();
		bew.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {

				if (Var.links1) {
					position.rotateLeft(); // Siehe ScorePlayer.java
				}

				else if (Var.rechts1) {
					position.rotateRight(); // Siehe ScorePlayer.java
				} else {
					position.moveStrait(); // Siehe ScorePlayer.java
				}

				Var.player1x += position.x / Var.slowDown;
				Var.player1y += position.y / Var.slowDown;

				position.kollision(img); // Siehe ScorePlayer.java
				drawCircle(Color.RED); // In DrawCirlce ausgelagert in Vorarbeit für den Multiplayer
				repaint();
			}

		}, 0, 30); // Zeitabstand zwischen den Runs
	}
}
