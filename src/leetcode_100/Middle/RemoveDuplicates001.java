package leetcode_100.Middle;

public class RemoveDuplicates001 {
	
	public int solution(int[] nums) {
        int n = 1;
        int s = 0;
        for (int f = 1; f < nums.length; f++) {
    		if (nums[f] != nums[s]) {
    			n = 1;
    			s++;
    			nums[s] = nums[f];
    		} else {
    			if(n == 1) {
    				s++;
        			nums[s] = nums[f];
    			}
    			n++;
    		}
        	
        }
        return s + 1;
    }
}
