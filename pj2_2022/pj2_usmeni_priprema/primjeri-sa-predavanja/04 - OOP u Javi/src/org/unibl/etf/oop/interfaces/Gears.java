package org.unibl.etf.oop.interfaces;

interface Gears {												// 1
	int FIRST = 1;
	int SECOND = 2;
	int THIRD = 3;
	int FOURTH = 4;
	int FIFTH = 5;
	int SIXTH = 6;
}

class Motorcycle implements Gears{							// 2
	int currentGear;

	public static void main(String args[]){
		Motorcycle moto = new Motorcycle();
		moto.currentGear = Gears.FIRST;						// 3
		moto.currentGear = SECOND;								// 4
	}
}


interface WarpGears {					  				// 1
	String FIRST = "Warp 1";
	String SECOND = "Warp 2";
	String THIRD = "Warp 3";
}

class UFO implements Gears, WarpGears {		  				// 2
	String currentGear;

	public static void main(String args[]){
		UFO ufo = new UFO();
		ufo.currentGear = "" + Gears.SECOND;				// 3
		ufo.currentGear = WarpGears.SECOND;					// 4
	}
}


