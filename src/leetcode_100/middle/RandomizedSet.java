package leetcode_100.middle;

import java.util.*;
public class RandomizedSet {

	List<Integer> nums;
	HashMap<Integer, Integer> map;
	Random r;
	
	public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
        	int index = nums.size();
        	nums.add(val);
        	map.put(val, index);
        	return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val);
        int num = nums.get(nums.size() - 1);
        nums.set(idx, num);
        nums.remove(nums.size() - 1);
        map.put(num, idx);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIdx = r.nextInt(nums.size());
        return nums.get(randomIdx);
    }
}
