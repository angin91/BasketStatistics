package se.kungsbacka.basket.helper;

public class HelperClass {

	public static double getFreethrowProcent(int freeThrowAttempt, int freeThrowMade) {
		if(freeThrowAttempt == 0 && freeThrowMade == 0){
			return 0.0;
		}
		double d = (double) freeThrowMade / freeThrowAttempt;
		return round(d*100, 1);
	}

	public static double getTwoPointProcent(int twoPointAttempt, int twoPointMade) {
		if(twoPointAttempt == 0 && twoPointMade == 0){
			return 0.0;
		}
		double d = (double) twoPointMade / twoPointAttempt;
		return round(d*100, 1);
	}
	
	public static double getThreePointProcent(int threePointAttempt, int threePointMade) {
		if(threePointAttempt == 0 && threePointMade == 0){
			return 0.0;
		}
		double d = (double) threePointMade / threePointAttempt;
		return round(d*100, 1);
	}
	
	public static double getTotalShotProcent(int totalShotsAttempt, int totalShotsMade) {
		if(totalShotsAttempt == 0 && totalShotsMade == 0){
			return 0.0;
		}
		double d = (double) totalShotsMade / totalShotsAttempt;
		return round(d*100, 1);
	}

	private static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

	public static int getTotalPoints(int twoPointsMade, int threePointsMade, int freeThrowsMade) {
		int i = (twoPointsMade * 2) + (threePointsMade * 3) + freeThrowsMade;
		return i;
	}
}
