import java.awt.Color;

public class Var {
	static int player1x = 500, player1y = 500;
	static int maxWert = 10; // maxWert hinzugef�gt, damit man nicht jedes mal 4 Werte �ndern muss
	static int width, height, scoreBoardWidth = 300;
	static int ballSize = 10; // Breite und H�he zu ballSize zusammengef�gt, weil eh beides gleich ist
	static boolean links1 = false, rechts1 = false;
	static int hoch = 0, runter = 0, links = -maxWert, rechts = 0;
	static Color hintergrund = Color.LIGHT_GRAY; // eine Variable f�r den Hintergrund erstellt damit man sie nur an einer Stelle
													// �ndern muss
	static double winkel = 0, winkelIntervall = 7; // winkel 0 ist Unten, 90� ist rechts, usw.; StartWinkel definiert Intervall
													// zwischen den Winkeln
	static int radius = 10; //Radius des Kreises um den sich die Linie dreht
	static int slowDown = 2; //verlangsamt die Bewegung
}