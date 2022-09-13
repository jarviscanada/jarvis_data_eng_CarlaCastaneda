package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FibonacciNumberTest {
   FibonacciNumber fib;
  @Before

  public  void setup(){
    fib= new FibonacciNumber();

  }


  @Test
  public void fibRec() {

    assertEquals(5,fib.fibRec(5));

    assertEquals(832040,fib.fibRec(30));

  }

  @Test
  public void fibDynamic() {
    assertEquals(832040,fib.fibDynamic(30));
  }
}