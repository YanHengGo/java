package com.yanheng;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

public class TestDemo2 {
  /**
   * Iterate through each line of input.
 * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line = "";
    ArrayList<InputHolder> inputHolders = new ArrayList<>();
    String lineNum = in.readLine();
    int count = Integer.parseInt(lineNum);
	while ((line = in.readLine()) != null) {
		InputHolder item = new InputHolder();
		item.input = line;
		String tmp = line.replace(" ", "");
		item.count=tmp.length();
		inputHolders.add(item);
		count--;
	    if(count==0)break;
	}
	for(InputHolder inputHolder : inputHolders) {
		L.d("name="+inputHolder.input + "  count="+inputHolder.count);
	}
	L.d("------------------------------");
	Collections.sort(inputHolders);
	for(InputHolder inputHolder : inputHolders) {
		L.d("name="+inputHolder.input + "  count="+inputHolder.count);
	}
  }
}

class InputHolder implements Comparable<InputHolder>{
	String input;
	int count;

	@Override
	public int compareTo(InputHolder o) {
		// TODO 自動生成されたメソッド・スタブ
		return this.count-o.count;
	}

}
