public class CalculatorApp {
  public static class Subtraction {
    private int result;

    public void sub(int x) {
      result -= x;
    }

    public int getResult() {
      return result;
    }
  }

  public static class Multiplication {
    private int result = 0;

    public void multiply(int x) {
      result *= x;
    }

    public int getResult() {
      return result;
    }
  }

  public static class Division {
    private int result = 0;

    public void div(int x) {
      result /= x;
    }

    public int getResult() {
      return result;
    }
  }

  public static class Addition {
    private int result = 0;

    public void add(int x) {
      result += x;
    }

    public int getResult() {
      return result;
    }
  }

  public class Calculator {
    public int result(int... arr) {
      Adder 
    }
  }

  public static void main (String[] args) {
    Calculator calc = new Calculator();

    calc.calc("addition");
  }
}
