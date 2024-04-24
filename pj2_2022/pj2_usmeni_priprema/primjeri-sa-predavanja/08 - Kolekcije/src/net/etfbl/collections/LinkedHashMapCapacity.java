package net.etfbl.collections;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedHashMapCapacity {

	public static void main(String[] args) throws Exception {
		LinkedHashMap<Integer, Integer> v = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < 200; i++) {
			v.put(i, i);
			System.out.println("Size: " + v.size() + ", Capacity: " + getCapacity(v));
		}
	}

    static int getCapacity(LinkedHashMap<Integer, Integer> l) throws Exception {
//    	Field fields[] = LinkedHashMap.class.getDeclaredFields();
//    	for (Field field : fields) {
//			System.out.println(field);
//		}
        Field dataField = HashMap.class.getDeclaredField("table");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
    }

}
