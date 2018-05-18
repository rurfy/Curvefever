import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	ScorePlayer player1 = new ScorePlayer("Player1");
	ScorePlayer player2 = new ScorePlayer("Player2");

	KeyHandler(ScorePlayer player1, ScorePlayer player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player1.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player1.right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			player2.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			player2.right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player1.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player1.right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			player2.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			player2.right = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
