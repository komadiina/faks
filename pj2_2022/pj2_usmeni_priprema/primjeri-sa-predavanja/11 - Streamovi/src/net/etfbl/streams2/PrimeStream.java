package net.etfbl.streams2;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.*;

public class PrimeStream {

  public static Stream<BigInteger> makePrimeStream(int numDigits) {
    return(Stream.iterate(Primes.findPrime(numDigits), Primes::nextPrime));
  }

  public static Stream<BigInteger> makePrimeStream(int numDigits, int numPrimes) {
    return(makePrimeStream(numDigits).limit(numPrimes));
  }

  public static List<BigInteger> makePrimeList(int numDigits, int numPrimes) {
    return(makePrimeStream(numDigits, numPrimes).collect(Collectors.toList()));
  }
  
  public static BigInteger[] makePrimeArray(int numDigits, int numPrimes) {
    return(makePrimeStream(numDigits, numPrimes).toArray(BigInteger[]::new));
  } 
  
  private PrimeStream() {}
}
