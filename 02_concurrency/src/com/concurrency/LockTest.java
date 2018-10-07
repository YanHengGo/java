package com.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest implements Runnable {

  public static ReentrantLock lock = new ReentrantLock();
  public static int count = 0;

  @Override
  public void run() {
    for (int i = 0;i < 100;i++) {
    	lock.lock();
    	try {
    		count++;
    	} finally {
    		lock.unlock();
    	}
    }
  }

  public static void main (String[] args) throws InterruptedException {
    LockTest t = new LockTest();
    Thread t1 = new Thread(t,"T1");
    Thread t2 = new Thread(t,"T1");

    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println(count);
  }




}
