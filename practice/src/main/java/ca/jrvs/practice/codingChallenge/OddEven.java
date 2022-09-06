package ca.jrvs.practice.codingChallenge;

/**
 * https://www.notion.so/jarvisdev/Sample-Check-if-a-number-is-even-or-odd-5986857171e24b2482ac30c04de246d9
 */
public class OddEven {


  public String oddEvenMod(int i){
    return i%2==0 ? "even":"odd";

  }

  /**
   * since an odd number ends in 1 in binary
   * @param i
   * @return
   */
  public String oddEvenBit(int i){


    return (i & 1)!=1 ? "even":"odd";
  }

}
