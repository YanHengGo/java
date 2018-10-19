package com.yanheng;

import java.util.HashMap;

import com.yanheng.util.L;

	interface MyTaskResult {
		void ticketSoldout(String threadName);
		void ticketRemain(String threadName);
	}

	interface ITicketBox {

	}

	class TicketBox implements Runnable {
		HashMap<String,Integer> saleDetail =  new HashMap();
		private int ticket = 5;

		@Override
		public void run() {
			for(int i =0 ; i<10 ; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				saleTicket();
			}
			L.d("完了　残チケット:"+ticket);
		}
		private synchronized void saleTicket() {
			if(ticket > 0 ) {
				ticket--;
				L.d("残チケット枚数は"+ticket+"枚");
			}
		}
	}

	class Mythread extends Thread {
		private MyTaskResult myTaskResult;
		public Mythread (TicketBox r, MyTaskResult myTaskResult,String threadName) {
			super(r);
			this.myTaskResult = myTaskResult;
			setName(threadName);
		}

		private int ticket = 5;
		@Override
		public void run() {
			super.run();
		}
	}

	class TaskNmae {
		public static String TASK_1 = "代理1";
		public static String TASK_2 = "代理2";
		public static String TASK_3 = "代理3";
	}

	public class ThreadSample {

		public static void main(String[] args) {
			TicketBox ticketBox = new TicketBox();
			Mythread mythread1 = new Mythread(ticketBox,myTaskResult,TaskNmae.TASK_1);
			Mythread mythread2 = new Mythread(ticketBox,myTaskResult,TaskNmae.TASK_2);
			Mythread mythread3 = new Mythread(ticketBox,myTaskResult,TaskNmae.TASK_3);
			L.d("チケット販売開始");
			mythread1.start();
			mythread2.start();
			mythread3.start();
		}
		static MyTaskResult myTaskResult = new MyTaskResult() {

			@Override
			public void ticketSoldout(String threadName) {
				L.d("お疲れ様です。"+threadName);
			}

			@Override
			public void ticketRemain(String threadName) {
				L.d("終わっていないの？"+threadName);
			}
		};
	}
