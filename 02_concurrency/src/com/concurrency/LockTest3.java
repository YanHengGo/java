package com.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest3 implements Runnable{

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		LockTest3 lockTest3 = new LockTest3();
		Thread thread1 = new Thread(lockTest3);
		Thread thread2 = new Thread(lockTest3);

		thread1.start();
		thread2.start();

	}
	public static ReentrantLock lock = new ReentrantLock();
	@Override
	public void run() {
		// TODO 自動生成されたメソッド・スタブ
		try {
			if(lock.tryLock(5, TimeUnit.SECONDS)) {
				Thread.sleep(6000);
			} else {
				System.out.println(" 取得失敗 ");
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}

	}


}
