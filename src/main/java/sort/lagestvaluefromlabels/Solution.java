package sort.lagestvaluefromlabels;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        if (values == null || values.length == 0) {
            return 0;
        }
        List<Label> labelList = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            Label label = new Label(values[i], labels[i]);
            labelList.add(label);
        }
        Map<Integer, Integer> labelCount = new HashMap<>();
        labelList.sort(new Comparator<Label>() {
            @Override
            public int compare(Label o1, Label o2) {
                return Integer.compare(o2.value, o1.value);
            }
        });
        int result = 0;
        int totalCount = 0;
        for (Label label : labelList) {
            if (totalCount >= num_wanted) {
                break;
            }
            Integer count = labelCount.getOrDefault(label.label, 0);
            if (count >= use_limit) {
                continue;
            }
            result += label.value;
            totalCount++;
            labelCount.put(label.label, count + 1);
        }
        return result;
    }

    static class Label {
        int value;
        int label;

        public Label(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestValsFromLabels(new int[]{9,8,8,7,6}, new int[]{0,0,0,1,1}, 3, 1));
        System.out.println(solution.largestValsFromLabels(new int[]{9,8,8,7,6}, new int[]{0,0,0,1,1}, 3, 2));
    }
}
