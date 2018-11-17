package com.yanheng.filedemo;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class WriterDemo {

	public static void main(String[] args) throws Exception {
		File file = new File("d:"+File.separator+"99_temp"+File.separator + "outputstream"+File.separator+"writedemo.txt");
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		demo1(file);
	}

	private static void demo1(File file) throws Exception{
		Writer writer = new FileWriter(file);
		String string = "this is writer demo  \r\n";
		writer.write(string);
		writer.close();

	}

}
