package net.etfbl.collections;

import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class ArrayDequeCapacity {

	public static void main(String[] args) throws Exception {
		ArrayDeque<Integer> adq = new ArrayDeque<Integer>();
		for (int i = 0; i < 200; i++) {
			adq.add(i);
            System.out.format("Size: %2d, Capacity: %2d%n",
            		adq.size(), getCapacity(adq));
		}
	}

    static int getCapacity(ArrayDeque<?> l) throws Exception {
//    	Field fields[] = ArrayDeque.class.getDeclaredFields();
//    	for (Field field : fields) {
//			System.out.println(field);
//		}
        Field dataField = ArrayDeque.class.getDeclaredField("elements");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
    }
}
