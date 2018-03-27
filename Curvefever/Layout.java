import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class Layout extends JLabel{
	private static final long serialVersionUID = 1L;
	static Layout lay1;

	static int player1x = 100, player1y = 100;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.setColor(Color.RED);
		g.fillOval(player1x, player1y, 10, 10);
		
		repaint();
	}
	
}
