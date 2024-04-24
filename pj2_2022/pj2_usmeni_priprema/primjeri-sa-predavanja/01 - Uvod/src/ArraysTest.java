public class ArraysTest {

	public static void main(String[] args) {
//		int arrayInt[] = new int[10];
//		
//		printInts(arrayInt);
//		
//		for (int i = 0; i < arrayInt.length; i++) {
//			arrayInt[i] = i;
//		}
//		
//		printInts(arrayInt);
//
//		Calculator calculators[] = new Calculator[3];
//		printCalculators(calculators);
//		System.out.println();
//		for (int i = 0; i < calculators.length; i++) {
//			calculators[i] = new Calculator(i, i+1);
//		}
//		printCalculators(calculators);
////		
//
//		Calculator twoDimCalculators[][] = new Calculator[2][3];
//		printTwoDimCalculators(twoDimCalculators);
//		
//		for (int i = 0; i < twoDimCalculators.length; i++) {
//			for(int j = 0; j < twoDimCalculators[0].length; j++) {
//				twoDimCalculators[i][j] = new Calculator(i, j);
//			}
//		}
//		printTwoDimCalculators(twoDimCalculators);
//		printTwoDimCalculators2(twoDimCalculators);
//		
//		int arrayTwoDimInt[][] = new int[2][3];
//		printTwoDimInts(arrayTwoDimInt);
//		for (int i = 0; i < arrayTwoDimInt.length; i++) {
//			for (int j=0; j<arrayTwoDimInt[0].length; j++) {
//				arrayTwoDimInt[i][j] = i + j;
//			}
//		}
//		printTwoDimInts(arrayTwoDimInt);
//		
        int arrayTwoDimInt2[][] = new int[15][];
        
        for (int i = 0; i < arrayTwoDimInt2.length; i++) {  // 15
            arrayTwoDimInt2[i] = new int[i + 1];
            for (int j = 0; j < arrayTwoDimInt2[i].length; j++) { // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9...
                arrayTwoDimInt2[i][j] = j;
            }
        }
        
		printTwoDimInts(arrayTwoDimInt2);
		
	}

	private static void printTwoDimInts(int[][] arrayTwoDimInt) {
		for (int i = 0; i < arrayTwoDimInt.length; i++) {
			for (int j=0; j<arrayTwoDimInt[i].length; j++) {
				System.out.print(arrayTwoDimInt[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===");
	}

	private static void printCalculators(Calculator[] calculators) {
		for (Calculator calculator : calculators) {
			if(calculator != null) {
				System.out.print("Calculator(" + calculator.operand1 + ", " + calculator.operand2 + ")-add:" + calculator.add() + "  ");
			} else {
				System.out.print("null  ");
			}
		}
//		System.out.println();
//		System.out.println("===");
	}
	
	private static void printTwoDimCalculators(Calculator[][] twoDimCalculators) {
		for (int i = 0; i < twoDimCalculators.length; i++) {
			for(int j = 0; j < twoDimCalculators[0].length; j++) {
				if(twoDimCalculators[i][j] != null) {
					System.out.print("Calculator(" + twoDimCalculators[i][j].operand1 + ", " + twoDimCalculators[i][j].operand2 + ")-add:" + twoDimCalculators[i][j].add() + "  ");
				} else {
					System.out.print("null ");
				}
			}
			System.out.println();
		}
		System.out.println("==========");
	}
	
	private static void printTwoDimCalculators2(Calculator[][] twoDimCalculators) {
		for (int i = 0; i < twoDimCalculators.length; i++) {
			printCalculators(twoDimCalculators[i]);
			System.out.println();
		}
		System.out.println("==========");
	}

	private static void printInts(int[] arrayInt) {
		for (int i : arrayInt) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("===");
	}

}
