package com.yanheng;

interface IDemoLambda1 {
	void print();
}

interface IDemoLambda2 {
	void print(String msg);
}

interface IDemoLambda3 {
	int add(int a, int b);
}

public class DemoLambda {

	public static void main(String[] args) {
		//inner class の実現
		func1(new IDemoLambda1() {

			@Override
			public void print() {
				System.out.println("before java 1.8 innerclass");
			}
		});
		//Lambda の実現
		func1(() -> {
			System.out.println("after java 1.8 lambda");
		});
		func1(() -> {
			System.out.println("after java 1.8 lambda");
			System.out.println("多数行");
		});
		//Lambda の実現
		func2((String msg) -> System.out.println(msg));
		func2((String msg) -> {
			msg = msg.toUpperCase();
			System.out.println(msg);
		});
		//Lambda の実現
		func3((a, b) -> a + b);
	}

	private static void func3(IDemoLambda3 iDemoLambda3) {
		System.out.println(iDemoLambda3.add(20, 30));
	}

	private static void func2(IDemoLambda2 iDemoLambda2) {
		iDemoLambda2.print("after java 1.8 lambda ");
	}

	private static void func1(IDemoLambda1 iDemoLambda) {
		iDemoLambda.print();
	}

}
