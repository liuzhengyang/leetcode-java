package weekly.contest.week206;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author liuzhengyang
 */
public class Problem4 {
    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        System.out.println(problem4.isTransformable("84532", "34852"));
        System.out.println(problem4.isTransformable("12345", "12435"));
    }

    public boolean isTransformable(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        char[] charsOfS = s.toCharArray();
        char[] charsOfT = t.toCharArray();
        Arrays.sort(charsOfS);
        Arrays.sort(charsOfT);
        if (!Arrays.equals(charsOfS, charsOfT)) {
            return false;
        }
        // 每个数字前比它值小的数字的个数，在转换后要增加或不变，不能减少
        // 统计count[len][10] 表示s中i前面的各个数字的数量
        // 统计countT[len][10] 表示t中i前面的各个数字的数量
        // 对于每个i，如果是s中第n个digit，找到t中第n个digit，检查countS[i][any] <= countS[t][any]
//        int[][][] countMapOfS = new int[s.length()][][];
        Map<Integer, List<int[]>> countMapOfS = new HashMap<>();
        Map<Integer, List<int[]>> countMapOfT = new HashMap<>();
        char[] charsS = s.toCharArray();
        int[] charCountS = new int[10];
        for (int i = 0; i < charsS.length; i++) {
            int[] newCountArray = Arrays.copyOf(charCountS, charCountS.length);
            countMapOfS.computeIfAbsent(charsS[i] - '0', k -> new ArrayList<>())
                    .add(newCountArray);
            charCountS[charsS[i] - '0'] += 1;
        }
        int[] charCountT = new int[10];
        char[] charsT = t.toCharArray();
        for (int i = 0; i < charsT.length; i++) {
            int[] newCountArray = Arrays.copyOf(charCountT, charCountT.length);
            countMapOfT.computeIfAbsent(charsT[i] - '0', k -> new ArrayList<>())
                    .add(newCountArray);
            charCountT[charsT[i] - '0'] += 1;
        }
        AtomicBoolean match = new AtomicBoolean(true);
        countMapOfT.forEach((num, list) -> {
            List<int[]> listOfS = countMapOfS.get(num);
            for (int i = 0; i < list.size(); i++) {
                int[] intInT = list.get(i);
                int[] intS = listOfS.get(i);
                for (int j = 0; j < num; j++) {
                    if (intInT[j] < intS[j]) {
                         match.set(false);
                         break;
                    }
                }
            }
        });
        return match.get();
    }
}
