package com.yanheng;

public class DemoRuntime {

	public static void main(String[] args) throws Exception{
//		demo1();
//		demo2();
		demo3();
	}

	private static void demo3() {
		Runtime runtime = Runtime.getRuntime();
		long mem1,mem2 ,mem3;
		Integer someints[] = new Integer[1000];
		System.out.println("total memory is :"+runtime.totalMemory());
		mem1 = runtime.freeMemory();
		System.out.println("free memory is :"+mem1);
		runtime.gc();
		mem1 = runtime.freeMemory();
		System.out.println("free memory after gc is :"+mem1);
		for(int i=0;i<1000;i++)someints[i] = new Integer(i);
		mem2 = runtime.freeMemory();
		System.out.println("free memory after allocation is :"+mem2);
		System.out.println("memory used by allocation is :"+(mem1-mem2));

		for(int i=0;i<1000;i++)someints[i]=null;
		runtime.gc();
		mem3 = runtime.freeMemory();
		System.out.println("free memory after allocation is :"+mem3);
		System.out.println("memory used by allocation is :"+(mem3-mem2));
	}

	private static void demo1() {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("java仮想領域の空きメモリ："+runtime.freeMemory()/1024/1024);
		System.out.println("java仮想領域の最大可能メモリ："+runtime.maxMemory()/1024/1024);
		System.out.println("java仮想領域の総メモリ："+runtime.totalMemory()/1024/1024);
	}

	private static void demo2() throws Exception{
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec("C:\\Windows\\notepad.exe");
		System.out.println("start sleep");
		Thread.sleep(3000);
		process.destroy();
		System.out.println("stop sleep");
	}

}
