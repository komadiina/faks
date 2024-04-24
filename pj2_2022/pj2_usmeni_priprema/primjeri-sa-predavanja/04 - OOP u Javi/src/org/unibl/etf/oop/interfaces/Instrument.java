package org.unibl.etf.oop.interfaces;

interface Instrument { 							// 1
	void play();
	void tune();
}

interface LoudInstrument extends Instrument {	// 2
	void volumeUp(); 
}

