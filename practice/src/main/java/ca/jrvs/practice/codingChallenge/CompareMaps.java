package ca.jrvs.practice.codingChallenge;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

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
  /**
   * Big-O:
   * Justification:
   */
  public <K,V> boolean equals(Map<K,V> m1,Map<K,V>m2){
    if (m1==m2){
      return true;
    }
    if (m1 instanceof Map.Entry<?,?> && m2 instanceof Map.Entry<?,?>){
      if (Objects.equals(((Entry<?, ?>) m1).getKey(),((Entry<?, ?>) m2).getKey()) &&
          Objects.equals(((Entry<?, ?>) m1).getValue(),((Entry<?, ?>) m2).getValue()))
        return true;

    }

    return false;
  }

}
