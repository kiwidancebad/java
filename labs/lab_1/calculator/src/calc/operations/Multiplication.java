package calc.operations;

public class Multiplication
{
  private int result;

  public Multiplication() { result = 1; }

  public Multiplication(int a) { this.result = a; }

  public void multi(int b)
  {
    result *= b;
  }

  public int getResult() { return result; }
}   
