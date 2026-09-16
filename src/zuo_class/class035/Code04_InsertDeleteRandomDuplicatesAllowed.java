package zuo_class.class035;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// 插入、删除和获取随机元素O(1)时间且允许有重复数字的结构
// https://leetcode.cn/problems/insert-delete-getrandom-o1-duplicates-allowed/
public class Code04_InsertDeleteRandomDuplicatesAllowed {
    class RandomizedCollection {
        public HashMap<Integer, HashSet<Integer>> map;
        public ArrayList<Integer> arr;

        public RandomizedCollection() {
            map = new HashMap<>();
            arr = new ArrayList<>();
        }

        public boolean insert(int val) {
            arr.add(val);
            // 寻找key val的 值，找到了返回对应value， 找不到返回新的 set
            HashSet<Integer> set = map.getOrDefault(val, new HashSet<Integer>());
            set.add(arr.size() - 1); // 将当前元素在 arr 中的索引添加到set中进行记录
            map.put(val, set);
            return set.size() == 1;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            int endValue = arr.get(arr.size() - 1);
            HashSet<Integer> valIdxSet = map.get(val);
            if (endValue == val) {
                valIdxSet.remove(arr.size() - 1);
            } else {
                int valAnyIdx = valIdxSet.iterator().next();
                arr.set(valAnyIdx, endValue);
                valIdxSet.remove(valAnyIdx);
                HashSet<Integer> endSet = map.get(endValue);
                endSet.remove(arr.size() - 1);
                endSet.add(valAnyIdx);
            }
            arr.remove(arr.size() - 1);
            if (valIdxSet.isEmpty()) {
                map.remove(val);
            }
            return true;
        }
        public int getRandom() {
            return arr.get((int) (Math.random() * arr.size()));
        }
    }
}
