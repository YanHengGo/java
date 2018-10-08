package com.concurrency;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest2 implements Runnable{

	public static ReentrantLock lock1 = new ReentrantLock();
	public static ReentrantLock lock2 = new ReentrantLock();

	private final int lock;
	public LockTest2(int lock) {
		this.lock = lock;
	}

	/**
	 * 中断されるロック InterruptedException
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		LockTest2 r1 = new LockTest2(1);
		LockTest2 r2 = new LockTest2(2);

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		DaemonThread.check();
	}

	@Override
	public void run() {
		try {
			if (lock == 1) {
				lock1.lockInterruptibly();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock2.lockInterruptibly();
			} else {
				lock2.lockInterruptibly();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock1.lockInterruptibly();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if(lock1.isHeldByCurrentThread()) {
				lock1.unlock();
			}
			if(lock2.isHeldByCurrentThread()) {
				lock2.unlock();
			}
			System.out.println(Thread.currentThread().getId() + ":Thread id");
		}
	}

	static class DaemonThread {
		private final static ThreadMXBean threadMXbean = ManagementFactory.getThreadMXBean();
		public static void check() {
			Thread t = new Thread(daemonThread);
			t.setDaemon(true);
			t.start();
		}
		final static Runnable daemonThread = new Runnable () {

			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				while (true) {
					long[] deadLockedThreadIds = threadMXbean.findDeadlockedThreads();
					if(deadLockedThreadIds != null) {
						ThreadInfo[] threadInfos=threadMXbean.getThreadInfo(deadLockedThreadIds);
						for(Thread t:Thread.getAllStackTraces().keySet()) {
							for(int i=0;i<threadInfos.length ; i++) {
								if (t.getId() == threadInfos[i].getThreadId()) {
									t.interrupt();
								}
							}
						}
					}
				}
			}

		};
	}

}
