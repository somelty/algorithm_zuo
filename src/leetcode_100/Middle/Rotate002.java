package leetcode_100.Middle;

// 轮转数组
// https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150
public class Rotate002 {

	// 使用额外数组 (i + k) mod n
	public void solution1(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	arr[(i + k) % nums.length] = nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
        	nums[i] = arr[i];
        }
    }
	
	// 方法二：环状替换
	/**
	 * start=0 的循环覆盖的是：0, 0+k, 0+2k, ... (mod n)
	   start=1 的循环覆盖的是：1, 1+k, 1+2k, ... (mod n)
	 */
	public void solution2(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		int round = gcd(n, k);
		for (int start = 0; start < round; start++) {
			int cur = start;
			int prev = nums[start];
			do {
				// 后面的只需要和 prev 交换
				int next = (cur + k) % n;  
				int temp = nums[next];  
				nums[next] = prev; 
				prev = temp;
				cur = next;
			} while(cur != start);
			
		}
		
	}
	
	// [5, 2, 1, 4, 3, 6, 7]    k = 2
	//  s     n
	//  pre   tp
	
	public int gcd(int a, int b) {
		return b > 0? gcd(b, a % b) :a;
	}
	
	
	// 方法三：反转数组
	public void solution3(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		reverse(nums, 0, n - 1); // 反转前n个
		reverse(nums, 0, k - 1); // 反转前k个
		reverse(nums, k, n - 1); // 反转剩下的
	}
	
	public void reverse(int[] nums, int start, int end) { 
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start ++;
			end --;
		}
	}
	
}
