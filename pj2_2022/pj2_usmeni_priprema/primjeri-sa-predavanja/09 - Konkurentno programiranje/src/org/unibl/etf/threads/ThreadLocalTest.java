package org.unibl.etf.threads;


public class ThreadLocalTest {  
    public static void main(String[] args) {  
         new Thread(new ParentThread("parent1")).start();  
         new Thread(new ParentThread("parent2")).start();  
    }  
}  
class TransactionManager {  
//    private static final ThreadLocal<Double> randomValue = new ThreadLocal<>();  
    private static final InheritableThreadLocal<Double> randomValue = new InheritableThreadLocal<>();
    public static void generateRandom() {  
         randomValue.set(Math.random()*1000);  
    }  
    public static Double getRandom() {  
         return randomValue.get();  
    }  
    public static void removeRandom() {  
         randomValue.remove();  
    }  
}  
class ParentThread implements Runnable {  
    private final String name;  
    ParentThread(String name) {  
         this.name = name;  
    }  
    @Override  
    public void run() {  
         TransactionManager.generateRandom();  
         System.out.println(name + " after start - " + TransactionManager.getRandom());  
         ChildThread child = new ChildThread("child " + name);  
         Thread childThread = new Thread(child);  
         childThread.start();  
         try {  
        	 childThread.join();  
         } catch (InterruptedException ex) {  
              Thread.currentThread().interrupt();  
         }  
         TransactionManager.removeRandom();  
         System.out.println(name + " after end - " + TransactionManager.getRandom());  
    }  
}  
class ChildThread implements Runnable {  
    private final String name;  
    ChildThread(String name) {  
         this.name = name;  
    }  
    @Override  
    public void run() {  
         System.out.println(name + " - " + TransactionManager.getRandom());  
    }  
}