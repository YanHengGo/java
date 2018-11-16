package com.yanheng.filedemo;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo {

	/**
	 * 問題１、windowsとlinuxの互換性のため、File.separatorを利用する
	 * 問題２、File作成は遅延がある
	 *
	 *
	 */


	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("hello world!");
		demoFile();
		demoFile2();
		demoFile3();
		demoFile4();

	}

	private static void demoFile4() {
		File file = new File("D:\\workspace\\05_opensource");
		printlist(file);
	}

	private static void printlist(File file) {
		if(file == null || !file.exists()) {
			return;
		}
		File children[] = file.listFiles();
		for(int i=0;i<children.length;i++) {
			if(children[i]==null)return;
			if(children[i].isFile()) {
				System.out.println(children[i]);
			}
			if(children[i].isDirectory()) {
				System.out.println(children[i]);
				printlist(children[i]);
			}
		}
	}

	private static void demoFile3() {
		File file = new File("d:"+File.separator+"99_temp");
		if(file.exists() && file.isDirectory()) {
			File [] files = file.listFiles();
			for(int i=0;i<files.length ;i++) {
				System.out.println(files[i]);
			}
		}
	}

	private static void demoFile2() {
		File file = new File("d:"+ File.separator + "99_temp"+File.separator+"capture.PNG");
		if(file.exists()) {
			System.out.println(file.isDirectory());
			System.out.println(file.isFile());
			System.out.println(file.length());
			BigDecimal bigDecimal = new BigDecimal((double)file.length()/1024);
			System.out.println(
					new BigDecimal( (double)file.length()/1024).divide(new BigDecimal(1) , 2 , BigDecimal.ROUND_HALF_UP)+ "KB");
			System.out.println("修正日付："+ new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())) );
		}
	}

	private static void demoFile() {
		// TODO 自動生成されたメソッド・スタブ
		File file = new File("d:"+ File.separator+"99_temp"+File.separator +"demo.txt");
		try {
			if(file.isDirectory()) {
				System.out.println("directory");
			}
			if(file.isFile()) {
				System.out.println("file");
			}
			if(!file.getParentFile().exists()) {
				file.mkdirs();
			}
			if(file.exists()) {
				System.out.println("delete");
				file.delete();
			}else {
				System.out.println("createnewFile");
				file.createNewFile();
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
