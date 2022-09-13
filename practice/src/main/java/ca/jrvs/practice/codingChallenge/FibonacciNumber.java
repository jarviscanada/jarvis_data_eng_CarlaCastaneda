package ca.jrvs.practice.codingChallenge;

public class FibonacciNumber {

  /**
   * Big O(n): O(2^n)
   * Justification: time it takes to find fibonacci number
   * grows exponentially
   */

  public int fibRec (int i) {
    if (i==1){
      return 1;
    }
    else if (i==0){
      return 0;
    }
    else{
      return fibRec(i-1)+fibRec(i-2);
    }

  }

  /**
   * Big-O: O(n)
   * Justification: Dynamic programming approach
   */
  public int fibDynamic(int n){
    int size=n+1;
    int [] arrayInt= new int[size];
    arrayInt[0]=0;
    arrayInt[1]=1;
    for(int i=2;i<size;i++){
      arrayInt[i]=arrayInt[i-1]+arrayInt[i-2];

    }
    return arrayInt[size-1];

  }


}
