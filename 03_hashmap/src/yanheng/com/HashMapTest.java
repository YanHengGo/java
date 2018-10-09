package yanheng.com;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		HashMap<String, Integer> map = new HashMap<>();
		Hashtable<String, Integer> tHashtable = new Hashtable<>();

		map.put("abc", 1243);
		System.out.println(map.get("abc"));

		tHashtable.put("def", 46);
		System.out.println(tHashtable.get("def"));

		map.put(null, 789);
		System.out.println(map.get(null));

		map.put("nullvalue", null);
		System.out.println(map.get("nullvalue"));

		ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

		String aa = "abc";
		String bb = "def";
		String cc = "abc";

		System.out.println(aa.hashCode());
		System.out.println(bb.hashCode());
		System.out.println(cc.hashCode());
	}

}
