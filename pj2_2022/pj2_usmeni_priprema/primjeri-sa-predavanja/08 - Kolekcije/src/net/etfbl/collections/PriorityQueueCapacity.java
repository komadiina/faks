package net.etfbl.collections;

import java.lang.reflect.Field;
import java.util.PriorityQueue;

public class PriorityQueueCapacity {

	public static void main(String[] args) throws Exception {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < 200; i++) {
			pq.add(i);
            System.out.format("Size: %2d, Capacity: %2d%n",
            		pq.size(), getCapacity(pq));
		}
	}

    static int getCapacity(PriorityQueue<?> l) throws Exception {
        Field dataField = PriorityQueue.class.getDeclaredField("queue");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
    }
}
