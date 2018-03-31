import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Toolkit;
import javax.swing.JFrame;

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

		feld.setLocationRelativeTo(null); // Den Rest fürs Frame definieren
		feld.setTitle("Curvefever");
		feld.addKeyListener(new KeyHandler());
		feld.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Pos position = new Pos(); // Okjektinstanz position erstellen und mit Startpunkt initialisieren
		position.linksX = Var.player1x + 5;
		position.linksY = Var.player1y + 10;
		position.mitteX = Var.player1x;
		position.mitteY = Var.player1y + 5;
		position.rechtsX = Var.player1x + 5;
		position.rechtsY = Var.player1y;

		Game game = new Game(position); // Gameinstanz erstellen
		feld.add(game); // Gameinstanz auf dem Frame hinzufügen
		game.playGame(); // Game starten
		feld.setVisible(true);

	}

}
