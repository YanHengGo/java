package com.yanheng.regularexpression;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest {

	public static void main(String[] args) {
		System.out.println("hello world !");

		//一つ文字
		testMatchs("ab","ab");
		testMatchs("\\","\\\\");
		testMatchs("\t","\\t");
		testMatchs("\n","\\n");
		testMatchs("a",".");
		testMatchs("0","\\d"); // \\d  ===  [0-9]
		testMatchs("0","\\w"); // \\w  ===  [a-zA-Z0-9_]
		testMatchs("\n","\\s"); //スペース
		testMatchs("\n","\\S"); //非スペース
		//範囲
		testMatchs("a","[abc]");
		testMatchs("d","[^abc]");
		testMatchs("a","[a-zA-Z]");
		testMatchs("0","[0-9]");
		//回数
		// ? --> 0,1回
		// + --> 1以上
		// * --> 0以上
		// {5} --> 5回
		// {5,} --> 5回以上
		// {5,10} --> 5回以上10回以下
		//ロジック
		testMatchs("a","a|b|\\n");



//		testString();

		testPattern();
		testMatcher();
	}
	private static void testMatcher() {
		String string = "100";
		String regex = "\\d+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		System.out.println(matcher.matches());

		System.out.println(string.matches(regex));

	}
	private static void testPattern() {
		String string = "fa45fs45fs4fs4f5s4f5s4f5s4f5s4f5sr8e7r8";
		String regex = "[^a-zA-Z]+";
		Pattern pattern = Pattern.compile(regex);

		System.out.println(Arrays.toString(pattern.split(string)));

		System.out.println(Arrays.toString(string.split(regex)));
	}
	private static void testMatchs(String target , String pattern) {
		System.out.println(target+"  matches  "+pattern+" --> " +target.matches(pattern));
	}
	/*

	  a   --> a
	 //   --> /



	 */


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
