package team.misc;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ArrayOrganizer {

	public static ArrayList<String> createArrayFromArrayList(ArrayList<String> listIn,
			String delims) {
		ArrayList<String> listOut = new ArrayList<String>();
		if(listIn == null || delims == null)
			return listOut;
		for (String line : listIn) { // to make the ArrayList lines coming in
										// turn into a String
			StringTokenizer st = new StringTokenizer(line, delims);
			while (st.hasMoreTokens()) {
				listOut.add(st.nextToken());
			}
		}
		return listOut;
	}
	
	public static ArrayList<String> createArrayFromString(String stringIn, String delims){
		ArrayList<String> listOut = new ArrayList<String>();
		if(stringIn == null ||  delims == null)
			return listOut;
		StringTokenizer st = new StringTokenizer(stringIn, delims);
		while (st.hasMoreTokens()) {
			listOut.add(st.nextToken());
		}
		return listOut;
	}

}