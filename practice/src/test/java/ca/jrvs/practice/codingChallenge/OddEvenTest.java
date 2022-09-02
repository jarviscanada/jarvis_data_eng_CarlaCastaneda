package ca.jrvs.practice.codingChallenge;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class OddEvenTest {
  private OddEven oddEven;
  @Before
  public void setup(){
    oddEven=new OddEven();


  }

  @Test
  public void oddEvenMod() {
    assertEquals(oddEven.oddEvenMod(234),"even");
    assertEquals(oddEven.oddEvenMod(33),"odd");



  }

//  @Test
//  public void oddEvenBit() {
//  }
}