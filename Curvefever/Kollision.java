import java.util.Timer;
import java.util.TimerTask;

public class Kollision {
	Timer kol;
	Node x, temp;

	public Kollision() {
		temp = new Node();
		x = new Node();
		x=temp;
		kol = new Timer();
		kol.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				
				Var.pun1=""+Var.player1x+" "+(Var.player1y+5);
				
				Var.pun2=""+(Var.player1x+10)+" "+(Var.player1y+5);
				
				Var.pun3=""+(Var.player1x+5)+" "+Var.player1y;
				
				Var.pun4=""+(Var.player1x+5)+" "+(Var.player1y+10);
				
				
				temp.punkt1 = ""+Var.player1x+" "+(Var.player1y+5);

				temp.punkt2 = ""+(Var.player1x + 10)+" "+(Var.player1y+5);

				temp.punkt3 = ""+(Var.player1x+5)+" "+Var.player1y;
				
				temp = temp.next;

				temp=x;
				
				while(temp.next!=null) {
					if(temp.punkt1==Var.pun1 || temp.punkt1==Var.pun2 || temp.punkt1==Var.pun3 || temp.punkt1==Var.pun4) {
						System.out.println("Kollision");
						break;
					}else if(temp.punkt2==Var.pun1 || temp.punkt2==Var.pun2 || temp.punkt2==Var.pun3 || temp.punkt2==Var.pun4) {
						System.out.println("Kollision");
						break;
					}else if(temp.punkt3==Var.pun1 || temp.punkt3==Var.pun2 || temp.punkt3==Var.pun3 || temp.punkt3==Var.pun4) {
						System.out.println("Kollision");
						break;
					}else {
						temp= temp.next;
					}
				}
			}

		}, 0, 30);
	}
}
