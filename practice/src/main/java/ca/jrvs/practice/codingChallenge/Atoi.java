package ca.jrvs.practice.codingChallenge;

public class Atoi {
  int MIN_VALUE=(int) -(Math.pow(2,31));
  int MAX_VALUE= (int) (Math.pow(2,31))-1;

  /**
   * BIG O NOTATION: O()
   * @param s
   * @return
   */
  public int myAtoi(String s) {
    StringBuilder result=new StringBuilder();

    for (int i=0; i<s.length();i++){
      if (s.charAt(i)!= ' '){
        if (s.charAt(i)== '-'){
          result.append('-');

        }else if (s.charAt(i)=='+'){
          result.append("+");
        }
        else if (Character.isDigit(s.charAt(i))){
          result.append(s.charAt(i));
        }
        else{
          break;
        }
      }

    }

    Long response= Long.parseLong(result.toString());
    int final_response;

    if (response<MIN_VALUE){
      final_response= MIN_VALUE;
      System.out.println(MIN_VALUE);

    }
    else if(response> MAX_VALUE){
      final_response=MAX_VALUE;
      System.out.println(MAX_VALUE);


    }
    else{
      final_response=Math.toIntExact(response);
    }
    return final_response;
  }

  /**
   * Big O notation: O(N)
   * @param s
   * @return
   */


  public int rawAtoi(String s){

    boolean neg=false;
    boolean overflow= false;
    int num=0;

    for (char i: s.toCharArray()){

      if (i>47 && i<58){

        int current=((int)i-48);
        int mins=(MIN_VALUE)+(num*10);

        if (((int)i-48)>(MAX_VALUE-(num*10))){
          num=MAX_VALUE;
          overflow=true;
          break;

        }else if (current< mins ){
          num= MIN_VALUE;
          break;

        }
        else{
          num=num*10+((int)i-48);
        }

      }else if (i==45){
        neg= true;
      }

    }
    if (neg==true){
      num=(~(num-1));


    }



    return num;
  }

  public static void main(String[] args) {
    Atoi a= new Atoi();
//    System.out.println(a.myAtoi("-123456776665"));
    System.out.println(a.MAX_VALUE);
    System.out.println(a.rawAtoi("-1204389849204240434342434353454354354354353454354398"));

  }


}
