def random_arr(max_size, max_value):
    import random
    random_arr = []
    for i in range(max_size):
        random_arr.append(random.randint(0, max_value))  # 左闭右闭区间
    return random_arr


def exist(arr, num, left, right) -> bool:
    if not arr or len(arr) < 1:
        return False

    if left > right:
        return False
    # left = 0 ctrl k ctrl c
    # right = len(arr) - 1
    mid = left + ((right - left) >> 1)
    if arr[mid] == num:
        return True
    elif arr[mid] < num:
        # 不加 return，默认最后即使最后找到返回true，由于没有 return，它会默认返回 null
        return exist(arr, num, mid + 1, right)
    else:
        return exist(arr, num, left, mid - 1)


def exist2(arr, num) -> bool:
    if not arr or len(arr) < 1:
        return False

    left = 0
    right = len(arr) - 1
    while left <= right:
        mid = left + ((right - left) >> 1)
        if arr[mid] == num:
            return True
        elif arr[mid] < num:
            left = mid + 1
        else:
            right = mid - 1

    return False


if __name__ == "__main__":
    arr = random_arr(10, 100)
    arr.sort()
    print(arr)

    if exist(arr, 50, 0, len(arr) - 1) != exist2(arr, 50):
        print("Oops!")
        print(exist(arr, 50, 0, len(arr) - 1))
        print(exist2(arr, 50))
        exit(0)

    print(exist(arr, 50, 0, len(arr) - 1))
    print(exist2(arr, 50))
