import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Gui {
	
	public Gui() {
		JFrame feld = new JFrame();
		GraphicsConfiguration config = feld.getGraphicsConfiguration();
		
		final int left = Toolkit.getDefaultToolkit().getScreenInsets(config).left;
        final int right = Toolkit.getDefaultToolkit().getScreenInsets(config).right;
        final int top = Toolkit.getDefaultToolkit().getScreenInsets(config).top;
        final int bottom = Toolkit.getDefaultToolkit().getScreenInsets(config).bottom;


		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screensize.width-left-right;
		int height = screensize.height-top-bottom;
		feld.setSize(width, height);
		
		feld.setLocationRelativeTo(null);
		feld.setLayout(null);
		feld.setTitle("Curvefever");
		feld.requestFocus();
		feld.addKeyListener(new KeyHandler());
		feld.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Layout.lay1 = new Layout();
		Layout.lay1.setBounds(0, 0, width, height);
		Layout.lay1.setVisible(true);
		
		feld.add(Layout.lay1);
		feld.setVisible(true);
	}
}
