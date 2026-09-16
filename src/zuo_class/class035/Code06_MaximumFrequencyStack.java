package zuo_class.class035;

import java.util.ArrayList;
import java.util.HashMap;

// 最大频率栈
// 测试链接 : https://leetcode.cn/problems/maximum-frequency-stack/
public class Code06_MaximumFrequencyStack {
    class FreqStack {

        private int topTimes;
        // all nums under this count
        private HashMap<Integer, ArrayList<Integer>> cntValues = new HashMap<>();
        // the count related to this num
        private HashMap<Integer, Integer> valueTimes = new HashMap<>();

        public void push(int val) {
            // 次数加进去
            valueTimes.put(val, valueTimes.getOrDefault(val, 0) + 1);
            // 得到这个值对应的次数（后续更新最大值）
            int curTopTimes = valueTimes.get(val);
            // 得到这个次数对应的list，放进去这个数
            if (!cntValues.containsKey(curTopTimes)) {
                cntValues.put(curTopTimes, new ArrayList<>());
            }
            cntValues.get(curTopTimes).add(val);
            // 更新最大数
            topTimes = Math.max(topTimes, curTopTimes);
        }

        public int pop() {
            ArrayList<Integer> topTimeValues = cntValues.get(topTimes);
            int ans = topTimeValues.remove(topTimeValues.size() - 1);
            if (topTimeValues.isEmpty()) {
                cntValues.remove(topTimes--);
            }
            int time = valueTimes.get(ans);
            if (time == 1) {
                valueTimes.remove(ans);
            } else {
                valueTimes.put(ans, time - 1);
            }
            return ans;
        }
    }

}
