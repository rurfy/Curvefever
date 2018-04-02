import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePlayer extends JPanel { // Panel für jeden Spieler im ScoreBoard

	private static final long serialVersionUID = 1L;
	JPanel scorePlayer = new JPanel();

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
}
