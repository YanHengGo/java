package com.yanheng.listdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListDemo {
	public static void main(String[] args) {
		demoArrayList();
		demoVictor();
		demoArrayLinkedList();
	}

	private static void demoArrayLinkedList() {
		LinkedList<String> list = new LinkedList<String>();
		list.add("hello1");
		list.add("hello2");
		list.push("push1");
		list.add("hello3");
		list.add("yanheng");
		list.push("push2");
		list.poll();

		System.out.println(Arrays.toString(list.toArray()));
	}

	private static void demoVictor() {
		List<String> list = new Vector<String>();
		list.add("hello");
		list.add("hello");
		list.add("hello");
		list.add("yanheng");

		System.out.println(Arrays.toString(list.toArray()));
	}

	private static void demoArrayList() {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("hello");
		list.add("hello");
		list.add("yanheng");

		System.out.println(Arrays.toString(list.toArray()));

	}
}
