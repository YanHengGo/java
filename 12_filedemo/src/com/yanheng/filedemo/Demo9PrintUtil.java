package com.yanheng.filedemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
	public void Print(String string) {
		try {
			outputStream.write(string.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void Print(int i) {
		this.Print(String.valueOf(i));
	}
	public void Print(double d) {
		this.Print(String.valueOf(d));
	}
	public void Println(String string) {
		try {
			outputStream.write( (string + "\n").getBytes() );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void Println(int i) {
		Println(String.valueOf(i));
	}
	public void Println(double d) {
		Println(String.valueOf(d));
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
		String filePath = "d:"+File.separator + "99_temp"+File.separator+"outputstream"+File.separator+"printutil.txt";
		PrintUtil printUtil = new PrintUtil(new FileOutputStream(new File(filePath)));
		printUtil.Println("hello world shop !");
		printUtil.Print("banana : ");
		printUtil.Println(1.3);
		printUtil.Print("apple : ");
		printUtil.Println(1.8);
		printUtil.close();
	}

}
