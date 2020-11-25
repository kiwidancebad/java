package lab_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;

public class Field extends JFrame implements ActionListener {

  private Button[][] matrixButton;

  private int iIndex;
  private int jIndex;

  private boolean status = false;

  private int globalXCord;
  private int globalYCord;

  private JLabel label2;

  public Field(int i1, int j1) {
    super("lab_5");

    iIndex = i1;
    jIndex = j1;
    
    this.matrixButton = new Button[i1][j1];

    setSize(1000,1000);
    setLocation(100,100);

    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JPanel panel = new JPanel();

    GridLayout layout = new GridLayout(i1 + 1, j1, 5, 5);
    
    panel.setLayout(layout);

    for (int i = 0; i < i1; i++) {
      for (int j = 0; j < j1; j ++) {
        Button button = new Button("", false, i, j);

        button.setColor(button.grey);
        button.addActionListener(this);

        this.matrixButton[i][j] = button;

        panel.add(button);
      }
    }

    JLabel label1 = new JLabel("Score:");

    label2 = new JLabel("0");

    panel.add(label1);
    panel.add(label2);    

    getContentPane().add(panel);

    pack();

    setVisible(true);
  }

  public void testMatrix() {
    for (int i = 0; i < this.iIndex; i++) {
      for (int j = 0; j < this.jIndex; j++) {
        matrixButton[i][j].setColor(matrixButton[i][j].red);

        System.out.print(matrixButton[i][j].getXCord());
        System.out.print(matrixButton[i][j].getYCord());
        System.out.println();
      }
    }
  }
  public void randomColor() {
    Random random = new Random();

    for (int i = 0; i < 3; i++) {
      int randomIndex = random.nextInt(4);

      int randomXCord;
      int randomYCord;

      while (true) {
        randomXCord = random.nextInt(this.iIndex);
        randomYCord = random.nextInt(this.jIndex);

        if (this.matrixButton[randomXCord][randomYCord].getColor() == Button.grey) {
          break;
        }
      }
      
      if (randomIndex == 0) {
        matrixButton[randomXCord][randomYCord].setColor(Button.red);
      }

      if (randomIndex == 1) {
        matrixButton[randomXCord][randomYCord].setColor(Button.green);
      }

      if (randomIndex == 2) {
        matrixButton[randomXCord][randomYCord].setColor(Button.blue);
      }

      if (randomIndex == 3) {
        matrixButton[randomXCord][randomYCord].setColor(Button.yellow);
      }
    }
    
  }

  public void actionPerformed(ActionEvent e) {
    Button button = (Button) e.getSource();

    if (status) {
      if (button.getColor() == Button.grey && (pathfinder(globalXCord, globalYCord, button.getXCord(), button.getYCord()) || 
          pathfinder(button.getXCord(), button.getYCord(), globalXCord, globalYCord))) {
        button.setColor(matrixButton[globalXCord][globalYCord].getColor());

        matrixButton[globalXCord][globalYCord].setColor(Button.grey);

        status = false;

        matrixControl();
        randomColor();
      } else {
        status = false;
      }
    } else if (button.getColor() != Button.grey){
      globalXCord = button.getXCord();
      globalYCord = button.getYCord();

      status = true;
    }
  }

  public boolean pathfinder(int ax, int ay, int bx, int by) {
    int[][] grid = new int[this.iIndex][this.jIndex];

    for (int i = 0; i < this.iIndex; i++) {
      for (int j = 0; j < this.jIndex; j++) {
        if (matrixButton[i][j].getColor() == Button.grey) {
          grid[i][j] = Leen.BLANK;
        } else {
          grid[i][j] = Leen.WALL;
        }
      }
    }

    Leen lee = new Leen(grid);

    boolean result = lee.lee(ax, ay, bx, by);  

    return result;    
  }

  public void matrixControl() {
    Button[][] trM = transportMatrix();

    int[][] vectorData = new int [iIndex * 2][];

    for (int i = 0; i < this.iIndex * 2; i++) {
      if (i < this.iIndex) {
        Tostic myThread = new Tostic(matrixButton[i]);
        
        myThread.start();

        try {
          myThread.join();
        } catch(Exception exp) {}

        vectorData[i] = myThread.getResult();

        System.out.print(myThread.getResult()[0]+ " " + myThread.getResult()[1]);
        System.out.println();
      } else {
        Tostic myThread = new Tostic(trM[i-this.iIndex]);
        
        myThread.start();

        try {
          myThread.join();
        } catch(Exception exp) {}

        vectorData[i] = myThread.getResult();

        System.out.print(myThread.getResult()[0] + " " + myThread.getResult()[1]);
        System.out.println();
      }
    }

    for (int i = 0; i < iIndex * 2; i++) {
      if (vectorData[i][0] != -1) {
        if (i < iIndex) {
          for (int j = vectorData[i][1]; j < vectorData[i][1] + vectorData[i][0]; j++) {
            matrixButton[i][j].setColor(Button.grey);
          }

          int a = Integer.parseInt(label2.getText()) + vectorData[i][0];

          label2.setText(String.valueOf(a));
        } else {
          for (int j = vectorData[i][1]; j < vectorData[i][1] + vectorData[i][0]; j++) {
            matrixButton[j][i - iIndex].setColor(Button.grey);
          }

          int a = Integer.parseInt(label2.getText()) + vectorData[i][0];

          label2.setText(String.valueOf(a));
        }
      }
    }
  }

  private Button[][] transportMatrix() {
    Button[][] newMatrix = new Button[this.iIndex][this.jIndex];

    for (int i = 0; i < this.iIndex; i++) {
      for (int j = 0; j < this.jIndex; j++) {
        newMatrix[j][i] = matrixButton[i][j];
      }      
    }
    
    return newMatrix;
  }
}