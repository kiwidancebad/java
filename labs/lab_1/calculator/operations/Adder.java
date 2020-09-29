package calc.operations;

public class Adder
{
  private int result;

  public Adder() { result = 0; }

  public Adder(int a) { this.result = a; }

  public void add(int b)
  {
    result += b;
  }

  public int getResult() { return result; }
}
