package com.yanheng.regularexpression;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class MainTest {

	public static void main(String[] args) {
		System.out.println("hello world !");
		testString();
	}


	private static void testString() {
		/**
		 * --------  replace のテスト
		 */
		testReplace();
		/**
		 * --------  split のテスト
		 */
		testSplit();

		/**
		 * --------  matches のテスト
		 */
		//小数のマッチング
		testMatchDouble();
		//Dateのマッチング
		testMatchDate();
		//電話番号のマッチング
		testMatchTellphoneNumber();
		//Emailのマッチング
		testMatchEmail();
	}


	/**
	 * アルファベット以外は除外する。
	 * [^a-zA-Z]    -->アルファベット
	 * \\w          -->アルファベット
	 */
	private static void testReplace() {
		String str = "fjslru7974294jlsjfJLJL+;]:@:UOIUO";
		String regex = "[^a-zA-Z]";
		System.out.println(str.replaceAll(regex, ""));
	}

	/**
	 * 数字をで分けて配列にする。
	 * [0-9]+    -->数字多数
	 * \\d+      -->数字多数
	 */
	private static void testSplit() {
		String str = "jfslj47924fjslk24729djldja492824[]";
		String regex = "[0-9]+";
		System.out.println(Arrays.toString(str.split(regex)));
	}

	/**
	 * \\d+              -->数字多数個
	 * \\.               -->.
	 * (\\.\\d+)?        -->括弧内は０個または１個
	 *
	 */
	private static void testMatchDouble() {
		String str = "10";
		String regex = "\\d+(\\.\\d+)?";
		if(str.matches(regex)) {
			System.out.println(Double.parseDouble(str));
		}else {
			System.out.println("double ではない");
		}
	}

	/**
	 * \\d{4}   -->数字4個
	 * \\d{2}   -->数字2個
	 * \\-      -->-
	 */
	private static void testMatchDate() {
		String str = "2019-09-10";
		String regex = "\\d{4}\\-\\d{2}\\-\\d{2}";
		if(str.matches(regex)) {
			try {
				System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(str));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("date ではない");
		}
	}
	/**
	 * \\d{10,12}   -->数字10-12個
	 * \\d{3,5}     -->数字3-5個
	 * -            -->-
	 */
	private static void testMatchTellphoneNumber() {
		String str = "080-1111-1111";
		String regex1 = "\\d{10,12}";
		String regex2 = "\\d{3,5}-\\d{3,5}-\\d{3,5}";
		if(str.matches(regex1) || str.matches(regex2)) {
			System.out.println(str);
		}else {
			System.out.println("電話番号 ではない");
		}
	}


	/**
	 * \\w+                  -->アルファベット多数個
	 * [a-zA-Z]              -->アルファベット多数個
	 * @                     -->@
	 * \\.                   -->.
	 * \\-                   -->-
	 * \\_                   -->_
	 * [a-zA-Z0-9\\_\\-\\.]  -->アルファベットまたは_-.
	 */
	private static void testMatchEmail() {
		String str = "aaafsjkjfsk@a.b_c-d.com";
		String regex = "[a-zA-Z][a-zA-Z0-9\\_\\-\\.]{5,29}@[a-zA-Z0-9\\_\\-\\.]+\\.\\w+";

		if(str.matches(regex)) {
			System.out.println(str);
		}else {
			System.out.println("E-mail ではない");
		}
	}

}
