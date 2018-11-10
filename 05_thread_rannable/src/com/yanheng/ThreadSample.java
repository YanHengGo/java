package com.yanheng;

import java.util.HashMap;

import com.yanheng.util.L;

interface MyTaskResult {
	void taskDone(String threadName);
}

interface ITicketBox {

	void sendResult(HashMap<String, Integer> saleDetail, int ticket, int sUM_TICKET);

}

class TicketBox implements Runnable {
	HashMap<String, Integer> saleDetail = new HashMap<String, Integer>();
	private final int SUM_TICKET = 5;
	private int remainTicket = SUM_TICKET;
	private ITicketBox iTicketBox;

	public TicketBox(ITicketBox iTicketBox) {
		this.iTicketBox = iTicketBox;
		saleDetail.put(TaskNmae.TASK_1, 0);
		saleDetail.put(TaskNmae.TASK_2, 0);
		saleDetail.put(TaskNmae.TASK_3, 0);
	}

	@Override
	public void run() {
		//2.3 チケット販売開始
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			saleTicket();
		}
	}
	public void sendResult() {
		//4.2 チケット販売終了　結果まとめ
		this.iTicketBox.sendResult(saleDetail, remainTicket, SUM_TICKET);
	}
	// 2.4 チケット販売開始 同期化処理
	private synchronized void saleTicket() {
		if (remainTicket > 0) {
			String taskName = Thread.currentThread().getName();
			int count = saleDetail.get(taskName);
			count++;
			saleDetail.put(taskName, count);
			remainTicket--;
			L.d("残チケット枚数は" + remainTicket + "枚");
		}
	}
}

class Mythread extends Thread {
	private MyTaskResult myTaskResult;
	public Mythread(TicketBox r, MyTaskResult myTaskResult, String threadName) {
		super(r);  //1.3　販売処理セットする
		this.myTaskResult = myTaskResult;
		setName(threadName);
	}
	@Override
	public void run() {
		super.run();  //2.2　チケット販売開始
		//3.1 チケット販売終了
		myTaskResult.taskDone(getName());
	}
}

class TaskNmae {
	public static String TASK_1 = "代理1";
	public static String TASK_2 = "代理2";
	public static String TASK_3 = "代理3";
}

public class ThreadSample {
	private static TicketBox ticketBox;

	public static void main(String[] args) {
		//1.1　準備　チケットボックス用意
		ticketBox = new TicketBox(iTicketBox);
		//1.2　準備　販売代理　３人用意
		Mythread mythread1 = new Mythread(ticketBox, myTaskResult, TaskNmae.TASK_1);
		Mythread mythread2 = new Mythread(ticketBox, myTaskResult, TaskNmae.TASK_2);
		Mythread mythread3 = new Mythread(ticketBox, myTaskResult, TaskNmae.TASK_3);
		L.d("チケット販売開始");
		//2.1　チケット販売開始
		mythread1.start();
		mythread2.start();
		mythread3.start();
	}
	static String taskDoneName = "";
	static MyTaskResult myTaskResult = new MyTaskResult() {

		@Override
		public void taskDone(String threadName) {
			//3.2 チケット販売終了
			L.d("お疲れ様です。"+threadName);
			taskDoneName += threadName;
			if(taskDoneName.indexOf(TaskNmae.TASK_1)<0)return;
			if(taskDoneName.indexOf(TaskNmae.TASK_2)<0)return;
			if(taskDoneName.indexOf(TaskNmae.TASK_3)<0)return;
			L.d("----------------全部完了　報告----------------------------");
			//4.1 チケット販売終了　結果まとめ
			ticketBox.sendResult();
		}
	};
	static ITicketBox iTicketBox = new ITicketBox() {

		@Override
		public void sendResult(HashMap<String, Integer> saleDetail, int remainTicket, int sumTicket) {
			//4.3 チケット販売終了　結果まとめ
			L.d("全チケット数は："+ sumTicket);
			L.d("残チケットは："+remainTicket);
			L.d(TaskNmae.TASK_1+"販売結果:"+saleDetail.get(TaskNmae.TASK_1));
			L.d(TaskNmae.TASK_2+"販売結果:"+saleDetail.get(TaskNmae.TASK_2));
			L.d(TaskNmae.TASK_3+"販売結果:"+saleDetail.get(TaskNmae.TASK_3));
		}
	};
}
