package com.yanheng.filedemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * java.io.InputStreamReader;
 * java.io.OutputStreamWriter;
 *
 * @author yanheng
 *
 * 2018/11/18 4:46:36
 */
public class InputStreamReaderDemo {

	public static void main(String[] args) throws Exception{
		// TODO 自動生成されたメソッド・スタブ
		File file = new File("d:"+File.separator + "99_temp"+File.separator + "outputstream"+File.separator+"demoInputstream.txt");
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		demo1(file);
		demo2(file);
	}

	/**
	 * OutputStreamWriter
	 *
	 * @param file
	 * @throws Exception
	 */
	private static void demo1(File file) throws Exception{
		OutputStream outputStream = new FileOutputStream(file);
		Writer outputStreamWriter = new OutputStreamWriter(outputStream);
		String str = "this is outputStreamWriter";
		outputStreamWriter.write(str);
		outputStreamWriter.close();
		outputStream.close();
	}

	/**
	 * InputStreamReader
	 * @param file
	 * @throws Exception
	 */
	private static void demo2(File file) throws Exception {
		InputStream inputStream = new FileInputStream(file);
		Reader inputStreamReader = new InputStreamReader(inputStream);
		char[] ch = new char[1024];
		int size= inputStreamReader.read(ch);
		inputStreamReader.close();
		inputStream.close();
		System.out.println(new String(ch,0,size));
	}

}
