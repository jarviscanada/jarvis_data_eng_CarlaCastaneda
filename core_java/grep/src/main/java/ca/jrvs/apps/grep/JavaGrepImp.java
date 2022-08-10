package ca.jrvs.apps.grep;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;


public class JavaGrepImp implements JavaGrep {
  final Logger logger = LoggerFactory.getLogger(JavaGrepImp.class);
  private String regex;
  private String outFile;
  private String rootPath;

  public static void main(String[] args) {

    if (args.length!=3){
      throw new IllegalArgumentException("USAGE: JavaGrep regex rootPath outFile");
    }
    // BasicConfigurator.configure();
    JavaGrepImp javaGrepImp= new JavaGrepImp();
    javaGrepImp.setRegex(args[0]);
    javaGrepImp.setRootPath(args[1]);
    javaGrepImp.setOutFile(args[2]);

    try{
      javaGrepImp.process();
    } catch (Exception ex) {
      javaGrepImp.logger.error("Error: Unable to process", ex);


    }

  }


  @Override
  public void process() throws IOException {
    List<String> matchedLines = new ArrayList<>();

    List<File> Files = listFiles(rootPath);

    for (int i=0;i<Files.size();i++) {

      if (Files.get(i).isDirectory()) {

        List<File> childFile = listFiles(Files.get(i).getAbsolutePath());
        Files.addAll(childFile);


      } else {
        for (String line : readLines(Files.get(i))) {
          if (containsPattern(line)) {
            matchedLines.add(line);
          }

        }


      }



    }
    writeToFile(matchedLines);

  }

  @Override
  public List<File> listFiles(String rootDir) {

    List<File> allFiles= new ArrayList<File>();
    File dir= new File(rootDir);

    for (File file: dir.listFiles()){


       allFiles.add(file);


    }

    return allFiles;
  }

  @Override
  public List<String> readLines(File inputFile) {
    List<String> li=new ArrayList<>();

    try {
      BufferedReader reader = new BufferedReader (new FileReader(inputFile));
      String line = reader.readLine();
      while (line!=null){
        li.add(line);
        line=reader.readLine();
      }

    } catch(IOException e){
      e.printStackTrace();
    }




    return li;
  }

  @Override
  public boolean containsPattern(String line) {

    Pattern p= Pattern.compile(this.regex);
    Matcher m= p.matcher (line);
    boolean b = m.matches();
    return b;
  }

  @Override
  public void writeToFile(List<String> lines) throws IOException {

    File out=new File(this.outFile);
    out.createNewFile();
    BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(out));

    for (int i=0;i<lines.size();i++)
      bufferedWriter.write(lines.get(i) + "\r\n");
    bufferedWriter.close();



  }

  @Override
  public String getRootPath() {
    return this.rootPath;
  }

  @Override
  public void setRootPath(String rootPath) {
    this.rootPath=rootPath;

  }

  @Override
  public String getRegex() {

    return this.regex;
  }

  @Override
  public void setRegex(String regex) {
    this.regex= regex;

  }

  @Override
  public String getOutFile() {
    return this.getOutFile();
  }

  @Override
  public void setOutFile(String outFile) {
    this.outFile=outFile;

  }
}
