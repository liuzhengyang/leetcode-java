package strings;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        String result = new RemoveAllAdjacentDuplicatesInString().removeDuplicates("abbaca");
        System.out.println(result);
    }

    public String removeDuplicates(String S) {
        if (S == null || S.isEmpty()) {
            return S;
        }
        char[] chars = S.toCharArray();
        boolean[] removed = new boolean[chars.length];
        boolean hasDuplicate = true;
        while (hasDuplicate) {
            boolean thisContainsDuplicated = false;
            int prevIndex = -1;
            for (int i = 0; i < chars.length; i++) {
                if (removed[i]) {
                    continue;
                }
                if (prevIndex == -1) {
                    prevIndex = i;
                } else {
                    if (chars[prevIndex] == chars[i]) {
                        removed[prevIndex] = true;
                        removed[i] = true;
                        thisContainsDuplicated = true;
                        break;
                    } else {
                        prevIndex = i;
                    }
                }
            }
            hasDuplicate = thisContainsDuplicated;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (!removed[i]) {
                result.append(chars[i]);
            }
        }
        return result.toString();
    }
}
