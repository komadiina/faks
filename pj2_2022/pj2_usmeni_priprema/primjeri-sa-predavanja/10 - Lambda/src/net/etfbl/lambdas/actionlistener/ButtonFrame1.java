package net.etfbl.lambdas.actionlistener;

import java.awt.*;
import java.awt.event.*;

public class ButtonFrame1 extends JFrameBase {
	private static final long serialVersionUID = 1L;

	public ButtonFrame1() {
		super("Named Inner Classes");
		button1.addActionListener(new ColorChanger(Color.BLUE));
		button2.addActionListener(new ColorChanger(Color.GREEN));
		button3.addActionListener(new ColorChanger(Color.RED));
		setVisible(true);
	}

	private class ColorChanger implements ActionListener {
		private Color bgColor;

		public ColorChanger(Color bgColor) {
			this.bgColor = bgColor;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			setBg(bgColor);
		}
	}
}
