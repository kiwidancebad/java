package lab_4;

public class Tostic extends Thread {

  private Button[] vectorButton;
  private int[] resultVector;
  
  public Tostic(Button[] vectorButton) {
    
    this.vectorButton = vectorButton;
  }

  @Override
  public void run() {
      
      resultVector = checkMatrixResult();    
  }  

  public int[] checkMatrixResult() {
    int maxCount = 0;
    int maxPosition = 0;
    int count = 0;
    int position = 0;
    String color = Button.red;
    for (int i = 0; i < vectorButton.length;i++) {
        if (color == vectorButton[i].getColor() && vectorButton[i].getColor() != Button.grey) {
          count++;
        } else {
          if (count > maxCount) {
            maxCount = count;
            maxPosition = position;
          }
          color = vectorButton[i].getColor();
          position = i;
          count = 1;
        }
    }
    if (count > maxCount) {
      maxCount = count;
      maxPosition = position;
    }

    if (maxCount >= 5) {
      return new int[]{maxCount, maxPosition};
    } else {
      return new int[]{-1, -1};
    }       
  }
  public int[] getResult(){
    return this.resultVector;
  }
}
