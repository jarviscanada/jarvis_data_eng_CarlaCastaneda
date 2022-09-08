package ca.jrvs.practice.codingChallenge;

import java.util.Map;

public class CompareMaps {

  /**
   * Big-O: O(n)
   * Justification: equals implementation in Abstract MAP Iterates through maps comparing values to see if
   * they are equal
   */
  public <K,V> boolean compareMaps(Map<K,V> m1, Map<K,V> m2){
    Boolean b= m1.equals(m2);
    return b;

  }

}
