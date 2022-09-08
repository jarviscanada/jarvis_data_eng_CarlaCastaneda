package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class CompareMapsTest {

  @Test
  public void compareMaps() {
    CompareMaps c= new CompareMaps();
    Map<String,String> m1= new HashMap<>();
    Map<String,String> m2= new HashMap<>();

    m1.put("hi","bye");
    m2.put("hi","bye");
    m2.put("secret","my name is carla");
    m1.put("secret", "my name is johnny");
    m1.put("secret","my name is carla");
    m1.put("dairy","my name is carla");


    assertEquals(false,c.compareMaps(m1,m2));





  }
}