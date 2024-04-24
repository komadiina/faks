package org.unibl.etf.lambdas.instancerefmethods2;

public class InstanceMethodReference2 {
	public static void main(String[] args) {
		Temperature temperatures[] = 
				{ 	new Temperature("Belgrade", 24),
					new Temperature("Moscow", 11),
					new Temperature("Vienna", 27)
				};
		Temperature currentTemp = new Temperature("Doboj", 25);
		System.out.println("Higher temperatures: ");
		int higherTempNo = countAndPrint(temperatures, Temperature::higherThan, currentTemp);						// 1
		System.out.println("Higher temp: " + higherTempNo);
		int longerCityNameNo = countAndPrint(temperatures, Temperature::longerCityName, currentTemp);						
		System.out.println("LongerCityName: " + longerCityNameNo);
	}
	static int countAndPrint(Temperature tempArr[], CompareFunction<Temperature> cf, Temperature temp) {		// 2
		int counter = 0;
		for (int i = 0; i < tempArr.length; i++) {
			if (cf.function(tempArr[i], temp)) {				// 3
				counter++;
				System.out.println(tempArr[i]);
			}
		}
		return counter;
	}
}

class Temperature {												// 4
	private String city;
	private int value;
	public Temperature(String city, int value) {
		this.city = city;
		this.value = value;
	}
	public boolean higherThan(Temperature t) {				// 5
		return value > t.value;
	}
	public boolean longerCityName(Temperature t) {
		return city.length() > t.city.length();
	}
	
	@Override
	public String toString() {
		return city + ": " + value;
	}
}

interface CompareFunction<T> {								// 6
	public boolean function(T s1, T s2);						// 7
}
