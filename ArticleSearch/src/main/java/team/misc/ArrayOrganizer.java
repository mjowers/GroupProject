package team.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ArrayOrganizer {

	public static ArrayList<String> createArray(ArrayList<String> listIn,
			String delims) {
		ArrayList<String> listOut = new ArrayList<String>();
		for (String line : listIn) { // to make the ArrayList lines coming in
										// turn into a String
			StringTokenizer st = new StringTokenizer(line, delims);
			while (st.hasMoreTokens()) {
				listOut.add(st.nextToken());
			}
		}
		return listOut;
	}

}