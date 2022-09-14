package ca.jrvs.practice.codingChallenge;

public class Atoi {
  int MIN_VALUE=(int) -(Math.pow(2,31));
  int MAX_VALUE= (int)(Math.pow(2,31)-1);
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

  public static void main(String[] args) {
    Atoi a= new Atoi();
    System.out.println(a.myAtoi("-123456776665"));
  }


}
