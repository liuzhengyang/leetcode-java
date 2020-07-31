package basic.pascaltriangle2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liuzhengyang
 */
public class PascalTriangle2 {
    public static void main(String[] args) {
        PascalTriangle2 pascalTriangle2 = new PascalTriangle2();
        System.out.println(pascalTriangle2.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return Collections.emptyList();
        }
        if (rowIndex == 0) {
            List<Integer> result = new ArrayList<>();
            result.add(1);
            return result;
        }
        int[] prevArray = new int[rowIndex + 1];
        int[] nextArray = new int[rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    nextArray[j] = 1;
                } else {
                    nextArray[j] = prevArray[j] + prevArray[j - 1];
                }
            }
            prevArray = nextArray;
            nextArray = prevArray;
        }
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int n : nextArray) {
            result.add(n);
        }
        return result;
    }
}
