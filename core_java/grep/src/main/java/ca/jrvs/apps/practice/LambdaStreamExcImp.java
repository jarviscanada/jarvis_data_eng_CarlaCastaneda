package ca.jrvs.apps.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LambdaStreamExcImp implements LambdaStreamExc {

  public static void main(String[] args) {
    LambdaStreamExcImp obj = new LambdaStreamExcImp();
    Stream<String> result = obj.createStrStream("3", "3");
    result.forEach(x -> System.out.println(x));

    LambdaStreamExc lse = new LambdaStreamExcImp();
    Consumer<String> printer = lse.getLambdaPrinter("start>", "<end");
    printer.accept("Message body");

    String[] messages = {"a","b", "c"};
    lse.printMessages(messages, lse.getLambdaPrinter("msg:", "!") );

    lse.printOdd(lse.createIntStream(0, 6), lse.getLambdaPrinter("odd number:", "!"));
  }

  /**
   * create string stream from array
   *
   * @param strings
   * @return
   */
  @Override
  public Stream<String> createStrStream(String... strings) {
//    Stream<String>  strstream= Arrays.stream(strings);

    return Arrays.stream(strings);
  }

  @Override
  public Stream<String> toUpperCase(String... strings) {
    Stream<String> strStream = Arrays.stream(strings);
    strStream = strStream.map(x -> x.toUpperCase());

    return strStream;
  }

  @Override
  public Stream<String> filter(Stream<String> stringStream, String pattern) {

    return stringStream.filter(s -> !s.contains(s));

  }

  @Override
  public IntStream createIntStream(int[] arr) {
    return Arrays.stream(arr);
  }

  @Override
  public <E> List<E> toList(Stream<E> stream) {

    return stream.collect(Collectors.toList());
  }

  @Override
  public List<Integer> toList(IntStream intStream) {
    return intStream.boxed().collect(Collectors.toList());
  }

  @Override
  public IntStream createIntStream(int start, int end) {
    return IntStream.range(start,end);
  }

  @Override
  public DoubleStream squareRootIntStream(IntStream intStream) {
    return intStream.asDoubleStream().map(s->Math.sqrt(s));

  }

  @Override
  public IntStream getOdd(IntStream intStream) {
    return intStream.filter(s-> s%2!=0);
  }

  @Override
  public Consumer<String> getLambdaPrinter(String prefix, String suffix) {

    Consumer<String> c= (String message ) ->{
      System.out.println(prefix+message+suffix);

    };
    return c;
  }

  @Override
  public void printMessages(String[] messages, Consumer<String> printer) {

    for(String i:messages){
      printer.accept(i);



    }

  }

  @Override
  public void printOdd(IntStream intStream, Consumer<String> printer) {
//    int[] results=intStream.filter(i-> i%2!=0).toArray();

    intStream.filter(i-> i%2!=0).mapToObj(i-> String.valueOf(i)).forEach(i->printer.accept(i));

//
//    for (int i:results){
//      printer.accept(String.valueOf(i));
//    }


  }

  @Override
  public Integer[] square(int... ints) {
    Arrays.stream(ints).flatMap(s-> IntStream.of(s*s));
    return new Integer[0];

  }
}
