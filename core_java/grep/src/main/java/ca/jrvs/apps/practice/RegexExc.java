package ca.jrvs.apps.practice;

public interface RegexExc {

  /**
   * return trueif filename extension is jpg or jpeg ( case insensitive)
   * @param filename
   * @return
   */
  public boolean matchJpeg(String filename);

  /**
   * return true if ip is valid
   * @param ip
   * @return
   */
  public boolean matchIp(String ip);

  /**
   * return true if line is empty (e.g. empty, write, white space, tabs, etc...)
   * @param line
   * @return
   */
  public boolean isEmptyLine(String line);


}