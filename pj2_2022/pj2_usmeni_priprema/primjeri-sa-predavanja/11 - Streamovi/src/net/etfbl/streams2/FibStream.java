package net.etfbl.streams2;

import java.util.List;
import java.util.stream.*;


public class FibStream {
  
  public static Stream<Long> makeFibStream() {
    return(Stream.generate(new FibonacciMaker()));
  }
    
  public static Stream<Long> makeFibStream(int numFibs) {
    return(makeFibStream().limit(numFibs));
  }
    
  public static List<Long> makeFibList(int numFibs) {
    return(makeFibStream(numFibs).collect(Collectors.toList()));
  }
    
  public static Long[] makeFibArray(int numFibs) {
    return(makeFibStream(numFibs).toArray(Long[]::new));
  } 
  
  private FibStream() {} // Uninstantiatable class
}
