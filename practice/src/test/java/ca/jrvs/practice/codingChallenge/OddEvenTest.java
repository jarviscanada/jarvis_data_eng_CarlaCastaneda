package ca.jrvs.practice.codingChallenge;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class OddEvenTest {
  private OddEven oddEven;
  @Before
  public void setup(){
    oddEven =new OddEven();


  }

  @Test
  public void oddEvenMod() {
    assertEquals(oddEven.oddEvenMod(234),"even");
    assertEquals(oddEven.oddEvenMod(33),"odd");



  }

  @Test
  public void oddEvenBit() {
    assertEquals(oddEven.oddEvenBit(14),"even");
    assertEquals(oddEven.oddEvenBit(456),"even");
    assertEquals(oddEven.oddEvenBit(100),"even");

    assertEquals(oddEven.oddEvenBit(15),"odd");
    assertEquals(oddEven.oddEvenBit(4367),"odd");
    assertEquals(oddEven.oddEvenBit(1003),"odd");



  }
}