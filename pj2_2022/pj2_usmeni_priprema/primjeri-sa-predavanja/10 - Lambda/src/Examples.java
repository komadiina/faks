import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class Examples {

	public static void main(String[] args) {
		BiFunction<Integer, Integer, Double> biFunction = (i1, i2) -> Math.pow(i1, i2);
		Double i = biFunction.apply(2, 3);
		System.out.println(i);
		Function<Double, String> function = (in) -> "String value of " + in;
		String r = function.apply(i);
		System.out.println(r);

		BiFunction<Integer, Integer, String> res = biFunction.andThen(function);
		String r2 = res.apply(3, 2);
		System.out.println(r2);

		System.out.println("=================================");
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		BiConsumer<Integer, String> biConsumer = (key, value) -> System.out.println("Key:" + key + " Value:" + value);
		map.forEach(biConsumer);

		System.out.println("=================================");
		BiPredicate<Integer, String> condition = (a, b) -> a > 20 && b.startsWith("B");
		System.out.println(condition.test(10, "Belgrade"));
		System.out.println(condition.test(30, "Doboj"));
		System.out.println(condition.test(30, "Banja Luka"));
	}

}
