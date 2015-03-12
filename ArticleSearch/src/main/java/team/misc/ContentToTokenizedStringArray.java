package team.misc;

import java.util.ArrayList;

public class ContentToTokenizedStringArray {

	public ArrayList<String> ContentToArrayList(String content){
		return ArrayOrganizer.createArrayFromString(content," ");
	}
}
