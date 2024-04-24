package net.etfbl.lambdas.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JButton;

public class Buttons {
	public static void main(String[] args) {
		List<String> labels = Arrays.asList("Button 1", "Button 2");
		Stream<JButton> stream = labels.stream().map(JButton::new);
		List<JButton> buttons = stream.collect(Collectors.toList());
		for (JButton button : buttons) {
			System.out.println(button.getText());
		}
		JButton[] buttons2 = stream.toArray(JButton[]::new);
	}
}
