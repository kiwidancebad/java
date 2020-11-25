package lab_4;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.*;

public class Button extends JButton {
  private int xCord;
  private int yCord;

  private String color;

  private boolean check = false;

  public static String red = "RED";
  public static String green = "GREEN";
  public static String blue = "BLUE";
  public static String yellow = "YELLOW";
  public static String grey = "GREY";


  public Button(String name, boolean check, int xCord, int yCord){
    super(name);

    this.setPreferredSize(new Dimension(50,50));

    this.check = check;

    this.xCord = xCord;
    this.yCord = yCord;
  }

  public void setCheck(boolean check) {
    this.check = check;
  }

  public boolean getCheck() {
    return this.check;
  }

  public int getXCord() {
    return this.xCord;
  }
  public int getYCord() {
    return this.yCord;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    if (color == this.red) {
      this.setBackground(Color.RED);
      this.color = color;
    }

    if (color == this.green) {
      this.setBackground(Color.GREEN);
      this.color = color;
    }    

    if (color == this.grey) {
      Color c1 = new Color(150, 150, 150);

      this.setBackground(c1);
      this.color = color;
    }

    if (color == this.blue) {
      this.setBackground(Color.BLUE);
      this.color = color;
    }    
    
    if (color == this.yellow) {
      this.setBackground(Color.YELLOW);
      this.color = color;
    }
  }
}