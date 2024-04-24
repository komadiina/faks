package net.etfbl.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreation2 {

	@SuppressWarnings({ "unchecked", "unused"})
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		Stream<String> s1 = list.stream();
		Stream<String> s2 = list.parallelStream();
		String[] array = new String[]{"one", "two"};
		Stream<String> s3 = Arrays.stream(array);
		IntStream s4 = "abc".chars();
		Path path = Paths.get("test.txt");
		try(Stream<String> lines = Files.lines(path)) {

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
