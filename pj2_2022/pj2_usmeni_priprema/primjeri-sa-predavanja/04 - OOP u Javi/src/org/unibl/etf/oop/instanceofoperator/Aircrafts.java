package org.unibl.etf.oop.instanceofoperator;

class Aircraft implements Fly {}
class PoweredAircraft extends Aircraft {}
class Airplane extends PoweredAircraft {}
class UnpoweredAircraft extends Aircraft {}
class Glider extends UnpoweredAircraft {}
interface Fly {}

public class Aircrafts {
	public static void main(String[] args) {
		Aircraft aircraft = new Aircraft(); 						//1
//		boolean result = aircraft instanceof String;				//2
		System.out.println(aircraft instanceof UnpoweredAircraft);	//3
		System.out.println(aircraft instanceof Airplane); 			//4
		aircraft = new Glider();									//5
		System.out.println(aircraft instanceof UnpoweredAircraft);	//6
		System.out.println(aircraft instanceof Aircraft); 			//7
		System.out.println(aircraft instanceof PoweredAircraft); 	//8
		System.out.println(aircraft instanceof Airplane); 			//9
		System.out.println(aircraft instanceof Fly);
	}
}


