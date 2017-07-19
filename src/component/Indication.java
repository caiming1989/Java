package component;

import java.util.ArrayList;

import javax.swing.*;

public class Indication {
  JLabel quetos;
  JLabel decrease;
  JLabel standard;
  JLabel average;
  JLabel score;

  public Indication() {
    initIndication();
  }

  public JLabel getQuetos() {
    return quetos;
  }

  public JLabel getDecrease() {
    return decrease;
  }

  public JLabel getAverage() {
    return average;
  }

  public JLabel getStandard() {
    return standard;
  }

  public JLabel getScore() {
    return score;
  }

  private void initIndication() {
    quetos = new JLabel("所有的投标：");
    decrease = new JLabel("下浮指数：");
    average = new JLabel("平均值：");
    standard = new JLabel("基准值：");
    score = new JLabel("得分：");
  }
}
