package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TwoSumTest {

  TwoSum ts;

  @Before
  public void setup() {
    ts = new TwoSum();

  }

  @Test
  public void twoSum() {
    int[] nums = {3, 2, 4};
    int target = 6;

    assertArrayEquals(new int[]{1,2}, ts.twoSum(nums, target));

  }

  @Test
  public void twoSumHashMap() {
    int[] nums = {3, 2, 4};
    int target = 6;

    assertArrayEquals(new int[]{2,1}, ts.twoSumHashMap(nums, target));
  }
}