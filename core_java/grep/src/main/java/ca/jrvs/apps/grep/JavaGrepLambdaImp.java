package ca.jrvs.apps.grep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaGrepLambdaImp extends JavaGrepImp {

  public static void main(String[] args) {
    JavaGrepLambdaImp javaGrepLambdaImp= new JavaGrepLambdaImp();
    javaGrepLambdaImp.setRegex(args[0]);
    javaGrepLambdaImp.setRootPath(args[1]);
    javaGrepLambdaImp.setOutFile(args[2]);

    try{
      javaGrepLambdaImp.process();
    } catch (Exception ex){
      ex.printStackTrace();
    }



  }
  @Override
  public List<String> readLines(File inputFile){
    List<String> readLines=new ArrayList<>();
    try{
      BufferedReader bf= new BufferedReader(new FileReader(inputFile));

      readLines= bf.lines().collect(Collectors.toList());
      bf.close();



    }catch (IOException e){
      e.printStackTrace();

    }


    return readLines;
  }

  @Override
  public List<File> listFiles(String rootDir){
    List<File> listOfFiles= new ArrayList<File>();
    File dir = new File(rootDir);


    Arrays.stream(dir.listFiles()).forEach(i-> {listOfFiles.add(i); System.out.println("hi in lambda function");});




    return listOfFiles;
  }

  @Override
  public void writeToFile(List<String> lines) throws IOException {
    File out = new File(this.getOutFile());
    out.createNewFile();
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(out));
    lines.stream().forEach(i-> {
      try {
        bufferedWriter.write(i +  "\r\n");
        System.out.println("im in the lambda write to file");
      } catch (IOException e) {
        throw new RuntimeException(e);
      }

    });
    bufferedWriter.close();



  }


}
