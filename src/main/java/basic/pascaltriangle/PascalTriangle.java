package basic.pascaltriangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liuzhengyang
 */
public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        System.out.println(pascalTriangle.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return Collections.emptyList();
        }
        List<Integer> prev = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    row.add(1);
                } else {
                    row.add(prev.get(j) + prev.get(j - 1));
                }
            }
            result.add(row);
            prev = row;
        }
        return result;
    }
}
