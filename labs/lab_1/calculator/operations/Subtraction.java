package calc.operations;

public class Subtraction
{
  private int result;

  public Subtraction() { result = 0; }

  public Subtraction(int a) { this.result = a; }

  public void subtract(int b)
  {
    result -= b;
  }

  public int getResult() { return result; }
}
