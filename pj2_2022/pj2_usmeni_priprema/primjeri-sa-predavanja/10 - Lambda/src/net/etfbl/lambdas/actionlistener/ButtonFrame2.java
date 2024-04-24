package net.etfbl.lambdas.actionlistener;

import java.awt.*;
import java.awt.event.*;


public class ButtonFrame2 extends JFrameBase {
  private static final long serialVersionUID = 1L;

  public ButtonFrame2() {
    super("Anonymous Inner Classes");
    button1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        setBg(Color.BLUE);
      }
    });
    button2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        setBg(Color.GREEN);
      }
    });
    button3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        setBg(Color.RED);
      }
    });
    setVisible(true);
  } 
}
