import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ScorePlayer extends JPanel { // Panel und Daten für jeden Spieler im ScoreBoard

	// Pos und ScorePlayer in ScorePlayer zusammengefasst
	// Später brauchen wir nur für jeden Spieler ein ScorePlayer-Objekt erstellen

	private static final long serialVersionUID = 1L;
	JPanel scorePlayer = new JPanel();
	int linksX, linksY;
	int rechtsX, rechtsY;
	int mitteX, mitteY;

	int x, y;

	ScorePlayer() { // PlayerPanel konstruieren
		setLayout(new GridBagLayout()); // LayoutManager auf GridBagLayout
		GridBagConstraints gbc = new GridBagConstraints(); // GridBagConstraints Instanz erzeugen
		gbc.gridx = 0;
		gbc.gridy = 1;
		setPreferredSize(new Dimension(Var.scoreBoardWidth, 200)); // Size stellt sich nach Anzahl der Spieler automatisch ein

		JLabel player = new JLabel("Score von Player1"); // Label für Spielernamen
		player.setFont(new Font("Arial", 0, 32)); // Größere Schrift

		JLabel score = new JLabel("0"); // Label für Spielerpunktzahl
		score.setFont(new Font("Arial", 0, 32)); // Größere Schrift

		add(player, gbc); // Player aufs Panel adden

		gbc.gridy = 2; // Punktzahl unter Spieler schreiben
		add(score, gbc); // Punktzahl adden
	}

	public void rotateLeft() { // Bewegung nach Links
		x = (int) (Var.radius * Math.sin(Math.toRadians(Var.winkel))); // Mathematische Berechnung
		y = (int) (Var.radius * Math.cos(Math.toRadians(Var.winkel)));
		Var.winkel += Var.winkelIntervall; // Winkel vergrößern
	}

	public void rotateRight() { // Bewegung nach Rechts
		x = (int) (Var.radius * Math.sin(Math.toRadians(Var.winkel))); // Mathematische Berechnung
		y = (int) (Var.radius * Math.cos(Math.toRadians(Var.winkel)));
		Var.winkel -= Var.winkelIntervall; // Winkel verkleinern
	}

	public void moveStrait() { // Bewegung geradeaus
		x = (int) (Var.radius * Math.sin(Math.toRadians(Var.winkel))); // Mathematische Berechnung
		y = (int) (Var.radius * Math.cos(Math.toRadians(Var.winkel)));
	}

	private void koordinatenErmittlung() { // Ermittlung der Außenpunkte
		mitteX = Var.player1x + Var.ballSize / 2 + (int) (Var.ballSize / 2 * Math.sin(Math.toRadians(Var.winkel))); // Vom Mittelpunkt des Kreises mit dem Radius zum Endpunkt für den Winkel
		mitteY = Var.player1y + Var.ballSize / 2 + (int) (Var.ballSize / 2 * Math.cos(Math.toRadians(Var.winkel)));
		linksX = Var.player1x + Var.ballSize / 2 + (int) (Var.ballSize / 2 * Math.sin(Math.toRadians(Var.winkel + 90)));
		linksY = Var.player1y + Var.ballSize / 2 + (int) (Var.ballSize / 2 * Math.cos(Math.toRadians(Var.winkel + 90)));
		rechtsX = Var.player1x + Var.ballSize / 2 + (int) (Var.ballSize / 2 * Math.sin(Math.toRadians(Var.winkel - 90)));
		rechtsY = Var.player1y + Var.ballSize / 2 + (int) (Var.ballSize / 2 * Math.cos(Math.toRadians(Var.winkel - 90)));
	}

	public void kollision(BufferedImage img) { // Kollision prüfen (Img übergeben)

		koordinatenErmittlung(); // Private Method aufrufen
		// für den Fall, dass der Spieler den Bildschirm verlässt, damit es keine
		// Unknown Source für die Bildfarbe gibt
		if (mitteX < 0 || mitteY < 0 || linksX < 0 || linksY < 0 || rechtsX < 0 || rechtsY < 0 || mitteX > Var.width || linksX > Var.width || rechtsX > Var.width || mitteY > Var.height
				|| linksY > Var.height || rechtsY > Var.height) {
			JOptionPane.showMessageDialog(null, "Spiel verlassen", "Game Over", JOptionPane.OK_CANCEL_OPTION); // Symbolische Spielabbruch
			System.exit(0);
		} else {

			int farbeLinks = img.getRGB(linksX, linksY); // Farbe am linken Punkt ermitteln
			int farbeMitte = img.getRGB(mitteX, mitteY); // Farbe am mittleren Punkt ermitteln
			int farbeRechts = img.getRGB(rechtsX, rechtsY); // Farbe am rechten Punkt ermitteln
			if (farbeLinks != Var.hintergrund.getRGB() || farbeMitte != Var.hintergrund.getRGB() || farbeRechts != Var.hintergrund.getRGB()) { // 3 Farben vergleichen
				JOptionPane.showMessageDialog(null, "Spiel verlassen", "Game Over", JOptionPane.OK_CANCEL_OPTION); // Symbolischer Spielabbruch
				System.exit(0);
			}
		}
	}
}
