package weekly.contest.week207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/rearrange-spaces-between-words/
 * @author liuzhengyang
 */
public class Problem1 {
    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        System.out.println(problem1.reorderSpaces("a"));
        System.out.println(problem1.reorderSpaces("  this   is  a sentence "));
        System.out.println(problem1.reorderSpaces(" practice   makes   perfect"));
    }

    public String reorderSpaces(String text) {
        int blankCount = 0;
        int wordCount = 0;
        List<String> words = new ArrayList<>();
        char[] chars = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (chars[i] == ' ') {
                blankCount ++;
                if (sb.length() > 0) {
                    words.add(sb.toString());
                    wordCount++;
                    sb = new StringBuilder();
                }
            } else {
                sb.append(chars[i]);
                if (i == text.length() - 1) {
                    words.add(sb.toString());
                    wordCount++;
                }
            }
        }
        if (wordCount == 1) {
            StringBuilder result = new StringBuilder();
            result.append(words.get(0));
            for (int i = 0; i < blankCount; i++) {
                result.append(' ');
            }
            return result.toString();
        }
        int eachInterval = blankCount/(wordCount - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < wordCount; i++) {
            stringBuilder.append(words.get(i));
            if (i != wordCount -1) {
                for (int j = 0; j < eachInterval; j++) {
                    stringBuilder.append(' ');
                }
            }

        }
        for (int i = 0; i < blankCount % (wordCount - 1); i++) {
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }
}
