package ca.jrvs.apps.grep;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;



public class JavaGrepImp implements JavaGrep {
  final Logger logger = LoggerFactory.getLogger(JavaGrepImp.class);
  private String regex;
  private String outFile;
  private String rootPath;

  public static void main(String[] args) {

    if (args.length!=3){
      throw new IllegalArgumentException("USAGE: JavaGrep regex rootPath outFile");
    }
    JavaGrepImp javaGrepImp= new JavaGrepImp();
    javaGrepImp.setRegex(args[0]);
    javaGrepImp.setRootPath(args[1]);
    javaGrepImp.setOutFile(args[2]);

    BasicConfigurator

    javaGrepImp.logger.error("Error: Unable to process", ex);

  }


}
