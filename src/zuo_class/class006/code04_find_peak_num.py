'''
Author: Yamin Liu
Date: 2026-07-05 23:04:04
LastEditTime: 2026-07-05 23:08:27
Description: 在一个数组中找到峰值元素的索引
'''
# 峰值元素是指其值严格大于左右相邻值的元素
# 给你一个整数数组 nums，已知任何两个相邻的值都不相等
# 找到峰值元素并返回其索引
# 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
# 你可以假设 nums[-1] = nums[n] = 无穷小
# 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。


def find_peak_element(arr, nums) -> int:
    if not arr or len(arr) < 1:
        return -1

    left = 0
    right = len(arr) - 1

    if arr[left] > arr[left + 1]:
        return left
    if arr[right] > arr[right - 1]:
        return right

    while left < right:
        mid = left + ((right - left) >> 1)
        if arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1]:
            return mid
        elif arr[mid] < arr[mid + 1]:
            left = mid + 1
        else:
            right = mid - 1

    return -1


if __name__ == "__main__":
    arr = [1, 2, 3, 1]
    print(find_peak_element(arr, len(arr)))
