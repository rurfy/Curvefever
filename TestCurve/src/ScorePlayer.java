import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePlayer extends JPanel { // Panel und Daten für jeden Spieler im ScoreBoard

	private static final long serialVersionUID = 1L;
	JPanel scorePlayer = new JPanel();
	String playerName;

	int linksX, linksY;
	int rechtsX, rechtsY;
	int mitteX, mitteY;
	int playerX, playerY;
	int ballSize;
	int radius, winkel;
	int spielStand;
	Color color;
	boolean left, right;
	boolean alive;

	JLabel player = new JLabel(); // Label für Spielernamen
	JLabel score = new JLabel(); // Label für Spielerpunktzahl
	int x, y;

	ScorePlayer(String playerName) { // PlayerPanel konstruieren
		player.setText("Score von " + playerName);
		this.playerName = playerName;
		setLayout(new GridBagLayout()); // LayoutManager auf GridBagLayout
		GridBagConstraints gbc = new GridBagConstraints(); // GridBagConstraints Instanz erzeugen
		gbc.gridx = 0;
		gbc.gridy = 1;
		setPreferredSize(new Dimension(Var.scoreBoardWidth, 200)); // Size stellt sich nach Anzahl der Spieler automatisch ein
		spielStand = 0;
		radius = 10;
		ballSize = 10;
		alive = true;

		player.setFont(new Font("Arial", 0, 32)); // Größere Schrift
		score.setFont(new Font("Arial", 0, 32)); // Größere Schrift
		score.setText(Integer.toString(spielStand));
		add(player, gbc); // Player aufs Panel adden
		gbc.gridy = 2; // Punktzahl unter Spieler schreiben
		add(score, gbc); // Punktzahl adden
	}

	public void rotateLeft() { // Bewegung nach Links
		x = (int) (radius * Math.sin(Math.toRadians(winkel))); // Mathematische Berechnung
		y = (int) (radius * Math.cos(Math.toRadians(winkel)));
		winkel += Var.winkelIntervall; // Winkel vergrößern
	}

	public void rotateRight() { // Bewegung nach Rechts
		x = (int) (radius * Math.sin(Math.toRadians(winkel))); // Mathematische Berechnung
		y = (int) (radius * Math.cos(Math.toRadians(winkel)));
		winkel -= Var.winkelIntervall; // Winkel verkleinern
	}

	public void moveStrait() { // Bewegung geradeaus
		x = (int) (radius * Math.sin(Math.toRadians(winkel))); // Mathematische Berechnung
		y = (int) (radius * Math.cos(Math.toRadians(winkel)));
	}

	private void koordinatenErmittlung() { // Ermittlung der Außenpunkte
		mitteX = playerX + ballSize / 2 + (int) (ballSize / 2 * Math.sin(Math.toRadians(winkel))); // Vom Mittelpunkt des Kreises mit dem Radius zum Endpunkt für den Winkel
		mitteY = playerY + ballSize / 2 + (int) (ballSize / 2 * Math.cos(Math.toRadians(winkel)));
		linksX = playerX + ballSize / 2 + (int) (ballSize / 2 * Math.sin(Math.toRadians(winkel + 90)));
		linksY = playerY + ballSize / 2 + (int) (ballSize / 2 * Math.cos(Math.toRadians(winkel + 90)));
		rechtsX = playerX + ballSize / 2 + (int) (ballSize / 2 * Math.sin(Math.toRadians(winkel - 90)));
		rechtsY = playerY + ballSize / 2 + (int) (ballSize / 2 * Math.cos(Math.toRadians(winkel - 90)));
	}

	public void kollision(BufferedImage img) { // Kollision prüfen (Img übergeben)

		koordinatenErmittlung(); // Private Method aufrufen
		// für den Fall, dass der Spieler den Bildschirm verlässt, damit es keine
		// Unknown Source für die Bildfarbe gibt
		if (mitteX < 0 || mitteY < 0 || linksX < 0 || linksY < 0 || rechtsX < 0 || rechtsY < 0 || mitteX > Var.width || linksX > Var.width || rechtsX > Var.width || mitteY > Var.height
				|| linksY > Var.height || rechtsY > Var.height) {
			spielStand += Var.count;
			Var.count++;
			score.setText(Integer.toString(spielStand));
			alive = false;
		} else {

			int farbeLinks = img.getRGB(linksX, linksY); // Farbe am linken Punkt ermitteln
			int farbeMitte = img.getRGB(mitteX, mitteY); // Farbe am mittleren Punkt ermitteln
			int farbeRechts = img.getRGB(rechtsX, rechtsY); // Farbe am rechten Punkt ermitteln
			if (farbeLinks != Var.hintergrund.getRGB() || farbeMitte != Var.hintergrund.getRGB() || farbeRechts != Var.hintergrund.getRGB()) { // 3 Farben vergleichen
				spielStand += Var.count;
				Var.count++;
				score.setText(Integer.toString(spielStand));
				alive = false;
			}
		}
	}

}
