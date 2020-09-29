package calc.operations;

public class Division
{
  private int result;

  public Division() { result = 0; }

  public Division(int a) { this.result = a; }

  public void div(int b)
  {
    result /= b;
  }

  public int getResult() { return result; }
}
