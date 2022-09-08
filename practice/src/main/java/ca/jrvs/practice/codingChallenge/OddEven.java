package ca.jrvs.practice.codingChallenge;

/**
 * https://www.notion.so/jarvisdev/Sample-Check-if-a-number-is-even-or-odd-5986857171e24b2482ac30c04de246d9
 */
public class OddEven {

  /**
   * BIG-O: O(1)
   * Justification: it is an arithmetic operation
   * @param i int number input
   * @return even or odd
   */

  public String oddEvenMod(int i){
    return i%2==0 ? "even":"odd";

  }

  /**
   * BIG-O: O(1)
   * Justification: it is a boolean operation
   *
   * since an odd number ends in 1 in binary, using and operation will result in 1 number is  odd or 0 if the number is even
   * @param i int number input
   * @return even or odd
   */
  public String oddEvenBit(int i){


    return (i & 1)!=1 ? "even":"odd";
  }

}
