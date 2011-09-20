package de.bitnoise.aufgabe.model;

import static org.junit.Assert.*;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class AufgabeTest
{
  @ClassRule
  public static TestRule x = new TestRule()
  {
    public Statement apply(final Statement base, final Description description)
    {
      return new Statement()
      {
        @Override
        public void evaluate() throws Throwable
        {
          System.out.println("starting");
          try
          {
            base.evaluate();
            System.out.println("succeeded");
          }
          catch (Throwable t)
          {
            System.out.println("fail");
            throw t;
          }
          finally
          {
            System.out.println("fin");
          }
        }
      };
    }
  };

  @Test
  public void test1()
  {
    System.out.println("1 ");
  }

  @Test
  public void test2()
  {
    System.out.println("2 ");
  }

}
