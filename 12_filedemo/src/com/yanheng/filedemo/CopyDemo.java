package com.yanheng.filedemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * FileoutputStream と FileInputStreamを利用して、
 * 既存画像ファイルをコピーする
 *
 * @author yanheng
 */
public class CopyDemo {

	public static void main(String[] args) throws Exception{
		File from_picture = new File("d:"+File.separator+"99_temp"+File.separator+"copydemo"+File.separator+"from_picture.png");
		File to_picture = new File("d:"+File.separator+"99_temp"+File.separator+"copydemo"+File.separator+"to_picture.png");
		if(!from_picture.getParentFile().exists()) {
			from_picture.getParentFile().mkdirs();
		}
		if(!to_picture.getParentFile().exists()) {
			to_picture.getParentFile().mkdirs();
		}
		OutputStream outputStream = new FileOutputStream(to_picture);
		InputStream inputStream = new FileInputStream(from_picture);
		System.out.println("開始");
		long start = System.currentTimeMillis();
//		copy1(outputStream , inputStream);
		copy2(outputStream , inputStream);
		outputStream.close();
		inputStream.close();
		System.out.println("終了 合計時間＝"+(System.currentTimeMillis()-start) + "ミリ秒");
	}

	private static void copy2(OutputStream outputStream, InputStream inputStream) throws Exception{
		byte[] bt = new byte[1024];
		int size ;
		while ( (size = inputStream.read(bt)) != -1 ) {
			outputStream.write(bt, 0, size);
		}
	}

	private static void copy1(OutputStream outputStream, InputStream inputStream) throws Exception{
		int temp ;
		while ((temp = inputStream.read())!=-1) {
			outputStream.write((byte)temp);
		}
	}

}
