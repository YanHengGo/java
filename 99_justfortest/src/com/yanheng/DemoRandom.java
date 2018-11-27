package com.yanheng;

import java.util.Random;

public class DemoRandom {

	private static final Random rnd = new Random();

	static int random (int n ) {
		return Math.abs(rnd.nextInt())%n;
	}

	public static void main(String[] args) {
		demo1();
	}

	private static void demo1() {
		int n = 2 * (Integer.MAX_VALUE /3 );
		System.out.println("n="+n);
		int low=0;
		for (int i =0;i<1000000;i++) {
			if(random(n)<n/2) {
				low++;
			}
		}
		System.out.println("low="+low);
	}


}
