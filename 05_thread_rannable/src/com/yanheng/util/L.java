package com.yanheng.util;

import java.util.regex.Pattern;
/**
 * ログ出力クラス。<br>
 * ログを出力する場合には必ず本クラスを使用すること。 <br>
 * リリース時には、デバックログを出力しないよう設定する。
 *
 */
public class L {

	/**
     * デバック用ログを出力するフラグ
     * @param DEBUG_FLAG true:ログを出力　false:ログを出力しない
     */
	private static Boolean DEBUG_FLAG = true;

    public static void d() {
        if(DEBUG_FLAG == true){
            d("");
        }
    }
    public static void d(String msg) {
        if(DEBUG_FLAG == true){
            System.out.println((getTag()+ "   gentest ::"+msg));
        }
    }
    /**
     * タグを生成する
     *
     * @return className#methodName:line
     */
    private static String getTag() {
        final StackTraceElement trace = Thread.currentThread().getStackTrace()[3];
        final String cla = trace.getClassName();
        Pattern pattern = Pattern.compile("[\\.]+");
        final String[] splitedStr = pattern.split(cla);
        final String simpleClass = splitedStr[splitedStr.length - 1];
        final String mthd = trace.getMethodName();
        final int line = trace.getLineNumber();
        final String tag = simpleClass + "#" + mthd + ":" + line;
        return tag +
        		"   thread name:"+Thread.currentThread().getName() +
        		"   thread id:"+Thread.currentThread().getId()
        		;
    }
}