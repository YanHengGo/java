package com.yanheng.filedemo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * merge 2 files into 1
 *
 * @author yanheng
 *
 * 2018/11/18 5:42:04
 */
public class Demo8MergeFile {

	public static void main(String[] args) throws Exception{
		String files[] = {"demo.txt","demoInputstream.txt","writedemo.txt"};
		String directory = "d:"+File.separator+"99_temp"+File.separator+"outputstream"+File.separator;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		InputStream inputStream;
		int temp ;
		for(int i=0;i<files.length;i++) {
			inputStream = new FileInputStream(directory+files[i]);
			while( (temp = inputStream.read()) != -1 ) {
				outputStream.write(temp);
			}
			inputStream.close();
		}
		String mergeFileName = "mergeResult.txt";
		OutputStream mergeResult = new FileOutputStream(directory+mergeFileName);
		mergeResult.write(outputStream.toByteArray());
		mergeResult.close();
		outputStream.close();
	}
}
