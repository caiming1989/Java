package component;

import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.*;

public class Button {
  private ArrayList<JButton> keyboard = new ArrayList<>();
  private JButton space;
  private JButton ok;
  private JButton point;
  private JButton cancel;
  private JButton next;

  public Button() {
    initButton();
  }

  public JButton getSpace() {
    return space;
  }

  public JButton getOk() {
    return ok;
  }

  public JButton getPoint() {
    return point;
  }

  public JButton getCancel() {
    return cancel;
  }

  public JButton getNext() {
    return next;
  }

  public JButton getNumButton(String num) {
    return keyboard.get(Integer.parseInt(num));
  }

  private void initButton() {
    for (int i=0;i<10;i++) {
      JButton button = new JButton(String.valueOf(i));
      keyboard.add(button);
    }
    space = new JButton("Space");
    ok = new JButton("OK");
    point = new JButton(".");
    cancel = new JButton("C");
    next = new JButton("Next");
  }

  public void addListenerToButtonOk(TextFileds textFileds) {
    ok.addActionListener(argo -> {
      String quetos = textFileds.getQuetos().getText();
      double sum = 0;
      String[] str = quetos.split("\n");
      for (int i = 0; i < str.length; i++) {
        sum = sum + Double.parseDouble(str[i]);
      }
      double average = sum / str.length;
      double decrease = Double.parseDouble(textFileds.getDecrease().getText());
      double A = average * (1 - decrease/100);
      double score = 0;

      NumberFormat numberFormat = NumberFormat.getNumberInstance();
      numberFormat.setMaximumFractionDigits(2);

      textFileds.getAverage().setText(numberFormat.format(average));
      textFileds.getStandard().setText(numberFormat.format(A));

      for (int i = 0; i < str.length; i++) {
        double queto = Double.parseDouble(str[i]);
        if (queto < A) {
          score = 70 - ((A - queto) / A) * 100;
        } else if (queto > A) {
          score = 70 - ((queto - A) / A) * 200;
        }
        textFileds.getScore().append(numberFormat.format(score) + "\r\n");
      }
    });
  }

  public void addListenerToButtonNext(TextFileds textFileds) {
   next.addActionListener(argo -> {
     textFileds.getScore().setText("");
     textFileds.getQuetos().setText("");
     textFileds.getAverage().setText("");
     textFileds.getStandard().setText("");
     textFileds.getDecrease().setText("");
   });
  }
}
