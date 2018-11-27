package com.yanheng;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class TestDemo {
  /**
   * Iterate through each line of input.
 * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line = "";
    int count = 0;

	  HashMap<String, Integer> table = new HashMap<>();
	  {
		  table.put("zero", 0);
		  table.put("one", 1);
		  table.put("two", 2);
		  table.put("three", 3);
		  table.put("four", 4);
		  table.put("five", 5);
		  table.put("six", 6);
		  table.put("seven", 7);
		  table.put("eight", 8);
		  table.put("nine", 9);
	  }

	while ((line = in.readLine()) != null) {
	    count++;
	    if(count==1)break;
	}
    String[] split = line.split(",");
    int output=0;
    for (String string : split) {
    	int tmp = table.get(string);
    	output = output*10+tmp;
	}
    System.out.println(String.valueOf(output));
  }
  //input one,two,zero
}
