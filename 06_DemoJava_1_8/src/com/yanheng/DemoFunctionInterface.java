package com.yanheng;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;


public class DemoFunctionInterface {

	public static void main(String[] args) {
		// List の forEach  ループの実現
		List<String> list1 = Arrays.asList("こんにちは、","java1.8");
		list1.forEach(Item -> System.out.println(Item.toUpperCase()));

		// HashMap の forEach  ループの実現
		HashMap<String, String> map = new HashMap();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.forEach((key,value) -> System.out.println("key="+key + "  value="+value));

		//String ---> String
		Function<String, String> function = (msg) -> msg.toUpperCase();
		System.out.println(function.apply("fjsljflkjsfjls"));
		//int ----> int
		IntFunction<Integer> intFunction = (i) -> i*456;
		System.out.println(intFunction.apply(100));
		//double ----> int
		DoubleToIntFunction doubleToIntFunction = (d) -> (int)(d*100.0);
		int d = doubleToIntFunction.applyAsInt(1.5);
		System.out.println("result:"+d);

		BiFunction<String, String, String> biFunction = (s1,s2) -> s1 + s2 ;
		System.out.println(biFunction.apply("BiFunction ", "test"));

		BinaryOperator<Integer> binaryOperator = (i1,i2) -> i1 * i2 ;
		System.out.println(binaryOperator.apply(2, 3));

		Predicate<String> predicate = (a) -> a == null;
		System.out.println("result = " + predicate.test(new String()));
		System.out.println("result = " + predicate.test(null));



	}

}
