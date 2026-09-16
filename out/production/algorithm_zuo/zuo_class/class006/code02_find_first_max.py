def find_first_small(arr, num) -> int:
    if arr is None or len(arr) < 1:
        return -1

    left = 0
    right = len(arr) - 1
    ans = -1
    while left <= right:
        mid = left + ((right - left) >> 1)
        if arr[mid] <= num:
            left = mid + 1
        elif arr[mid] > num:
            ans = mid
            right = mid - 1
    return ans


def validate_find_first_small(arr, num) -> int:
    if arr is None or len(arr) < 1:
        return -1

    for i in range(len(arr)):
        if arr[i] > num:
            return i
    return -1


if __name__ == "__main__":
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    num = 5
    print(find_first_small(arr, num))
    print(validate_find_first_small(arr, num))
