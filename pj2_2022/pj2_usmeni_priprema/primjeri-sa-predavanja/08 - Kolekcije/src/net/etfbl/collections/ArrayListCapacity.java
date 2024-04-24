package net.etfbl.collections;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayListCapacity {

	public static void main(String[] args) throws Exception {
		ArrayList<Integer> al = new ArrayList<Integer>();
	       for (int i = 0; i < 200; i++) {
	            al.add(i);
	            System.out.format("Size: %2d, Capacity: %2d%n",
	                              al.size(), getCapacity(al));
	        }
	    }

	    static int getCapacity(ArrayList<?> l) throws Exception {
	        Field dataField = ArrayList.class.getDeclaredField("elementData");
	        dataField.setAccessible(true);
	        return ((Object[]) dataField.get(l)).length;
	    }
}
