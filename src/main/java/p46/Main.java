package p46;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author liuzhengyang
 */
public class Main {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> collect = Arrays.stream(nums).boxed().collect(toList());
        return permute(collect);
    }

    private static List<List<Integer>> permute(List<Integer> nums) {
        if (nums.size() == 1) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(nums.get(0));
            result.add(list);
            return result;
        }
        List<List<Integer>> result = new ArrayList<>();
        nums.forEach(each -> {
            List<Integer> remainder = nums.stream().filter(e -> !Objects.equals(e, each)).collect
                    (toList());
            permute(remainder).forEach(eachResult -> {
                eachResult.add(0, each);
                result.add(eachResult);
            });
        });
        return result;
    }
}
