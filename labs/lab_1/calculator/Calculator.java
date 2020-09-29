package calc;

import calc.operations.Adder;
import calc.operations.Division;
import calc.operations.Multiplication;
import calc.operations.Subtraction;

public class Calculator
{
  public int sum(int... a)
  {
    Adder adder = new Adder();

    for (int i:a)
    {
      adder.add(i);
    }

    return adder.getResult();
  }

  public int divs(int b, int... a)
  {
    Division division = new Division(b);

    for (int i:a)
    {
      division.div(i);
    }

    return division.getResult();
  }

  public int mult(int... a)
  {
    Multiplication multiplication = new Multiplication();

    for (int i:a) 
    {
      multiplication.multiply(i);
    }

    return multiplication.getResult();
  }

  public int subtrac(int a)
  {
    Subtraction subtraction = new Subtraction();
    subtraction.subtract(a);

    return subtraction.getResult();
  }
}
