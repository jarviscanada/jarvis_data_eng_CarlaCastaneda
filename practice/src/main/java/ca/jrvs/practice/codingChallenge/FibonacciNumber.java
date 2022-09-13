package ca.jrvs.practice.codingChallenge;

public class FibonacciNumber {

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

}
