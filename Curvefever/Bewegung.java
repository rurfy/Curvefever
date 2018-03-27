import java.util.Timer;
import java.util.TimerTask;

public class Bewegung {
	Timer bew;

	public Bewegung() {
		bew = new Timer();
		bew.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				//Der boolean Count dient nur für die Verlangsamung
//				if (Var.count) {
					if (Var.links1) {
						if (Var.hoch >= Var.hochMax && Var.links > Var.linksMax && Var.rechts == 0 && Var.runter == 0) {
							Var.hoch++;
							Var.links--;
						} else if (Var.hoch == 0 && Var.links >= Var.linksMax && Var.rechts == 0
								&& Var.runter < Var.runterMax) {
							Var.runter++;
							Var.links++;
						} else if (Var.hoch == 0 && Var.links == 0 && Var.rechts < Var.rechtsMax
								&& Var.runter <= Var.runterMax) {
							Var.runter--;
							Var.rechts++;
						} else if (Var.hoch > Var.hochMax && Var.links == 0 && Var.rechts <= Var.rechtsMax
								&& Var.runter == 0) {
							Var.hoch--;
							Var.rechts--;
						}
					}
					if (Var.rechts1) { // Vorzeichen UND =-Zeichen bei <> ausgetauscht im Vergleich zu links1
						if (Var.hoch > Var.hochMax && Var.links >= Var.linksMax && Var.rechts == 0 && Var.runter == 0) {
							Var.hoch--;
							Var.links++;
						} else if (Var.hoch == 0 && Var.links > Var.linksMax && Var.rechts == 0
								&& Var.runter <= Var.runterMax) {
							Var.runter--;
							Var.links--;
						} else if (Var.hoch == 0 && Var.links == 0 && Var.rechts <= Var.rechtsMax
								&& Var.runter < Var.runterMax) {
							Var.runter++;
							Var.rechts--;
						} else if (Var.hoch >= Var.hochMax && Var.links == 0 && Var.rechts < Var.rechtsMax
								&& Var.runter == 0) {
							Var.hoch++;
							Var.rechts++;
						}

					}
					Var.player1x += Var.links + Var.rechts;
					Var.player1y += Var.hoch + Var.runter;
//					Var.count = false;
//				} else {
//					Var.count = true;
//				}

			}

		}, 0, 30);

	}
}
