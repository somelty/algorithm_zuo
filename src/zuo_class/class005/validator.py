'''
Author: Yamin Liu
Date: 2026-07-05 20:50:11
LastEditTime: 2026-07-05 21:12:23
Description: 对数器验证三种排序
'''
'''
Author: Yamin Liu
Date: 2026-07-05 20:07:54
LastEditTime: 2026-07-05 20:45:25
Description: Selection Sort, Insertion Sort, Bubble Sort
'''


def copy_array(arr):
    """
    @Description: 为了验证
    """
    new_arr = []
    for i in arr:
        new_arr.append(i)
    return new_arr


def same_array(arr1, arr2) -> bool:
    if len(arr1) != len(arr2):
        return False

    for i in range(len(arr1)):
        if arr1[i] != arr2[i]:
            return False

    return True


def random_array(max_size, max_value):
    random_arr = []
    import random
    for i in range(max_size):
        random_arr.append(random.randint(0, max_value))  # 左闭右闭区间
    return random_arr


def selection_sort(arr):
    if not arr or len(arr) < 2:
        return arr

    for i in range(len(arr)):
        min_index = i
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[min_index]:
                arr[j], arr[min_index] = arr[min_index], arr[j]

    return arr


def insertion_sort(arr):
    if not arr or len(arr) < 2:
        return arr

    for i in range(1, len(arr)):
        for j in range(i - 1, -1, -1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]

    return arr


def bubble_sort(arr):
    if not arr or len(arr) < 2:
        return arr

    for i in range(len(arr) - 1, -1, -1):
        for j in range(0, i):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]

    return arr


if __name__ == "__main__":
    max_size = 10
    max_value = 50
    test_times = 10000

    print("start")
    for i in range(test_times):
        arr = random_array(max_size, max_value)
        arr1 = copy_array(arr)
        arr2 = copy_array(arr)  # shift alt ⬇
        arr3 = copy_array(arr)

        selection_sort(arr1)
        insertion_sort(arr2)
        bubble_sort(arr3)

        if not same_array(arr1, arr2) or not same_array(arr1, arr3):
            print("error")
            print(arr1)
            print(arr2)
            print(arr3)
            break

    print("finish")
