import java.awt.Point;

public class XPoint extends Point {

	public void swap(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	public boolean isOnLine(Point p1, Point p2) {
		double m1 = (p2.y - p1.y) / (p2.x - p1.x);
		double m2 = (this.y - p1.y) / (this.x - p1.x);
		if (m1 == m2) {
			return true;
		} else {
			return false;
		}
	}

	public double getR() {
		double r = Math.sqrt((double) (this.x * this.x + this.y * this.y));
		return r;
	}

	public double getPhi() {
		double d = 0;
		if (this.x != 0 || this.y != 0) {
			d = Math.atan2((double) this.y, (double) this.x);
			if (d < 0) {
				d += 2 * Math.PI;
			}
		}
		return d;
	}

	public XPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
