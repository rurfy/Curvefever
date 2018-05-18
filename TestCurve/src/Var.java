import java.awt.Color;

public class Var {
	static int playerCount = 2;
	static int maxCount = playerCount * 5;
	static int count = 0;
	static int width, height, scoreBoardWidth = 300; // BLEIBT
	static Color hintergrund = Color.LIGHT_GRAY; // eine Variable für den Hintergrund erstellt damit man sie nur an einer Stelle
													// ändern muss BLEIBT
	static double winkelIntervall = 7; // winkel 0 ist Unten, 90° ist rechts, usw.; StartWinkel definiert Intervall
										// zwischen den Winkeln
	static int slowDown = 2; // verlangsamt die Bewegung
}