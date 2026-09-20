package leetcode_100.middle;

public class CanCompleteCircuit {

	public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int cur_total = 0;
        int total = 0;
        int start = 0;
        for(int i = 0; i < n; i++) {
        	cur_total += (gas[i] - cost[i]);
        	total += (gas[i] - cost[i]);
        	if (cur_total < 0) {
        		start = i + 1;
        		cur_total = 0;
        	}
        }
        if (total < 0) return -1;
        return start;
    }
}
