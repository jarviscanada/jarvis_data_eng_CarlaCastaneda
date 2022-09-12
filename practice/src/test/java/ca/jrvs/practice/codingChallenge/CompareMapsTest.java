package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class CompareMapsTest {
  static CompareMaps c;
  static Map<String,String> m1;
  static Map<String,String> m2;
  @BeforeClass
  public static void setup(){
    c = new CompareMaps();
    m1 = new HashMap<>();
    m2 = new HashMap<>();

    m1.put("hi","bye");
    m2.put("hi","bye");
    m2.put("secret","my name is carla");
    m1.put("secret", "my name is johnny");
    m1.put("secret","my name is carla");
    m1.put("dairy","my name is carla");
    m2.put("dairy","my name is carla");


  }

  @Test
  public void compareMaps() {


    assertEquals(true,c.compareMaps(m1,m2));


  }
  public void equals(){


    assertEquals(true,c.equals(m1,m2));



  }
}