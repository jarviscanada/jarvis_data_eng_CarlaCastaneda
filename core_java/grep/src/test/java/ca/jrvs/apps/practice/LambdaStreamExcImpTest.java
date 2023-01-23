package ca.jrvs.apps.practice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class LambdaStreamExcImpTest {
  LambdaStreamExcImp obj= new LambdaStreamExcImp();
  Stream <String> testing= Stream.of("3","3");

  @Test
  void createStrStream() {
    assertEquals(testing,obj.createStrStream(new String[]{"3", "3"}));
  }
}
