import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Main {
	public static void main(String[] args) {
		List<Integer> i1 = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10)),
			i2 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 10)),
			i3 = new ArrayList<>(Arrays.asList(5, 10, 15, 20, 25));
		
		Stream<Integer> all = Stream.concat(Stream.concat(i1.stream(), i2.stream()), i3.stream());
		Integer sumPoklapajucih = all.filter(i1::contains)
							.filter(i2::contains)
							.filter(i3::contains)
							.mapToInt(Integer::valueOf)
							.distinct()
							.sum();
			
		System.out.println(sumPoklapajucih);
	}
}