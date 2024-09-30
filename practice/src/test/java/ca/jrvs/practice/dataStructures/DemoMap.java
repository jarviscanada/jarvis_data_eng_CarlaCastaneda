package ca.jrvs.practice.dataStructures;

import java.util.HashMap;
import org.junit.Test;
public class DemoMap  {
  @Test
  public void demo(){
    HashMap<String,Integer> map = new HashMap<>();
    String bob = "Bob";
    System.out.println(bob.hashCode());
    map.put(bob,25);
    System.out.println(map.get(bob));

  }

}