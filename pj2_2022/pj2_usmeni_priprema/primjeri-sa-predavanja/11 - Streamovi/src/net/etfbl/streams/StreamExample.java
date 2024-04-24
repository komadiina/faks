package net.etfbl.streams;

import java.util.*;

public class StreamExample {

	public static void main(String[] args) {
		int count1 = 0, count2 = 0;
		List<String> words = Arrays.asList("multimedia", "network", "numeric", "open", "output", "paste", "peripheral",
				"printer", "processing", "replace", "interactive", "scanner", "search", "select", "software");
		count1 = (int) words.stream().filter(e -> e.length() >= 10).count();
		System.out.println(count1);
		System.out.println("=====================");
		words.stream().filter(e -> e.length() >= 10).forEach(System.out::println);
		for (String word : words) {
			if (word.length() >= 10) {
				count2++;
			}
		}
		System.out.println(count2);
		for (String word : words) {
			if (word.length() >= 10) {
				System.out.println(word);
			}
		}
		System.out.println("==================");
		int[] wordsLength = new int[16];
		words.stream().forEach(s -> {
			System.out.println(s + ": " + s.length());
			int tmp = wordsLength[s.length()];
			try {
				Thread.sleep((long) (Math.random()*10));
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			wordsLength[s.length()] = tmp + 1;
		});
		System.out.println(Arrays.toString(wordsLength));
	}
}
