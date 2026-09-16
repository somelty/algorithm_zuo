package zuo_class.class035;

import java.util.ArrayList;
import java.util.HashMap;

// 插入、删除和获取随机元素O(1)时间的结构，元素不重复
// 测试链接 : https://leetcode.cn/problems/insert-delete-getrandom-o1/
public class Code03_InsertDeleteRandom {
    class RandomizedSet {
        public HashMap<Integer, Integer> map;
        public ArrayList<Integer> arr;

        public RandomizedSet() {
            map = new HashMap<>();
            arr = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, arr.size());
            arr.add(val);
            return true;
        }
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int idx = map.get(val);
            int endIdx = arr.get(arr.size() - 1);
            arr.set(idx, endIdx);
            map.put(endIdx, idx);
            arr.remove(arr.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            // Math.random() 返回一个 double 类型的伪随机数，范围是 [0.0, 1.0)
            return arr.get((int) (Math.random() * arr.size()));
        }
    }
}
