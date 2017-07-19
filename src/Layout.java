import component.Button;
import component.Indication;
import component.TextFileds;

import java.awt.*;

import javax.swing.*;

public class Layout extends JFrame{
  private int row;
  private int column;

  private Button button;
  private TextFileds textFileds;
  private Indication indication;

  private JPanel mainframe;
  private JPanel subframe_center;
  private BorderLayout boarder;

  public Layout(String title, int row, int column) {
    super(title);
    this.row = row;
    this.column = column;

    initComponent();
    mainframe = new JPanel();
    getContentPane().add(mainframe);
    subframe_center = new JPanel();
    boarder = new BorderLayout();
    mainframe.setLayout(boarder);
    mainframe.add(subframe_center, BorderLayout.CENTER);
    createCenter(subframe_center);

    addListenerToButton();

    setSize(450, (int) (300 * this.row * 1.0 / this.column));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLocationByPlatform(true);
    this.setVisible(true);
    this.requestFocus();
  }

  private void addListenerToButton() {
    button.addListenerToButtonOk(textFileds);
    button.addListenerToButtonNext(textFileds);
  }

  private void createCenter(JPanel subframe_center) {
    GridBagLayout grid = new GridBagLayout();
    subframe_center.setLayout(grid);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;

    gbc.gridwidth = GridBagConstraints.REMAINDER;
    addToPanel(subframe_center, grid, gbc, indication.getQuetos());

    gbc.gridwidth = GridBagConstraints.REMAINDER;
    textFileds.getQuetos().setColumns(30);
    addToPanel(subframe_center, grid, gbc, textFileds.getQuetos());

    gbc.gridwidth = GridBagConstraints.REMAINDER;
    addToPanel(subframe_center, grid, gbc, indication.getDecrease());

    gbc.gridwidth = GridBagConstraints.REMAINDER;
    textFileds.getDecrease().setColumns(30);
    addToPanel(subframe_center, grid, gbc, textFileds.getDecrease());

    gbc.gridwidth = GridBagConstraints.REMAINDER;
    addToPanel(subframe_center, grid, gbc, button.getOk());

    gbc.gridwidth = GridBagConstraints.REMAINDER;
    textFileds.getDecrease().setColumns(30);
    addToPanel(subframe_center, grid, gbc, indication.getAverage());

    gbc.gridwidth = GridBagConstraints.REMAINDER;
    addToPanel(subframe_center, grid, gbc, textFileds.getAverage());

    gbc.gridwidth = GridBagConstraints.REMAINDER;
    textFileds.getDecrease().setColumns(30);
    addToPanel(subframe_center, grid, gbc, indication.getStandard());

    gbc.gridwidth = GridBagConstraints.REMAINDER;
    addToPanel(subframe_center, grid, gbc, textFileds.getStandard());

    gbc.gridwidth = GridBagConstraints.REMAINDER;
    addToPanel(subframe_center, grid, gbc, indication.getScore());

    gbc.gridwidth = GridBagConstraints.REMAINDER;
    textFileds.getScore().setColumns(30);
    addToPanel(subframe_center, grid, gbc, textFileds.getScore());

    gbc.gridwidth = GridBagConstraints.REMAINDER;
    addToPanel(subframe_center, grid, gbc, button.getNext());
  }

  private void addToPanel(JPanel panel, GridBagLayout lay, GridBagConstraints c, Component component) {
    lay.setConstraints(component, c);
    panel.add(component);
  }

  private void initComponent() {
    button = new Button();
    textFileds = new TextFileds();
    indication = new Indication();
  }

  public static void main(String[] args) {
    new Layout("test", 30, 15);
  }
}
