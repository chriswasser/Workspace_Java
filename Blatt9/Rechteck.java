
import java.awt.Point;

public class Rechteck extends Figur {

	public Rechteck(Point p1, Point p2) {
		Point p3 = new Point(p1.x, p2.y);
		Point p4 = new Point(p2.x, p1.y);
		punkte.add(p1);
		punkte.add(p3);
		punkte.add(p2);
		punkte.add(p4);
		punkte.add(p1);
	}

	public Rechteck(Rechteck r) {
		this.punkte.clear();
		for (Point p : r.punkte) {
			this.punkte.add(new Point(p));
		}
	}

	public void skaliere(double d) {
		double middleX = this.punkte.get(1).x + (this.punkte.get(3).x - this.punkte.get(1).x) * 0.5;
		double middleY = this.punkte.get(1).y + (this.punkte.get(3).y - this.punkte.get(1).y) * 0.5;
		Point newPoint1 = new Point((int)((middleX-this.punkte.get(1).x)*d+middleX),(int)((middleY-this.punkte.get(1).y)*d+middleY));
		Point newPoint3 = new Point((int)((middleX-this.punkte.get(3).x)*d+middleX),(int)((middleY-this.punkte.get(3).y)*d+middleY));
		this.punkte = (new Rechteck(newPoint1, newPoint3)).punkte;
	}

	public Rechteck vereinige(Rechteck r) {
		int minx = Integer.MAX_VALUE;
		int maxx = Integer.MIN_VALUE;
		int miny = Integer.MAX_VALUE;
		int maxy = Integer.MIN_VALUE;
		for(Point p: r.punkte) {
			if ( p.x < minx) {
				minx = p.x;
			}
			if(p.x > maxx) {
				maxx = p.x;
			}
			if ( p.y < miny) {
				miny = p.y;
			}
			if(p.y > maxy) {
				maxy = p.y;
			}
			
		}
		for(Point p: this.punkte) {
			if ( p.x < minx) {
				minx = p.x;
			}
			if(p.x > maxx) {
				maxx = p.x;
			}
			if ( p.y < miny) {
				miny = p.y;
			}
			if(p.y > maxy) {
				maxy = p.y;
			}			
		}
		Rechteck result = new Rechteck(new Point(minx,miny), new Point(maxx,maxy));
		return result;
	}

	public String toString() {
		return "Rechteck: Hoehe = " + Math.abs(this.punkte.get(1).y - this.punkte.get(3).y) + " Breite = "
				+ Math.abs(this.punkte.get(1).x - this.punkte.get(3).x);
	}

}
