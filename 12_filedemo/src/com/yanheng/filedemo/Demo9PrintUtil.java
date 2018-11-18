package com.yanheng.filedemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * print util
 *
 * @author yanheng
 * 2018/11/18 13:52:47
 */
class PrintUtil {
	private final OutputStream outputStream;
	public PrintUtil(OutputStream outputStream) {
		this.outputStream = outputStream;
	}
	public void print(String string) {
		try {
			outputStream.write(string.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void print(int i) {
		this.print(String.valueOf(i));
	}
	public void print(double d) {
		this.print(String.valueOf(d));
	}
	public void println(String string) {
		try {
			outputStream.write( (string + "\n").getBytes() );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void println(int i) {
		println(String.valueOf(i));
	}
	public void println(double d) {
		println(String.valueOf(d));
	}
	public void close() {
		try {
			this.outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class Demo9PrintUtil {

	public static void main(String[] args) throws Exception {
		String printutil = "d:"+File.separator + "99_temp"+File.separator+"outputstream"+File.separator+"printutil.txt";

		String printstream = "d:"+File.separator + "99_temp"+File.separator+"outputstream"+File.separator+"printstream.txt";

		demoPrintStream(printstream);
		demoPrintUtil(printutil);
	}

	private static void demoPrintUtil(String filePath) throws Exception{
		PrintUtil printUtil = new PrintUtil(new FileOutputStream(new File(filePath)));
		printUtil.println("hello world shop !");
		printUtil.print("banana : ");
		printUtil.println(1.3);
		printUtil.print("apple : ");
		printUtil.print(1.8);
		printUtil.close();
	}

	private static void demoPrintStream(String filePath) throws Exception {
		PrintStream printUtil = new PrintStream(new FileOutputStream(new File(filePath)));
		printUtil.println("hello world shop !");
		printUtil.print("banana : ");
		printUtil.println(1.3);
		printUtil.print("apple : ");
		printUtil.println(1.8);
		printUtil.close();
	}

}
