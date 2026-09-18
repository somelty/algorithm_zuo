/*
 * @Author: Yamin Liu
 * @Date: 2026-07-07 22:37:27
 * @LastEditTime: 2026-07-07 22:52:47
 * @Description: Two Sum
 */
package leetcode_100.Easy;

import java.util.ArrayList;
import java.util.Collection;

public class TwoSum {
  public static void main(String[] args){
    int[] arr = {2, 7, 11, 15};
    int target = 9;
    int[] result = solution3(target, arr);
    System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
  }

  public static int[] solution1(int target, int[] arr){

    for(int i = 0; i < arr.length; i++){
      for(int j = i + 1; j < arr.length; j++){
        if(arr[i] + arr[j] == target){
          return new int[]{i, j};
        }
      }
    }

    return new int[]{-1, -1};
  }

  public static int[] solution2(int target, int[] arr){
    for(int i = 0; i < arr.length; i++){
      int complement = target - arr[i];
      int left = i + 1;
      int right = arr.length - 1;
      while (left <= right){
        int mid = left + (right - left) / 2;
        if(arr[mid] == complement){
          return new int[]{i, mid};
        } else if(arr[mid] < complement){
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return new int[]{-1, -1};
  }

  public static int[] solution3(int target, int[] arr){
    int left = 0;
    int right = arr.length - 1;
    while (left < right){
      int sum = arr[left] + arr[right];
      if (sum == target){
        return new int[]{left, right};
      } else if(sum < target){
        left ++;
      }else {
        right --;
      }
    }
      return new int[]{-1, -1};
  }
}

