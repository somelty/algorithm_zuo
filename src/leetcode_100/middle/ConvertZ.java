package leetcode_100.middle;

import java.util.*;
public class ConvertZ {
	public String convert(String s, int numRows) {
		
		if(numRows < 2) return s;
		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			rows.add(new StringBuilder());
		}
		int i = 0, flag = -1;
		for (char c: s.toCharArray()) {
			rows.get(i).append(c);
			if (i == 0 || i == numRows - 1) {
				flag = -flag;
			}
			i += flag;
		}
		StringBuilder ans = new StringBuilder();
		for (int j = 0; j < numRows; j++) {
			ans.append(rows.get(j));
		}
		return ans.toString();
	}
}
