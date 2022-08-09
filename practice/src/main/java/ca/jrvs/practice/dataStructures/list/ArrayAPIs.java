package ca.jrvs.practice.dataStructures.list;
import java.util.Arrays;
import java.util.List;

public class ArrayAPIs {

  public static void main(String[] args) {
    int [] intArray=new int[10];
    intArray[0]=100;
    intArray[1]=200;
    intArray[2]=300;

    //different way to initialize an array
    int[] inlineArray={100,200,300};

    String[][] names={{
      "Mr,","Mrs.","Ms"},
        {"Smith","Jones"}
    };

    //copy array
    char[] copyFrom= {'d','e','c','a','f','f','e','i','n','a','t','e','d'};
    char[] copyTo=new char[7];

    System.arraycopy(copyFrom,2,copyTo,0,7);
    System.out.println(new String(copyTo));

    //convert an array to a List

    List<String> fruits= Arrays.asList("apple","strawberry");
    fruits= Arrays.asList(new String[]{"orange","banana"});
    for (String i:fruits){
      System.out.println(i +",");
    }

    //copy
    String[] fruitArray=new String[] {"mango","banana"};
    String[] anotherFruitArray= Arrays.copyOfRange(fruitArray,0,1);
    System.out.printf(Arrays.toString(anotherFruitArray));
    System.out.printf(anotherFruitArray.toString());

    //sort
    Arrays.sort(anotherFruitArray);
    Arrays.sort(fruitArray);
    System.out.println(Arrays.toString(fruitArray));

    //binarySearch
    int exact=Arrays.binarySearch(fruitArray,"banana");
    System.out.println(exact);

  }

}
