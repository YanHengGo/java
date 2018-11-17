package com.yanheng.filedemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * java.io.FileInputStream;
 * java.io.FileOutputStream;
 * `
 * テキストはファイル保存
 * 保存内容吐き出す
 *
 * @author yanheng
 */
public class OutputStreamDemo {

	public static void main(String[] args) throws Exception {
		File file = new File("d:"+File.separator+"99_temp"+File.separator + "outputstream"+File.separator+"demo.txt");
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		demoOutputStream1(file);
		demoOutputStream2(file);
		demoOutputStream3(file);
		demoInputStream1(file);
		demoInputStream2(file);
	}

	private static void demoInputStream2(File file) throws Exception{
		int temp = 0 , index = 0;
		byte [] bs = new byte[1024];
		InputStream inputStream = new FileInputStream(file);
		while((temp = inputStream.read())!=-1) {
			bs[index++]=(byte)temp;
		}
		inputStream.close();
		System.out.println(new String(bs));
	}
	private static void demoInputStream1(File file) throws Exception{
		InputStream inputStream = new FileInputStream(file);
		byte[] bs = new byte[1024];
		inputStream.read(bs);
		inputStream.close();
		System.out.println(new String(bs));
	}

	static String nextLine = "\r\n";
	private static void demoOutputStream1(File file) throws Exception {
		String string = "output stream demo1";
		OutputStream output = new FileOutputStream(file);  //既存内容削除
		output.write(string.getBytes());
		output.write(nextLine.getBytes());
		output.close();
	}
	private static void demoOutputStream2(File file) throws Exception{
		String string = "output stream demo2 ";
		OutputStream output = new FileOutputStream(file , true);  //内容追加
		output.write(string.getBytes() , 0 , 10);
		output.write(nextLine.getBytes());
		output.close();
	}
	private static void demoOutputStream3(File file) throws Exception{
		String string = "output stream demo3 ";
		OutputStream output = new FileOutputStream(file , true);  //内容追加
		byte[] byte1 = string.getBytes();
		for (int i =0;i<byte1.length ;i++) {
			output.write(byte1[i]);
		}
		output.write(nextLine.getBytes());
		output.close();
	}

}
