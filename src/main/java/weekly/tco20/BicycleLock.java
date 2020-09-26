package weekly.tco20;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuzhengyang
 */
public class BicycleLock {
    public String makeDistinct(int[] dials) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> existedDigits = new HashSet<>();
        for (int i = 0; i < dials.length; i++) {
            if (i == 0) {
                sb.append(">");
                existedDigits.add(dials[i]);
            } else {
                int targetNum;
                if (existedDigits.contains(dials[i])) {
                    targetNum = dials[i];
                    int count = 0;
                    for (int j = dials[i] + 1;; j++) {
                        count ++;
                        if (j == 10) {
                            j = 0;
                        }
                        if (!existedDigits.contains(j)) {
                            targetNum = j;
                        } else {
                            break;
                        }
                    }
                    for (int j = 0; j < count; j++) {
                        sb.append("+");
                    }
                } else {
                    targetNum = dials[i];
                }
                existedDigits.add(targetNum);
                if (i < dials.length - 1) {
                    sb.append(">");
                }
            }
        }
        return sb.toString();
    }
}
