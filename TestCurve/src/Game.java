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
	Pos position;

	public Game(Pos position) { // Constructor konfigurieren
		img = new BufferedImage(Var.width, Var.height, BufferedImage.TYPE_INT_RGB); // Image auf Framegr��e mit dem RGB Typ definieren
		g2d = (Graphics2D) img.getGraphics(); // Graphics2D das Image �bergeben
		this.position = position; // position Objekt and die Game Klasse �bergeben
	}

	public void initDraw() { // beim Initialisieren Hintergrund festlegen
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, Var.width, Var.height);
	}

	public void playGame() { // Das gesamte Game
		initDraw(); // Feld initialisieren
		gameUpdate(); // Timer ablaufen lassen

	}

	public void paintComponent(Graphics g) { // Bild zeichnen lassen
		g.drawImage(img, 0, 0, null);
	}

	public void kollision() { // Kollision pr�fen

		int farbeLinks = img.getRGB(position.linksX, position.linksY); // Farbe am linken Punkt ermitteln
		int farbeMitte = img.getRGB(position.mitteX, position.mitteY); // Farbe am mittleren Punkt ermitteln
		int farbeRechts = img.getRGB(position.rechtsX, position.rechtsY); // Farbe am rechten Punkt ermitteln
		if (farbeLinks != new Color(255, 255, 255).getRGB() || farbeMitte != new Color(255, 255, 255).getRGB()
				|| farbeRechts != new Color(255, 255, 255).getRGB()) { // �berpr�fen ob einer der Punkte NICHT WHITE ist
			System.out.println("Kollision!"); // Testausgabe
		}
	}

	public void gameUpdate() { // updaten durch Timer
		Timer bew;
		bew = new Timer();
		bew.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// Der boolean Count dient nur f�r die Verlangsamung
				// if (Var.count) {
				if (Var.links1) { // f�r Linke Taste gedr�ckt
					if (Var.hoch >= -Var.maxWert && Var.links > -Var.maxWert && Var.rechts == 0 && Var.runter == 0) { // Links Oben
						Var.hoch++;
						Var.links--;
					} else if (Var.hoch == 0 && Var.links >= -Var.maxWert && Var.rechts == 0 && Var.runter < Var.maxWert) { // Links Unten
						Var.runter++;
						Var.links++;
					} else if (Var.hoch == 0 && Var.links == 0 && Var.rechts < Var.maxWert && Var.runter <= Var.maxWert) { // Rechts Unten
						Var.runter--;
						Var.rechts++;
					} else if (Var.hoch > -Var.maxWert && Var.links == 0 && Var.rechts <= Var.maxWert && Var.runter == 0) { // Rechts Oben
						Var.hoch--;
						Var.rechts--;
					}
				}
				if (Var.rechts1) { // f�r Rechte Taste gedr�ckt
					if (Var.hoch > -Var.maxWert && Var.links >= -Var.maxWert && Var.rechts == 0 && Var.runter == 0) { // Links Oben
						Var.hoch--;
						Var.links++;
					} else if (Var.hoch == 0 && Var.links > -Var.maxWert && Var.rechts == 0 && Var.runter <= Var.maxWert) { // Links Unten
						Var.runter--;
						Var.links--;
					} else if (Var.hoch == 0 && Var.links == 0 && Var.rechts <= Var.maxWert && Var.runter < Var.maxWert) { // Rechts Unten
						Var.runter++;
						Var.rechts--;
					} else if (Var.hoch >= -Var.maxWert && Var.links == 0 && Var.rechts < Var.maxWert && Var.runter == 0) { // Rechts Oben
						Var.hoch++;
						Var.rechts++;
					}

				}
				Var.player1x += (Var.links + Var.rechts)/* / 4 */; // zum Verlangsamen
				Var.player1y += (Var.hoch + Var.runter)/* / 4 */;

				kollision();
				g2d.setColor(Color.RED); // Color wird nur zur Sicherheit immer auf RED gesetzt
				g2d.fillOval(Var.player1x, Var.player1y, Var.ballSize, Var.ballSize); // Pixel bei den Player1 Koordinaten rot f�rben
				repaint();
				// Var.count = false;
				// } else {
				// Var.count = true;
				// }
				// Line.draw();

			}

		}, 0, 30);
	}
}
