package org.unibl.etf.enums;

enum MobilePhone {
	SAMSUNG_S9 (1000), SAMSUNG_S8 (800), SAMSUNG_S7 (600), IPHONE_9 (1100), IPHONE_8(900);
	
	private int price;
	MobilePhone(int price) {
		System.out.println(this.name() + ": " + price);
		this.price = price;
	}
	
	int getPrice() {
		return price;
	}
}
