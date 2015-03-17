package team.misc;

import java.util.Comparator;
import java.util.Map;

class MapValueSorter implements Comparator<String> {

	Map<String, Integer> map;

	public MapValueSorter(Map<String, Integer> map) {
		this.map = map;
	}
	
	public int compare(String value1, String value2) {
		if (map.get(value1) >= map.get(value2)) {
			return -1;
		} else {
			return 1;
		}
	}
}
