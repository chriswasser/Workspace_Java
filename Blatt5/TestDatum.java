
public class TestDatum {

	public static void main(String[] args) {
		Datum dat = new Datum(10,11,2016);
		System.out.println(dat.toString());
		System.out.println(Datum.getMonatslaenge(2, 2016));
		System.out.println(Datum.isSchaltjahr(2015));
		Datum dat2 = new Datum(10,11,1932);
		System.out.println(dat2.equals(dat));
		System.out.println(dat2.isGleicherTag(dat));
		Datum dat3 = new Datum(144,1824);
		System.out.println(dat3.toString());
		System.out.println(dat3.gestern().toString());
		System.out.println(dat3.morgen().toString());
		Datum dat4 = new Datum(31,12,1903);
		System.out.println(dat4.morgen().toString());
		Datum dat5 = new Datum(1,1,2012);
		System.out.println(dat5.gestern());
		System.out.println(dat.getWochentag());
		System.out.println(dat5.getWochentag());
		Datum dat6 = new Datum(23,12,1892);
		System.out.println(dat6.getWochentag());
	}

}
