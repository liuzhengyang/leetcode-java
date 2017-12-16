package p3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liuzhengyang
 */
public class Main {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int maxLength = -1;
        char[] chars = s.toCharArray();
        int startIndex = 0;
        Map<Character, Integer> existChars = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (i < startIndex) {
                continue;
            }
            int end = i;
            boolean containsRepeated = false;
            for (int j = i; j < s.length(); j++) {
                end = j;
                if (existChars.containsKey(chars[j])) {
                    containsRepeated = true;
                    startIndex = existChars.get(chars[j]) + 1;
                    break;
                } else {
                    existChars.put(chars[j], j);
                }
            }
            int length = end - i + (containsRepeated ? 0 : 1);
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }
}
