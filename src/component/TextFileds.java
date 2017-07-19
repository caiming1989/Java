package component;


import javax.swing.*;

public class TextFileds {
  private JTextArea quetos;
  private JTextField decrease;
  private JTextField average;
  private JTextField standard;
  private JTextArea score;

  public TextFileds() {
    initTextFields();
  }

  public JTextArea getQuetos() {
    return quetos;
  }

  public JTextArea getScore() {
    return score;
  }

  public JTextField getDecrease() {
    return decrease;
  }

  public JTextField getAverage() {
    return average;
  }

  public JTextField getStandard() {
    return standard;
  }

  private void initTextFields() {
    quetos = new JTextArea(10, 10);
    decrease = new JTextField();
    average = new JTextField();
    standard = new JTextField();
    score = new JTextArea(10, 10);
  }

}
