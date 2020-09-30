package calc;

import calc.Calculator;

public class Main {
  public static void main(String[] args)
  {
    Calculator calc = new Calculator();

    System.out.println("2 + 2 = " + calc.sum(2, 2));
    System.out.println("2 - 2 = " + calc.del(2, 2));
    
    System.out.println("2 / 2 = " + calc.div(2, 2));
    System.out.println("2 * 2 = " + calc.mul(2, 2));
  }
}
