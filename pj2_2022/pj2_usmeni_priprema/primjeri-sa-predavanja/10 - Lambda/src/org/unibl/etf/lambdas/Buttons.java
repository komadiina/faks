package org.unibl.etf.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JButton;


//public class Buttons {
//	public static void main(String[] args) {
//		List<String> l = Arrays.asList("B1", "B2");			// 1
//		Stream<JButton> s = l.stream().map(JButton::new);	// 2
//		List<JButton> btns = s.collect(Collectors.toList());
//		for (JButton button : btns) {
//			System.out.println(button.getText());
//		}
//	}
//}

public class Buttons {
	public static void main(String[] args) {
		List<String> b = Arrays.asList("B1", "B2");			
		Stream<JButton> s = b.stream().map(JButton::new);
		JButton[] buttons = s.toArray(JButton[]::new);		// 1
		for (JButton button : buttons) {
			System.out.println(button.getText());
		}
	}
}


//public class Buttons {
//	public static void main(String[] args) {
//		List<String> labels = Arrays.asList("Button 1", "Button 2");
//		Stream<JButton> stream = labels.stream().map(JButton::new);
//		List<JButton> buttons = stream.collect(Collectors.toList());
//		for (JButton button : buttons) {
//			System.out.println(button.getText());
//		}
//		stream = labels.stream().map(JButton::new);
//		JButton[] buttons2 = stream.toArray(JButton[]::new);
//		for (JButton button : buttons2) {
//			System.out.println(button.getText());
//		}
//	}
//}



