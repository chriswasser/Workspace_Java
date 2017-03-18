public class Datum {
	public static final int[] monatslaengen = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static final String[] wochentage = { "Mo", "Di", "Mi", "Do", "Fr", "Sa", "So" };
	private int tag, monat, jahr;

	public static int getMonatslaenge(int monat, int jahr) {
		// gibt Laenge des Monats zurueck. Berücksichtigt Schaltjahre.
		if (monat != 2) {
			return Datum.monatslaengen[monat - 1];
		} else {
			if (Datum.isSchaltjahr(jahr)) {
				return 29;
			} else {
				return Datum.monatslaengen[monat - 1];
			}
		}
	}

	public static boolean isSchaltjahr(int jahr) {
		// gibt true zurück, wenn das uebergebene Jahr ein Schaltjahr ist, //
		// ansonsten false
		// (siehe Hinweis unten)
		if ((jahr % 4) == 0) {
			if ((jahr % 100) == 0) {
				if ((jahr % 400) == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	public boolean equals(Datum a) {
		// ueberprueft, ob this und a das gleiche Datum haben.
		if ((this.jahr == a.jahr) && (this.monat == a.monat) && (this.tag == a.tag)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isGleicherTag(Datum a) {
		// ueberprueft, ob Tag und Monat gleich sind
		// (ohne Berücksichtigung des Jahres)
		if ((this.monat == a.monat) && (this.tag == a.tag)) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		// gibt eine passende String-Darstellung des Datums zurück
		String s = "" + this.tag + "." + this.monat + "." + this.jahr;
		return s;
	}

	public Datum(int tag, int monat, int jahr) {
		// Exception (siehe Text unten)
		if (jahr >= 1800 && jahr <= 2100) {
			this.jahr = jahr;
		} else {
			throw new DateOutOfRangeException("Datum ausserhalb des erlaubten Bereichs!");
		}
		if (monat >= 1 && monat <= 12) {
			this.monat = monat;
		} else {
			throw new InvalidDateException("Kein erlaubter Monat!");
		}
		if (Datum.monatslaengen[this.monat - 1] >= tag) {
			this.tag = tag;
		} else {
			if (monat == 2 && Datum.isSchaltjahr(this.jahr) && tag <= 29) {
				this.tag = tag;
			} else {
				throw new InvalidDateException("Keine erlaubte Tag-Monat-Kombination!");
			}
		}
	}

	public Datum(int tag, int jahr) {
		// Tag geht von 1 bis 365
		// Exception (siehe Text unten)
		if (jahr >= 1800 && jahr <= 2100) {
			this.jahr = jahr;
		} else {
			throw new DateOutOfRangeException("Datum ausserhalb des erlaubten Bereichs!");
		}
		if (Datum.isSchaltjahr(this.jahr)) {
			if (tag <= 366) {
				this.monat = 1;
				while (tag > Datum.monatslaengen[this.monat - 1]) {
					if (this.monat == 2) {
						if (tag > 29) {
							tag = tag - 29;
							this.monat = this.monat + 1;
						} else {
							this.tag = tag;
						}
					} else {
						tag = tag - Datum.monatslaengen[this.monat - 1];
						this.monat = this.monat + 1;
					}
				}
				this.tag = tag;
			} else {
				throw new InvalidDateException("Mehr Tage als erlaubt!");
			}
		} else {
			if (tag <= 365) {
				this.monat = 1;
				while (tag > Datum.monatslaengen[this.monat - 1]) {
					tag = tag - Datum.monatslaengen[this.monat - 1];
					this.monat = this.monat + 1;
				}
				this.tag = tag;
			} else {
				throw new InvalidDateException("Mehr Tage als erlaubt!");
			}
		}
	}

	public Datum morgen() {
		// gibt das Datum von this + 1 Tag zurück
		Datum morgen;
		if (Datum.isSchaltjahr(this.jahr) && this.monat == 2 && this.tag == 28) {
			morgen = new Datum(this.tag + 1, this.monat, this.jahr);
		} else {
			if (Datum.monatslaengen[this.monat - 1] == this.tag) {
				if (this.monat == 12) {
					morgen = new Datum(1, 1, this.jahr + 1);
				} else {
					morgen = new Datum(1, this.monat + 1, this.jahr);
				}
			} else {
				morgen = new Datum(this.tag + 1, this.monat, this.jahr);
			}
		}
		return morgen;
	}

	public Datum gestern() {
		// gibt das Datum von this - 1 Tag zurück
		Datum gestern;
		if (Datum.isSchaltjahr(this.jahr) && this.monat == 3 && this.tag == 1) {
			gestern = new Datum(29, this.monat - 1, this.jahr);
		} else {
			if (this.tag == 1) {
				if (this.monat == 1) {
					gestern = new Datum(Datum.monatslaengen[11], 12, this.jahr - 1);
				} else {
					gestern = new Datum(Datum.monatslaengen[this.monat - 2], this.monat, this.jahr);
				}
			} else {
				gestern = new Datum(this.tag - 1, this.monat, this.jahr);
			}
		}
		return gestern;
	}

	public String getWochentag() {
		// gibt den Wochentag des Datums (Mo-So) zurück
		// Berechnungsmethode: siehe Text unten
		int last2dig = this.jahr % 100;
		int sum = ((last2dig / 12) + (last2dig % 12) + ((last2dig % 12) / 4)) % 7;
		int anchor;
		if(this.jahr < 1900) {
			anchor = 5;
		} else if(this.jahr < 2000) {
			anchor = 3;
		} else {
			anchor = 2;
		}
		int doom = (sum + anchor) % 7;
		int daysdoom;
		int days;
		if(Datum.isSchaltjahr(this.jahr)) {
			daysdoom = 4;
			if(this.monat >= 3) {
				days = 1;
			} else {
				days = 0;
			}
			for(int i = 0; i < this.monat - 1; i++) {
				days = days + Datum.monatslaengen[i];
			}
			days = days + this.tag;
		} else {
			daysdoom = 3;
			days = 0;
			for(int i = 0; i < this.monat - 1; i++) {
				days = days + Datum.monatslaengen[i];
			}
			days = days + this.tag;
		}
		int diff = (days - daysdoom) % 7;
		if (diff < 0) {
			diff = diff + 7;
		}
		int mod = (diff + doom) % 7 - 1;
		if (mod < 0) {
			mod = mod +7;
		}
		return Datum.wochentage[mod];
	}
}