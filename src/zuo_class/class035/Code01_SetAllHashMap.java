package zuo_class.class035;

import java.io.*;
import java.util.HashMap;

// setAll功能的哈希表
// 测试链接 : https://www.nowcoder.com/practice/7c4559f138e74ceb9ba57d76fd169967
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过
public class Code01_SetAllHashMap {

    public static int n, opt, k, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            map.clear();
            setAllValue = 0;
            setAllTime = -1;
            cnt = 0;
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                opt = (int) in.nval;
                if (opt == 1) {
                    in.nextToken();
                    k = (int) in.nval;
                    in.nextToken();
                    v = (int) in.nval;
                    put(k, v);
                } else if (opt == 2) {
                    in.nextToken();
                    k = (int) in.nval;
                    out.println(get(k));
                } else {
                    in.nextToken();
                    v = (int) in.nval;
                    setAll(v);
                }
            }
        }
        out.close();
        br.close();
    }

    public static int cnt;
    public static int setAllTime;
    public static int setAllValue;
    public static HashMap<Integer, int[]> map = new HashMap<>();

    public static void setAll(int v) {
        setAllTime = cnt++;
        setAllValue = v;
    }

    public static int get(int k) {
        if (!map.containsKey(k)) {
            return -1;
        }
        if (map.get(k)[1] > setAllTime) {
            return map.get(k)[0];
        }
        return setAllValue;
    }

    public static void put(int k, int v) {
        if (!map.containsKey(k)) {
            map.put(k, new int[]{v, cnt++});
        } else {
            map.get(k)[0] = v;
            map.get(k)[1] = cnt++;
        }
    }
}
