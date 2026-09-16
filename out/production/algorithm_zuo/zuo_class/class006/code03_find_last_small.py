'''
Author: Yamin Liu
Date: 2026-07-05 22:42:11
LastEditTime: 2026-07-05 22:58:35
Description: 
'''


def find_first_small(arr, num) -> int:
    if not arr or len(arr) < 1:
        return -1

    left = 0
    right = len(arr) - 1
    ans = -1
    while left <= right:
        mid = left + ((right - left) >> 1)
        if arr[mid] < num:
            ans = mid
            left = mid + 1
        elif arr[mid] >= num:
            right = mid - 1

    return ans


def validate_find_first_small(arr, num) -> int:
    if not arr or len(arr) < 1:
        return -1

    for i in range(len(arr) - 1, -1, -1):
        if arr[i] < num:
            return i
    return -1


if __name__ == "__main__":
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    num = 5
    print(find_first_small(arr, num))
    print(validate_find_first_small(arr, num))
