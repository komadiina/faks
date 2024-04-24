package org.unibl.etf.oop;

public class MethodOverloading {

	public long sum(int x, int y){		// 1
		return x + y;
	}

	public long sum(long x, long y){	// 2
		return x + y;
	}

	public long sum(int x, long y){		// 3
		return x + y;
	}

//	public double sum(int x, int y){	// 4
//		return x + y;
//	}

	public long sum(int x, Long y){		// 5
		return x + y;
	}
}
