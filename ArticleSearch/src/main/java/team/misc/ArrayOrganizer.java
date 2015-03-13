package team.misc;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ArrayOrganizer {

	public static ArrayList<String> createArray(ArrayList<String> arrayIn,
			String delims) {
		if (arrayIn.size() < 1 || delims == null || delims == "") {
			return arrayIn;
		}
		ArrayList<String> arrayOut = new ArrayList<String>();
		for (String line : arrayIn) {
			StringTokenizer st = new StringTokenizer(line, delims);
			while (st.hasMoreTokens()) {
				arrayOut.add(st.nextToken());
			}
		}
		return arrayOut;
	}
}