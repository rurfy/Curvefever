import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

public class Layout extends JLabel {
	private static final long serialVersionUID = 1L;
	static Layout lay1;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Node punkt = new Node(); 	//neuer Punkt
		punkt.x = Var.player1x;		//Werte von Player1 zuordnen
		punkt.y = Var.player1y;
		punkt.durchmesser = Var.ballSize;
		Var.line.add(punkt);		//zur Liste hinzufügen
		for (int i = 0; i < Var.line.size(); i++) { 	//für alle Puntke in der Liste
			g.setColor(Color.RED);
			g.fillOval(Var.line.get(i).x, Var.line.get(i).y, Var.line.get(i).durchmesser, Var.line.get(i).durchmesser); //Kugel zeichnen
		}
		repaint();
	}

}