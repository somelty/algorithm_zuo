package leetcode_100.middle;

import java.util.Arrays;

public class HIndex {

	// 法一：排序 O(nlogn) O(logn)
	public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while(i >= 0 && h < citations[i]) {
        	h++;
        	i--;
        }
        return h;
    }
}
