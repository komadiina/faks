package org.unibl.etf.oop.interfaces;

public class Piano implements LoudInstrument {		// 1
	public void play() {
		System.out.println("Play piano...");
	}
	public void tune() {
		System.out.println("Tune piano...");
	}
	public void volumeUp() {
		System.out.println("Volume up piano...");
	}
	public static void main(String[] args) {
		Piano piano = new Piano();		   			// 2
		Instrument instrument = piano;		   		// 3
		LoudInstrument loudInstrument = piano;		// 4
		instrument.play();
		loudInstrument.volumeUp();
	}
}
