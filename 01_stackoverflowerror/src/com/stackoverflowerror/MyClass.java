package com.stackoverflowerror;

public class MyClass {

	public  int callmeCount = 0;

	private void callme () {
		callmeCount++;
		callme();
	}


	public static void main(String args[]){



		System.out.println("start ");

		MyClass testStack = new MyClass();


		try {
			testStack.callme();
		} catch (StackOverflowError e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println("callmeCount ="+testStack.callmeCount);
		System.out.println("end ");

	}


}
