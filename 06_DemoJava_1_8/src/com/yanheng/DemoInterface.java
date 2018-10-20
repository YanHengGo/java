package com.yanheng;

	interface DemoStatic {
		static void outputInfo () {
			System.out.println("this is demo 'static' ");
		}
	}
	
	interface DemoDefault{
		default void fun() {
			System.out.println("this is demo 'default'");
		}
	}
	
	/**
	 * @author yanheng
	 */
	class DemoClass implements DemoDefault {
	
	}
	
	public class DemoInterface {
	
		public static void main(String[] args) {
			//1 static
			DemoStatic.outputInfo();
			//2 default
			DemoDefault demoClass = new DemoClass();
			demoClass.fun();
	
		}
	
	}
