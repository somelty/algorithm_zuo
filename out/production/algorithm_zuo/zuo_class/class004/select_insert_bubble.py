'''
Author: Yamin Liu
Date: 2026-07-05 20:07:54
LastEditTime: 2026-07-05 20:45:25
Description: Selection Sort, Insertion Sort, Bubble Sort
'''


def selection_sort(arr):
    if not arr or len(arr) < 2:
        return arr

    for i in range(len(arr) - 1):
        min_index = i
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[min_index]:
                min_index = j
            arr[i], arr[min_index] = arr[min_index], arr[i]

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

    for i in range(len(arr), -1, -1):
        for j in range(0, i):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]

    return arr
