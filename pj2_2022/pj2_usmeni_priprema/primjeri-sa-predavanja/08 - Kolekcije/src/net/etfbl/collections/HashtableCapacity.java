package net.etfbl.collections;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Hashtable;

public class HashtableCapacity {

	public static void main(String[] args) throws Exception {
		Hashtable<Integer, Integer> v = new Hashtable<Integer, Integer>();
		System.out.println("Size: " + v.size() + ", Capacity: " + getCapacity(v));
		for (int i = 0; i < 200; i++) {
			v.put(i, i);
			System.out.println("Size: " + v.size() + ", Capacity: " + getCapacity(v));
		}
	}

    static int getCapacity(Hashtable<Integer, Integer> l) throws Exception {
//    	Field fields[] = HashMap.class.getDeclaredFields();
//    	for (Field field : fields) {
//			System.out.println(field);
//		}
        Field dataField = Hashtable.class.getDeclaredField("table");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
    }

}
