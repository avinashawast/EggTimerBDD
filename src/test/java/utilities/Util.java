package utilities;

public class Util {
	public int elapsedTimeinSec(long startTime, long endTime) {
		int elapsedSecs = (int) ((endTime - startTime) / 1000);
		return elapsedSecs;
	}

}
