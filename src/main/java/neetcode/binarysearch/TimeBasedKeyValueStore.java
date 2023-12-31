package neetcode.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {

	/* Design a time-based key-value data structure that can store multiple values for the same key at different time
	stamps and retrieve the key's value at a certain timestamp. Implement the TimeMap class:
	TimeMap() Initializes the object of the data structure.
	void set(String key, String value, int timestamp) Stores the key with the value at the given time
	timestamp.
	String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <=
	timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If
	there are no values, it returns "".

	Example 1:
	Input
	["TimeMap", "set", "get", "get", "set", "get", "get"][[], ["foo", "bar", 1], ["foo", 1], ["foo", 3],
	["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
	Output
	[null, null, "bar", "bar", null, "bar2", "bar2"]
	Explanation
	TimeMap timeMap = new TimeMap();
	timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
	timeMap.get("foo", 1);         // return "bar"
	timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and
	timestamp 2, then the only value is at timestamp 1 is "bar".
	timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
	timeMap.get("foo", 4);         // return "bar2"
	timeMap.get("foo", 5);         // return "bar2"

	Constraints:
	1 <= key.length, value.length <= 100 key and value consist of lowercase English letters and digits.
	1 <= timestamp <= 10^7
	All the timestamps timestamp of set are strictly increasing. At most 2 * 10^5 calls will be made to set and get. */

	private final Map<String, List<Map.Entry<String, Integer>>> map;

	public TimeBasedKeyValueStore() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		map.putIfAbsent(key, new ArrayList<>());
		map.get(key).add(Map.entry(value, timestamp));
	}

	/*
	Time complexity: O(log(n))
	Space complexity: O(1)
	 */
	public String get(String key, int timestamp) {
		if (!map.containsKey(key)) {
			return "";
		}
		final var vals = map.get(key);
		int l = 0, r = vals.size() - 1, res = -1;
		while (l <= r) {
			final int mid = l + (r - l) / 2;
			final var val = vals.get(mid);
			if (val.getValue() == timestamp) {
				res = mid;
			} else if (timestamp < val.getValue()) {
				r = mid - 1;
			} else {
				l = mid + 1;
				res = val.getValue();
			}
		}
		return res == -1 ? "" : vals.get(res).getKey();
	}

	public static void main(String[] args) {
		final var obj = new TimeBasedKeyValueStore();
		obj.set("foo", "bar", 1);
		obj.set("foo", "bar2", 4);
		System.out.println(obj.get("foo", 4));
		System.out.println(obj.get("foo", 5));
	}
}
