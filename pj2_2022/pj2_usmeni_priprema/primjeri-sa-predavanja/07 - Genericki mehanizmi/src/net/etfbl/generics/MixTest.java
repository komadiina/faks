package net.etfbl.generics;


public class MixTest {

	public static void main(String[] args) {
//		GenericHolder holder = new GenericHolder<Integer>();
//		holder.set(10);
////		Integer i = (Integer) holder.get();
//		GenericHolder<Byte> holder2 = holder;
//		Byte s = holder2.get();
//		System.out.println(holder.get());
		GenericHolder<Integer> intHolder = new GenericHolder<>(); // The Diamond
		GenericHolder<GenericBase<Integer>> genericHolder = new GenericHolder<GenericBase<Integer>>(); 

		
		GenericHolder<String> holder1 = new GenericHolder<>(); 
		GenericHolder rawHolder = holder1; 

		GenericHolder rawHolder2 = new GenericHolder(); 
		GenericHolder<Integer> intHolder2 = rawHolder2;  

		GenericHolder<String> stringHolder = new GenericHolder<>(); 
		GenericHolder rawHolder3 = stringHolder; 
		rawHolder3.set(""); 

	}
}