
public class Var {
	static int player1x = 500, player1y = 500;
	static int maxWert = 10; // maxWert hinzugef�gt, damit man nicht jedes mal 4 Werte �ndern muss
	static int width, height;
	static boolean links1 = false, rechts1 = false;
	static int hoch = 0, runter = 0, links = -maxWert, rechts = 0;
	static int hochMax = -maxWert, runterMax = maxWert, linksMax = -maxWert, rechtsMax = maxWert;
	static boolean count = true;
	static String pun1, pun2, pun3, pun4;
}

class Node{
	static Node next;
	static String punkt1, punkt2, punkt3;
}