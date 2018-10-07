package com.maxheap;

import java.util.Vector;

public class MaxHeapTest {

  public static void main(String[] args) {
    System.out.println("最大メモリ：" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");

    //test1();
    //test2();
    test3();
  }

  /*
   * -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
   */
  private static void test3() {
    // TODO 自動生成されたメソッド・スタブ

  }

  /*
   * -Xmx5M -Xms1M -XX:+PrintGCDetails
   */
  private static void test2() {
    // TODO 自動生成されたメソッド・スタブ
    Vector<Byte[]> v = new Vector<Byte[]>();
    for (int i = 0;i < 10;i++) {
      Byte[] b = new Byte[1024 * 1024];
      v.add(b);
      System.out.println("--------------");
      if (v.size() == 3) {
        v.clear();
        System.out.println("------clear--------");
      }
    }

  }

  /*
   * -Xss2M -Xmx5M
   */
  private static void test1() {
    // TODO 自動生成されたメソッド・スタブ
    Vector<Byte[]> v = new Vector<Byte[]>();
    for (int i = 0;i < 10;i++) {
      Byte[] b = new Byte[1024 * 1024];
      v.add(b);
      System.out.println((i + 1) + "M メモリ利用された");
    }
  }

}
