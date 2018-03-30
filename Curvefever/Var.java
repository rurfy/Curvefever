import java.util.ArrayList;


public class Var {
	static int player1x = 500, player1y = 500;
	static int maxWert = 10; // maxWert hinzugefügt, damit man nicht jedes mal 4 Werte ändern muss
	static int width, height;
	static int ballSize = 20; //Breite und Höhe zu ballSize zusammengefügt, weil eh beides gleich ist
	static boolean links1 = false, rechts1 = false;
	static int hoch = 0, runter = 0, links = -maxWert, rechts = 0;
	static int hochMax = -maxWert, runterMax = maxWert, linksMax = -maxWert, rechtsMax = maxWert;
	static boolean count = true;
	static ArrayList<Node> line = new ArrayList<Node>(); //in der ArrayList stehen alle Koordinaten der Punkte die Player1 durchfahren hat
}

class Node {
	int x, y, durchmesser; //x = player1x; y = player1y; durchmesser = ballSize
	static String pun1, pun2, pun3, pun4;
}