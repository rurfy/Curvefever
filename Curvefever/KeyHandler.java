import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			Var.links1=true;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			Var.rechts1=true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			Var.links1=false;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			Var.rechts1=false;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
