package leetcode_100.middle;

public class HIndex {

	public int hIndex(int[] citations) {
        int h = 0, i = citations.length - 1;
        while(h < citations[i]) {
        	h++;
        	i--;
        }
        return h;
    }
}
