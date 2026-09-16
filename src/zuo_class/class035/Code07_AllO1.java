package zuo_class.class035;

import java.util.HashMap;
import java.util.HashSet;

// 全O(1)的数据结构
// 测试链接 : https://leetcode.cn/problems/all-oone-data-structure/
public class Code07_AllO1 {
    class AllOne {

        class Bucket {
            public HashSet<String> set;
            public int cnt;
            public Bucket last;
            public Bucket next;

            public Bucket(String s, int c) {
                set = new HashSet<>();
                set.add(s);
                cnt = c;
            }
        }

        private void insert(Bucket cur, Bucket pos) {
            cur.next.last = pos;
            pos.next = cur.next;
            cur.next = pos;
            pos.last = cur;
        }

        private void remove(Bucket cur) {
            cur.last.next = cur.next;
            cur.next.last = cur.last;
        }

        Bucket head;
        Bucket tail;
        HashMap<String, Bucket> map;

        public AllOne() {
            head = new Bucket("", 0);
            tail = new Bucket("", Integer.MAX_VALUE);
            head.next = tail;
            tail.last = head;
            map = new HashMap<>();
        }

        public void inc (String key) {
            // 不存在 String
            if (!map.containsKey(key)) {
                if (head.next.cnt == 1) {
                    map.put(key, head.next);
                    head.next.set.add(key);
                } else {
                    Bucket bucket = new Bucket(key, 1);
                    map.put(key, bucket);
                    insert(head, bucket);
                }
            } else {
                // 存在 String
                 Bucket bucket = map.get(key);
                 if (bucket.cnt + 1 == bucket.next.cnt) {
                     map.put(key, bucket.next);
                     bucket.next.set.add(key);
                 } else {
                     Bucket newbucket = new Bucket(key, bucket.cnt + 1);
                     map.put(key, newbucket);
                     insert(bucket, newbucket);
                 }
                 bucket.set.remove(key);
                 if (bucket.set.isEmpty()) {
                     remove(bucket);
                 }
            }
        }

        public void dec (String key) {
            Bucket bucket = map.get(key);
            if (bucket.cnt == 1) {
                map.remove(key);
            } else {
                if (bucket.last.cnt == bucket.cnt - 1) {
                    map.put(key, bucket.last);
                    bucket.last.set.add(key);
                } else {
                    Bucket newBucket = new Bucket(key, bucket.cnt - 1);
                    map.put(key, newBucket);
                    insert(bucket.last, newBucket);
                }
            }
            bucket.set.remove(key);
            if (bucket.set.isEmpty()) {
                remove(bucket);
            }
        }

        public String getMaxKey() {
            return tail.last.set.iterator().next();
        }

        public String getMinKey() {
            return head.last.set.iterator().next();
        }

    }
}
