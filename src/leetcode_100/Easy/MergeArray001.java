package leetcode_100.Easy;

import java.util.Arrays;

// 合并两个有序数组
// https://leetcode.cn/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
public class MergeArray001 {

	// 方法一：先将 nums2 放在 nums1 后面，然后排序
	public static void solution1(int[] nums1, int m, int[] nums2, int n) {
		for (int i = 0; i < n; i++) {
			nums1[m++] = nums2[i];
		}
		Arrays.sort(nums1);
	}
	
	// 方法一没有利用数组 nums1 与 nums2 已经被排序的性质
	// 为了利用这一性质，我们可以使用双指针方法
	public static void solution2(int[] nums1, int m, int[] nums2, int n) {
		int[] arr = new int[m + n];
		int l1 = 0, l2 = 0;
		int i = 0;
		while(l1 < m && l2 < n) {
			if (nums1[l1] <= nums2[l2]) {
				arr[i++] = nums1[l1];
				l1++;
			} else {
				arr[i++] = nums2[l2];
				l2++;
			}
		}
		while (l1 < m) {
			arr[i++] = nums1[l1++];
		} 
		while (l2 < n) {
			arr[i++] = nums2[l2++];
		}
		
		for (int j = 0; j < n+m; j++) {
			nums1[j] = arr[j];
		}
	}
	
	public static void solution2v2(int[] nums1, int m, int[] nums2, int n) {
		int[] arr = new int[m + n];
		int l1 = 0, l2 = 0;
		int i = 0;
		while(l1 < m || l2 < n) {
			if(l1 == m) {
				arr[i++] = nums2[l2++];
			} else if(l2 == n) {
				arr[i++] = nums1[l1++];
			}
			else if (nums1[l1] <= nums2[l2]) {
				arr[i++] = nums1[l1];
				l1++;
			} else {
				arr[i++] = nums2[l2];
				l2++;
			}
		}
		
		for (int j = 0; j < n+m; j++) {
			nums1[j] = arr[j];
		}
	}
	
	// 方法三：方法二是利用arr防止覆盖nums1，逆向指针利用 nums1 后面的空位
	public static void solution3(int[] nums1, int m, int[] nums2, int n) {
		int l1 = m - 1, l2 = n - 1;
		int cur = m + n - 1;
		while(l1 >= 0 || l2 >= 0) {
			if (l1 < 0) {
				nums1[cur--] = nums2[l2--];
			} else if(l2 < 0) {
				nums1[cur--] = nums1[l1--];
			} else if(nums1[l1] >= nums2[l2]) {
				nums1[cur--] = nums1[l1--];
			} else {
				nums1[cur--] = nums2[l2--];
			}
		}
	}
}




/**
 * Java 排序：
 * 基本数组类型：底层双轴快排：不稳定，平均时间O(nlogn)，最坏O(n^2) 空间O(logn)
 * 对象数组：TimSort：稳定， 时间：O(nlogn),最好O(n) 空间O(n)
 * Collection.sort(): 先把list里元素复制到数组，然后调用对象数组排序方式排序，最后复制到list
 */
