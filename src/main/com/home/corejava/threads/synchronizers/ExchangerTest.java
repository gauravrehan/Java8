package com.home.corejava.threads.synchronizers;

import java.util.ArrayList;
import java.util.concurrent.Exchanger;
/*from  w  w w.  j  a  v a 2s  . com*/
class ExchangerProducer extends Thread {
  private Exchanger<ArrayList<Integer>> exchanger;
  private ArrayList<Integer> buffer = new ArrayList<Integer>();
  public ExchangerProducer(Exchanger<ArrayList<Integer>> exchanger) {
    this.exchanger = exchanger;
  }

  public void run() {
    while (true) {
      try {
        System.out.println("Producer.");
        Thread.sleep(1000);
        fillBuffer();
        System.out.println("Producer has produced and waiting:" + buffer);
        buffer = exchanger.exchange(buffer);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void fillBuffer() {
    for (int i = 0; i <= 3; i++) {
      buffer.add(i);
    }
  }
}

class ExchangerConsumer extends Thread {
  private Exchanger<ArrayList<Integer>> exchanger;
  private ArrayList<Integer> buffer = new ArrayList<Integer>();
  public ExchangerConsumer(Exchanger<ArrayList<Integer>> exchanger) {
    this.exchanger = exchanger;
  }

  public void run() {
    while (true) {
      try {
        System.out.println("Consumer.");
        buffer = exchanger.exchange(buffer);
        System.out.println("Consumer  has received:" + buffer);
        Thread.sleep(1000);
        System.out.println("eating:"+buffer);
        buffer.clear();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }  
}
public class ExchangerTest {
  public static void main(String[] args) {
    Exchanger<ArrayList<Integer>> exchanger = new Exchanger<>();
    ExchangerProducer producer = new ExchangerProducer(exchanger);
    ExchangerConsumer consumer = new ExchangerConsumer(exchanger);
    producer.start();
    consumer.start();
  }
}
