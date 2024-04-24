package net.etfbl.lambdas.actionlistener;

import java.awt.*;

public class ButtonFrame3 extends JFrameBase {
  private static final long serialVersionUID = 1L;

  public ButtonFrame3() {
    super("Lambdas");
    button1.addActionListener(event -> setBg(Color.BLUE)); 
    button2.addActionListener(event -> setBg(Color.GREEN));
    button3.addActionListener(event -> setBg(Color.RED));
    setVisible(true);
  } 
}
