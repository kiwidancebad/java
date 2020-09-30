package calc.operations;

public class Binary
{
  private int result;

  public Binary() { result = 0; }

  public Binary(int a) { this.result = a;}

  public void binary(int b)
  {
    this.result = ~b;
  }

  public int getResult() { return result; }
}   
