package ca.jrvs.apps.practice;

import java.util.regex.*;
public class RegexExcImp implements RegexExc{


  /**
   * return trueif filename extension is jpg or jpeg ( case insensitive)
   * @param filename
   * @return
   */
  public boolean matchJpeg(String filename){
    Pattern p= Pattern.compile("(?i).+(\\.jpg|\\.jpeg)$");
    Matcher m= p.matcher (filename);
    boolean b = m.matches();
    return b;
  }

  /**
   * return true if ip is valid
   *  to implify the problem, IP address range is from 0.0.0.0 to 999.999.999.999
   * @param ip
   * @return
   */
  public boolean matchIp(String ip){


    Pattern p= Pattern.compile("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}");
    Matcher m= p.matcher (ip);
    boolean b = m.matches();
    return b;
  }

  /**
   * return true if line is empty (e.g. empty, write, white space, tabs, etc...)
   * @param line
   * @return
   */
  public boolean isEmptyLine(String line){

    Pattern p= Pattern.compile("^\\s*$");
    Matcher m= p.matcher (line);
    boolean b = m.matches();
    return b;
  }

  public static void main (String args[]) {
    RegexExcImp test = new RegexExcImp();

    boolean returnedval = test.matchJpeg("loli.JPEG");
    System.out.println(returnedval);

    boolean IPadd = test.matchIp("01.10.10.09");
    boolean emptyspace = test.isEmptyLine("   njnjknkj");
  }


}
