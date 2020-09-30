package calc;

import calc.Calculator;

public class Calc {
  public static void main(String[] args) {
    Calculator calc = new Calculator();

    System.out.println("2 + 2 = " + calc.sum(2, 2));
    System.out.println("2 - 2 = " + calc.subtract(2, 2));
    System.out.println("2 / 2 = " + calc.div(2, 2));
    System.out.println("2 * 2 = " + calc.multi(2, 2));

    System.out.println("010101 = " + Integer.toBinaryString(calc.binary(0b010101)));
 }
}
