package calc;

import calc.operations.Adder;
import calc.operations.Subtraction;
import calc.operations.Division;
import calc.operations.Multiplication;
import calc.operations.Binary;

public class Calculator
{
  public int sum(int... a)
  {
    Adder adder = new Adder();

    for(int i:a)
    {
      adder.add(i);
    }

    return adder.getResult();
  }

  public int div(int b, int... a)
  {
    Division division = new Division(b);

    for(int i:a)
    {
      division.div(i);
    }

    return division.getResult();
  }

  public int subtract(int b, int... a)
  {
    Subtraction subtraction = new Subtraction(b);

    for(int i:a)
    {
      subtraction.subtract(i);
    }

    return subtraction.getResult();
  }

  public int multi(int... a)
  {
    Multiplication multiplication = new Multiplication();

    for(int i:a)
    {
      multiplication.multi(i);
    }

    return multiplication.getResult();
  }

  public int binary(int a)
  {
    Binary binary = new Binary();
    binary.binary(a);
    
    return binary.getResult();
  }
}
