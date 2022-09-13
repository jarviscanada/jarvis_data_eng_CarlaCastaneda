package ca.jrvs.practice.codingChallenge;

public class Atoi {
  public int stringToInt(String s){
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
    int response= Integer.valueOf(result.toString());

    if (response<-(Math.pow(2,31))){
      response= (int)-(Math.pow(2,31));
      System.out.println((-2^(31)));

    }
    else if(response>(Math.pow(2,31))-1){
      response=(int)(Math.pow(2,31))-1;

    }
//    System.out.println(-(Math.pow(2,31)));
//    System.out.println((Math.pow(2,31))-1);

    return response;
  }

  public static void main(String[] args) {
    Atoi atoi= new Atoi();

    int result=atoi.stringToInt("-42");
    System.out.println(result);
  }


}
