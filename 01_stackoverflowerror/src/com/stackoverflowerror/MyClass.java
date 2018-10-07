package com.stackoverflowerror;

public class MyClass {

  public  int callmeCount = 0;

  private void callme() {
    callmeCount++;
    callme();
  }


  /*
   * main
   * param args
   * return void
   */
  public static void main(String[] args) {



    System.out.println("start ");

    MyClass testStack = new MyClass();


    try {
      testStack.callme();
    } catch (StackOverflowError e) {
      e.printStackTrace();
    }

    System.out.println("callmeCount =" + testStack.callmeCount);
    System.out.println("end ");
  }
}
